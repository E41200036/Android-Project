package com.example.libraryapplication;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DetailBook extends AppCompatActivity {

    private ArrayList<Book> books;
    private TextView card_detail_title, txt_detail_book_title, txt_detail_book_author;
    private ImageView img_detail_book_cover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_book);

        card_detail_title = findViewById(R.id.card_detail_title);
        txt_detail_book_title = findViewById(R.id.txt_detail_book_title);
        txt_detail_book_author = findViewById(R.id.txt_detail_book_author);
        img_detail_book_cover = findViewById(R.id.img_detail_book_cover);
        ImageView btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });

        if (getIntent() != null) {
            Bundle bundle = getIntent().getExtras();
            assert bundle != null;
            card_detail_title.setText(bundle.getString("card_title"));
            txt_detail_book_title.setText(bundle.getString("card_title"));
            txt_detail_book_author.setText(bundle.getString("book_author"));
            img_detail_book_cover.setImageResource(bundle.getInt("book_cover"));
        }

        // books
        addBookItem();
        RecyclerView recyclerViewBook = findViewById(R.id.recycler_view_book);
        BookAdapter bookAdapter = new BookAdapter(books);
        recyclerViewBook.setAdapter(bookAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DetailBook.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewBook.setLayoutManager(layoutManager);
    }

    private void addBookItem() {
        books = new ArrayList<>();
        books.add(new Book("Enterprise Design Sprint", "Ibnnu", R.mipmap.sprint));
        books.add(new Book("DesignOps Handbook", "Ibnnu", R.mipmap.design));
        books.add(new Book("Design System", "Ibnnu", R.mipmap.designsystem));
    }

    private void back() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}