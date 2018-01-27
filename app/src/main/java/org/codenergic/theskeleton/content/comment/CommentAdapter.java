package org.codenergic.theskeleton.content.comment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import org.codenergic.theskeleton.R;
import org.codenergic.theskeleton.content.OnItemClickListener;
import org.codenergic.theskeleton.model.PostModel;

import java.util.List;

/**
 * Created by diasa on 12/25/17.
 */
public class CommentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private OnItemClickListener onItemClickListener;
    private List<PostModel> post;

    public CommentAdapter(List<PostModel> posts, OnItemClickListener onItemClickListener) {
        this.post = posts;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CommentAdapter.ViewHolderComment(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_card_comment, parent, false), parent, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((CommentAdapter.ViewHolderComment) holder).bindData(post.get(position), position);
    }

    @Override
    public int getItemCount() {
        return post.size();
    }

    public static class ViewHolderComment extends RecyclerView.ViewHolder {
        public ImageView picture;
        public TextView comment;
        private OnItemClickListener onItemClickListener;

        public ViewHolderComment(View itemView, ViewGroup parent, OnItemClickListener onItemClickListener) {
            super(itemView);
            this.onItemClickListener = onItemClickListener;
            picture = (ImageView) itemView.findViewById(R.id.imageView);
            comment = (TextView) itemView.findViewById(R.id.textView8);
        }

        public void bindData(PostModel postModel, int position) {
            comment.setText(postModel.getTitle());
            picture.setImageResource(R.drawable.raisa);
            itemView.setOnClickListener(v -> onItemClickListener.onItemClick(position));
        }
    }
}
