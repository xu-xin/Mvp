package com.itheima.vmplayer.http;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by xx on 2017/2/16.
 */

public class HttpManager {

    public static HttpManager mHttpManager;
    private OkHttpClient mOkHttpClient;
    private Gson gson;
    private Handler mHandler;

    private Map<String, String> params = new HashMap<>();

    private HttpManager() {
        mOkHttpClient = new OkHttpClient();
        mOkHttpClient.newBuilder().connectTimeout(10, TimeUnit.SECONDS);
        mOkHttpClient.newBuilder().writeTimeout(10, TimeUnit.SECONDS);
        mOkHttpClient.newBuilder().readTimeout(10, TimeUnit.SECONDS);

        gson = new Gson();

        mHandler = new Handler(Looper.getMainLooper());
    }

    public static HttpManager getHttpManager() {
        if (mHttpManager == null) {
            synchronized (HttpManager.class) {
                mHttpManager = new HttpManager();
            }
        }
        return mHttpManager;
    }

    public void get(String url, HttpCallBack httpCallBack) {
        Request request = buildRequest(url, RequestType.GET);
        doRequest(request, httpCallBack);
    }

    public void post(String url, HttpCallBack httpCallBack) {
        Request request = buildRequest(url, RequestType.POST);
        doRequest(request, httpCallBack);
    }

    private Request buildRequest(String url, RequestType type) {
        Request.Builder builder = new Request.Builder();
        if (type == RequestType.GET) {
            url = getUrlbyParams(url);
            builder.get();
        } else if (type == RequestType.POST) {
            RequestBody requestBody = buildRequestBody();
            builder.post(requestBody);
        }
        builder.url(url);
        return builder.build();
    }

    private String getUrlbyParams(String url) {
        if (params == null || params.size() < 1) {
            return url;
        }
        StringBuffer sb = new StringBuffer();
        sb.append(url).append("&");

        for (Map.Entry<String, String> entry : params.entrySet()) {
            sb.append(entry.getKey() + "=" + entry.getValue() + "&");
        }


        return sb.toString().substring(0,sb.toString().length()-1);
    }

    private RequestBody buildRequestBody() {
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            builder.add(entry.getKey(), entry.getValue());
        }
        return builder.build();
    }

    public HttpManager addParam(String key, String value) {
        params.put(key, value);
        return this;
    }

    enum RequestType {
        GET, POST
    }


    void doRequest(Request request, final HttpCallBack httpCallBack) {
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
//                httpCallBack.onFailure(call,e);

                sendFailure(httpCallBack, call, e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
//                    httpCallBack.onsuccess(response);
                    String json = response.body().string();
//                    Object obj = gson.fromJson(json, httpCallBack.mType);
//                    httpCallBack.onsuccess(obj);

                    sendSuccess(httpCallBack, call, json);
                } else {
//                    httpCallBack.onFailure(call, new IOException("server response error"));
                    sendFailure(httpCallBack, call, new IOException("server response error"));
                }
            }
        });
    }

    private void sendSuccess(final HttpCallBack httpCallBack, final Call call, final String json) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                try {
                    if (httpCallBack.mType == String.class) {
                        httpCallBack.onsuccess(json);
                    } else {
                        Object obj = gson.fromJson(json, httpCallBack.mType);
                        httpCallBack.onsuccess(obj);
                    }

                } catch (JsonSyntaxException e) {
                    e.printStackTrace();
                    httpCallBack.onFailure(call,e);
                }
            }
        });
    }

    private void sendFailure(final HttpCallBack httpCallBack, final Call call, final IOException e) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                httpCallBack.onFailure(call, e);
            }
        });
    }

}
