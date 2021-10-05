package com.example.instagrampostapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Inisialisasi Recycle view, Adapter, data list
    private RecyclerView recyclerView;
    private PostsAdapter postsAdapter;
    private ArrayList<Posts> postsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // memanggil method untuk menambahkan nilai pada list
        addDataToList();

        // mengakses recycle view pada activity main
        recyclerView = findViewById(R.id.recycle_view);
        // Memberi nilai pada adapter
        postsAdapter = new PostsAdapter(postsArrayList);
        // set layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        // set adapter
        recyclerView.setAdapter(postsAdapter);
    }
    // fungsi untuk menambah data kedalam list
    private void addDataToList() {
        postsArrayList = new ArrayList<>();
        postsArrayList.add(new Posts("Vacation", "@ibnnu.as", "Probolinggo", "Dec, 12 2021", R.mipmap.image1));
        postsArrayList.add(new Posts("Daily", "@delaaa", "Kraksaan", "Dec, 21 2021", R.mipmap.image2));
        postsArrayList.add(new Posts("Hei World", "@hayuningtyas", "Jember", "Dec, 05 2021", R.mipmap.image3));
        postsArrayList.add(new Posts("Hey Jude", "@robertovanila", "Banyuwangi", "Dec, 09 2021", R.mipmap.image4));
    }
}