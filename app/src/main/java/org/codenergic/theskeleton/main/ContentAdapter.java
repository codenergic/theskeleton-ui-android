package org.codenergic.theskeleton.main;

import org.codenergic.theskeleton.R;
import org.codenergic.theskeleton.model.PostModel;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by diasa on 11/8/17.
 */
public class ContentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private OnItemClickListener onItemClickListener;

    private List<PostModel> posts;

    public ContentAdapter(List<PostModel> posts, OnItemClickListener onItemClickListener) {
        this.posts = posts;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                return new ContentAdapter.ViewHolderPost(LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.item_card_post, parent, false), parent, onItemClickListener);
            case 1:
                return new ContentAdapter.ViewHolderReview(LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.item_card_review, parent, false), parent, onItemClickListener);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case 0:
                ((ViewHolderPost) holder).bindData(posts.get(position), position);
                break;
            case 1:
                ((ViewHolderReview) holder).bindData(posts.get(position), position);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return posts.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public static class ViewHolderPost extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_post)
        public ImageView ivPost;

        @BindView(R.id.tv_title)
        public TextView tvTitle;

        private OnItemClickListener onItemClickListener;

        public ViewHolderPost(View itemView, ViewGroup parent,
            OnItemClickListener onItemClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.onItemClickListener = onItemClickListener;
        }

        public void bindData(PostModel postModel, int position) {
            tvTitle.setText(postModel.getTitle());
            ivPost.setImageResource(R.drawable.post);
            itemView.setOnClickListener(v -> onItemClickListener.onItemClick(position));
        }
    }

    public static class ViewHolderReview extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_post)
        public ImageView ivPost;

        @BindView(R.id.tv_content)
        public TextView tvContent;

        @BindView(R.id.tv_title)
        public TextView tvTitle;

        @BindView(R.id.tv_type)
        public TextView tvType;

        private OnItemClickListener onItemClickListener;

        public ViewHolderReview(View itemView, ViewGroup parent,
            OnItemClickListener onItemClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.onItemClickListener = onItemClickListener;
        }

        public void bindData(PostModel postModel, int position) {
            tvTitle.setText(postModel.getTitle());
            tvContent.setText(postModel.getShortContent());
            ivPost.setImageResource(R.drawable.book);
            tvType.setText("(Book)");
            itemView.setOnClickListener(v -> onItemClickListener.onItemClick(position));
        }
    }
}
