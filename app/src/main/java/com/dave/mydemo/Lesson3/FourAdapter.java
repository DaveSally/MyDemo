package com.dave.mydemo.Lesson3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dave.mydemo.R;

import java.util.List;

/**
 * @author : dave on 2018/9/29 10:47:56
 * e-mail  : dave.dai@morningtech.com
 * desc    : description
 * version : version
 */
public class FourAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_TEXT = 0;
    public static final int TYPE_IMAGE = 1;
    public static final int TYPE_COLOR = 2;

    private List<FourData> mData;
    private Context mContext;

    public FourAdapter(Context mContext, List<FourData> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view;
        switch (viewType) {
            case TYPE_TEXT:
                view = LayoutInflater.from(mContext).inflate(R.layout.item_four, viewGroup, false);
                return new TextViewHolder(view);
            case TYPE_IMAGE:
                view = LayoutInflater.from(mContext).inflate(R.layout.item_image, viewGroup, false);
                return new ImageViewHolder(view);
            case TYPE_COLOR:
                view = LayoutInflater.from(mContext).inflate(R.layout.item_color, viewGroup, false);
                return new ColorViewHolder(view);
            default:
                return null;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getViewType();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FourData fourData = mData.get(position);
        switch (fourData.getViewType()) {
            case TYPE_TEXT:
                TextViewHolder textViewHolder = (TextViewHolder) holder;
                textViewHolder.mTextView.setText(fourData.getTitle());
                break;
            case TYPE_IMAGE:
                ImageViewHolder imageViewHolder = (ImageViewHolder) holder;
                break;
            case TYPE_COLOR:
                ColorViewHolder colorViewHolder = (ColorViewHolder) holder;
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class TextViewHolder extends RecyclerView.ViewHolder {

        TextView mTextView;

        public TextViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.tv_title);
        }
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {

        ImageView mIvImage;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            mIvImage = itemView.findViewById(R.id.iv_image);
        }
    }

    class ColorViewHolder extends RecyclerView.ViewHolder {

        public ColorViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
