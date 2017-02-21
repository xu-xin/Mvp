package com.itheima.vmplayer.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.itheima.vmplayer.R;
import com.itheima.vmplayer.bean.VideoBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by xx on 2017/2/17.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    private Context mContext;
    private List<VideoBean> mdatas;
    private int mWidth,mHeight;

    public HomeAdapter(Context context, List<VideoBean> mdatas, int width, int height) {
        mContext = context;
        this.mdatas = mdatas;
        mWidth = width;
        mHeight = height;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.homepage_item, null);
        return new HomeViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return mdatas.size();
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
        VideoBean videoBean = mdatas.get(position);
        ViewGroup.LayoutParams layoutParams = holder.mIvContentimg.getLayoutParams();
        layoutParams.width = this.mWidth;
        layoutParams.height = this.mHeight;
        holder.mViewbg.setLayoutParams(layoutParams);

        holder.mTvDescription.setText(videoBean.getDescription());
        holder.mTvTitle.setText(videoBean.getTitle());
        Glide.with(mContext).load(videoBean.getPosterPic()).into(holder.mIvContentimg);
    }

    class HomeViewHolder extends RecyclerView.ViewHolder {
        public HomeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @BindView(R.id.iv_item_logo)
        ImageView mIvItemLogo;
        @BindView(R.id.iv_contentimg)
        ImageView mIvContentimg;
        @BindView(R.id.viewbg)
        View mViewbg;
        @BindView(R.id.iv_type)
        ImageView mIvType;
        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.tv_description)
        TextView mTvDescription;

    }


}


