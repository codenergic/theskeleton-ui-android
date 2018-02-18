package org.codenergic.theskeleton.content.comment;

import org.codenergic.theskeleton.R;
import org.codenergic.theskeleton.base.BaseRecyclerViewAdapter;
import org.codenergic.theskeleton.base.BaseRecyclerViewHolder;
import org.codenergic.theskeleton.model.PostModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;

/**
 * Created by diasa on 12/25/17.
 */
public class CommentAdapter extends BaseRecyclerViewAdapter<CommentAdapter
    .CommentViewHolder, PostModel> {

    @Override
    public CommentAdapter.CommentViewHolder onCreateViewHolder(ViewGroup parent,
        int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_card_comment, parent, false);
        return new CommentViewHolder(parent.getContext(), view);
    }

    public static class CommentViewHolder extends BaseRecyclerViewHolder<PostModel> {

        @BindView(R.id.iv_comment_user)
        public ImageView ivCommentUser;

        @BindView(R.id.tv_comment)
        public TextView tvComment;

        public CommentViewHolder(Context context, View itemView) {
            super(context, itemView);
        }

        @Override
        public void bindData(PostModel data) {
            tvComment.setText(data.getTitle());
            //TODO please change using Glide
            ivCommentUser.setImageResource(R.drawable.raisa);
        }
    }
}
