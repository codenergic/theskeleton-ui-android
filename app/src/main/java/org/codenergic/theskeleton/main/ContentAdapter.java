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

/**
 * Created by diasa on 11/8/17.
 */
public class ContentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private OnItemClickListener onItemClickListener;

    private List<PostModel> post;

    public ContentAdapter(List<PostModel> posts, OnItemClickListener onItemClickListener) {
        this.post = posts;
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
                ((ViewHolderPost) holder).bindData(post.get(position), position);
                break;
            case 1:
                ((ViewHolderReview) holder).bindData(post.get(position), position);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return post.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return post.size();
    }

    public static class ViewHolderPost extends RecyclerView.ViewHolder {

        public ImageView picture;

        public TextView title;

        private OnItemClickListener onItemClickListener;

        public ViewHolderPost(View itemView, ViewGroup parent,
            OnItemClickListener onItemClickListener) {
            super(itemView);
            this.onItemClickListener = onItemClickListener;
            picture = (ImageView) itemView.findViewById(R.id.card_image);
            title = (TextView) itemView.findViewById(R.id.card_title);
        }

        public void bindData(PostModel postModel, int position) {
            title.setText(postModel.getTitle());
            picture.setImageResource(R.drawable.post);
            itemView.setOnClickListener(v -> onItemClickListener.onItemClick(position));
        }
    }

    public static class ViewHolderReview extends RecyclerView.ViewHolder {

        public TextView content;

        public ImageView picture;

        public TextView title;

        public TextView type;

        private OnItemClickListener onItemClickListener;

        public ViewHolderReview(View itemView, ViewGroup parent,
            OnItemClickListener onItemClickListener) {
            super(itemView);
            this.onItemClickListener = onItemClickListener;
            picture = (ImageView) itemView.findViewById(R.id.card_image);
            title = (TextView) itemView.findViewById(R.id.card_title);
            content = (TextView) itemView.findViewById(R.id.card_content);
            type = (TextView) itemView.findViewById(R.id.type);
        }

        public void bindData(PostModel postModel, int position) {
            title.setText(postModel.getTitle());
            content.setText(postModel.getShortContent());
            picture.setImageResource(R.drawable.book);
            type.setText("(Book)");
            itemView.setOnClickListener(v -> onItemClickListener.onItemClick(position));
        }
    }


}
