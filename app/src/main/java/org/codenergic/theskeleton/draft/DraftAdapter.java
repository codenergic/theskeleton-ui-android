package org.codenergic.theskeleton.draft;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.codenergic.theskeleton.R;
import org.codenergic.theskeleton.model.PostModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by diasa on 2/16/18.
 */
public class DraftAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private OnItemClickListener onItemClickListener;

    private List<PostModel> posts;

    public DraftAdapter(List<PostModel> posts, OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        this.posts = posts;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DraftAdapter.ViewHolderDraft(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card_draft, parent, false), onItemClickListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolderDraft) holder).bindData(posts.get(position), position);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public static class ViewHolderDraft extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        public TextView tvTitle;

        @BindView(R.id.tv_content)
        public TextView tvContent;

        private OnItemClickListener onItemClickListener;

        public ViewHolderDraft(View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.onItemClickListener = onItemClickListener;
        }

        public void bindData(PostModel postModel, int position) {
            tvTitle.setText(postModel.getTitle());
            tvContent.setText(postModel.getContent());
            itemView.setOnClickListener(v -> onItemClickListener.onItemClick(position));
        }
    }
}
