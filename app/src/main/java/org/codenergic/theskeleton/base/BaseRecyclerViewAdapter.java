package org.codenergic.theskeleton.base;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by putrice on 2/17/18.
 */

public abstract class BaseRecyclerViewAdapter<VH extends BaseRecyclerViewHolder<T>, T> extends
    RecyclerView.Adapter<VH> {

    private List<T> items;

    private BaseRecyclerViewHolder.OnItemClickListener onItemClickListener;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.bindData(getItem(position));
        holder.setOnItemClickListener(getOnItemClickListener());
    }

    public T getItem(int position) {
        if (position < getItemSize()) {
            return items.get(position);
        }
        return null;
    }

    public BaseRecyclerViewHolder.OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(
        BaseRecyclerViewHolder.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private int getItemSize() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    @Override
    public int getItemCount() {
        return getItemSize();
    }
}
