package com.itheima.vmplayer.http;

import com.google.gson.internal.$Gson$Types;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Call;

/**
 * Created by xx on 2017/2/16.
 */

public abstract class HttpCallBack<T> {
    Type mType;

    static Type getSuperclassTypeParameter(Class<?> subclass)
    {
        Type superclass = subclass.getGenericSuperclass();
        if (superclass instanceof Class)
        {
            throw new RuntimeException("Missing type parameter.");
        }
        ParameterizedType parameterized = (ParameterizedType) superclass;
        return $Gson$Types.canonicalize(parameterized.getActualTypeArguments()[0]);
    }

    public HttpCallBack() {
        mType = getSuperclassTypeParameter(getClass());
    }

    public abstract void onsuccess(T bean);
    public abstract void onFailure(Call call, Exception e);
}
