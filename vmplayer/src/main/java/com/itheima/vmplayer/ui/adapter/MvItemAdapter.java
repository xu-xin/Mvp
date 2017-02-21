package com.itheima.vmplayer.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.itheima.vmplayer.R;
import com.itheima.vmplayer.bean.ItemBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xx on 2017/2/18.
 */

public class MvItemAdapter extends RecyclerView.Adapter<MvItemAdapter.MyViewHolder> {

    private Context mContext;
    private List<ItemBean> mDatas;
    private int mWidth, mHeight;

    public MvItemAdapter(Context context, List<ItemBean> datas, int width, int height) {
        mContext = context;
        mDatas = datas;
        mWidth = width;
        mHeight = height;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.fragment_mvitem_adapter, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ItemBean itemBean = mDatas.get(position);
        ViewGroup.LayoutParams layoutParams = holder.mIvPostimg.getLayoutParams();
        layoutParams.width = mWidth;
        layoutParams.height = mHeight;
        holder.mViewbgs.setLayoutParams(layoutParams);

        holder.mTitle.setText(itemBean.getTitle());
        holder.mTvDescription.setText(itemBean.getDescription());
        Glide.with(mContext).load(itemBean.getPosterPic()).into(holder.mIvPostimg);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_postimg)
        ImageView mIvPostimg;
        @BindView(R.id.viewbgs)
        View mViewbgs;
        @BindView(R.id.title)
        TextView mTitle;
        @BindView(R.id.author)
        TextView mAuthor;
        @BindView(R.id.tv_description)
        TextView mTvDescription;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }


    }
}
