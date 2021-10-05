package com.example.instagrampostapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {

    // menampung data yang dikirim dari model
    private ArrayList<Posts> postsArrayList;

    public PostsAdapter(ArrayList<Posts> postsArrayList) {
        this.postsArrayList = postsArrayList;
    }

    @NonNull
    @Override
    public PostsAdapter.PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // menempelkan template posts_item ke activity main
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.posts_item, parent, false);
        return new PostsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsAdapter.PostsViewHolder holder, int position) {
        // mengatur nilai pada template post item berdasarkan nilai yang telah ditampung
        holder.txt_title.setText(postsArrayList.get(position).getTitle());
        holder.txt_author.setText(postsArrayList.get(position).getAuthor());
        holder.txt_location.setText(postsArrayList.get(position).getLocation());
        holder.txt_date_post.setText(postsArrayList.get(position).getDate_post());
        holder.profile_image.setImageResource(postsArrayList.get(position).getProfile_image());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Post: " + postsArrayList.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        // melakukan perulangan untuk menampilkan data sampai akhir dari panjang list
        return (postsArrayList != null) ? postsArrayList.size() : 0;
    }

    public class PostsViewHolder extends RecyclerView.ViewHolder {
        // variabel penampung data dari template "posts_item"
        private TextView txt_title, txt_author, txt_location, txt_date_post;
        private ImageView profile_image;

        public PostsViewHolder(@NonNull View itemView) {
            super(itemView);

            // ambil nilai dari model dan taruh ke dalam variabel penampung
            txt_title = itemView.findViewById(R.id.txt_title);
            txt_author = itemView.findViewById(R.id.txt_author);
            txt_location = itemView.findViewById(R.id.txt_location);
            txt_date_post = itemView.findViewById(R.id.txt_date_post);
            profile_image = itemView.findViewById(R.id.profile_image);
        }
    }
}
