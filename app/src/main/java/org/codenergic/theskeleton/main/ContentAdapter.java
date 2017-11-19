package org.codenergic.theskeleton.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import org.codenergic.theskeleton.R;
import org.codenergic.theskeleton.model.PostModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by diasa on 11/8/17.
 */
public class ContentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0: return new ContentAdapter.ViewHolderPost(LayoutInflater.from(parent.getContext()), parent);
            case 1: return new ContentAdapter.ViewHolderReview(LayoutInflater.from(parent.getContext()), parent);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PostModel post = dummyContent().get(position);
        switch (holder.getItemViewType()) {
            case 0:
                ViewHolderPost vhPost = (ViewHolderPost) holder;
                vhPost.title.setText(post.getTitle());
                vhPost.picture.setImageResource(R.drawable.post);
                break;
            case 1:
                ViewHolderReview vhReview = (ViewHolderReview) holder;
                vhReview.title.setText(post.getTitle());
                vhReview.content.setText(post.getShortContent());
                vhReview.picture.setImageResource(R.drawable.book);
                vhReview.type.setText("(Book)");
                break;
        }
    }

    @Override
    public int getItemCount() {
        return dummyContent().size();
    }

    @Override
    public int getItemViewType(int position) {
        return dummyContent().get(position).getType();
    }

    public static class ViewHolderPost extends RecyclerView.ViewHolder {
        public ImageView picture;
        public TextView title;

        public ViewHolderPost(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_card_post, parent, false));
            picture = (ImageView) itemView.findViewById(R.id.card_image);
            title = (TextView) itemView.findViewById(R.id.card_title);
        }
    }

    public static class ViewHolderReview extends RecyclerView.ViewHolder {
        public ImageView picture;
        public TextView title;
        public TextView content;
        public TextView type;

        public ViewHolderReview(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.item_card_review, parent, false));
            picture = (ImageView) itemView.findViewById(R.id.card_image);
            title = (TextView) itemView.findViewById(R.id.card_title);
            content = (TextView) itemView.findViewById(R.id.card_content);
            type = (TextView) itemView.findViewById(R.id.type);
        }
    }

    private List<PostModel> dummyContent(){
        List<PostModel> posts = new ArrayList<>();
        posts.add(new PostModel()
                .setTitle("Truk Tabrak Tiang di KM 12 Cikampek, Lalu Lintas Arah Cawang Padat")
                .setShortContent("Kecelakaan yang terjadi di KM 12 Tol Cikampek arah Cawang ini menyebabkan macet sekitar 1 km.")
                .setType(0)
        );
        posts.add(new PostModel()
                .setTitle("CCTV Jadi Andalan Ibu untuk Pantau Kondisi Anak saat Bekerja")
                .setShortContent("CCTV tersambung dengan gadget, ibu bisa mengecek apakah si sudah minum susu atau belum. Kapan saja, di mana saja.")
                .setType(1)
        );
        posts.add(new PostModel()
                .setTitle("Truk Tabrak Tiang di KM 12 Cikampek, Lalu Lintas Arah Cawang Padat")
                .setShortContent("Kecelakaan yang terjadi di KM 12 Tol Cikampek arah Cawang ini menyebabkan macet sekitar 1 km.")
                .setType(0)
        );
        posts.add(new PostModel()
                .setTitle("CCTV Jadi Andalan Ibu untuk Pantau Kondisi Anak saat Bekerja")
                .setShortContent("CCTV tersambung dengan gadget, ibu bisa mengecek apakah si sudah minum susu atau belum. Kapan saja, di mana saja.")
                .setType(1)
        );
        posts.add(new PostModel()
                .setTitle("Truk Tabrak Tiang di KM 12 Cikampek, Lalu Lintas Arah Cawang Padat")
                .setShortContent("Kecelakaan yang terjadi di KM 12 Tol Cikampek arah Cawang ini menyebabkan macet sekitar 1 km.")
                .setType(0)
        );
        posts.add(new PostModel()
                .setTitle("CCTV Jadi Andalan Ibu untuk Pantau Kondisi Anak saat Bekerja")
                .setShortContent("CCTV tersambung dengan gadget, ibu bisa mengecek apakah si sudah minum susu atau belum. Kapan saja, di mana saja.")
                .setType(1)
        );
        posts.add(new PostModel()
                .setTitle("Truk Tabrak Tiang di KM 12 Cikampek, Lalu Lintas Arah Cawang Padat")
                .setShortContent("Kecelakaan yang terjadi di KM 12 Tol Cikampek arah Cawang ini menyebabkan macet sekitar 1 km.")
                .setType(0)
        );
        posts.add(new PostModel()
                .setTitle("CCTV Jadi Andalan Ibu untuk Pantau Kondisi Anak saat Bekerja")
                .setShortContent("CCTV tersambung dengan gadget, ibu bisa mengecek apakah si sudah minum susu atau belum. Kapan saja, di mana saja.")
                .setType(1)
        );
        return posts;
    }
}
