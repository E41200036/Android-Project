package com.example.libraryapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    private ArrayList<Book> books;

    public BookAdapter(ArrayList<Book> books) {
        this.books = books;
    }

    @NonNull
    @Override
    public BookAdapter.BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.book_item, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapter.BookViewHolder holder, int position) {
        holder.img_book_cover.setImageResource(books.get(position).getBook_cover());
        holder.card_title.setText(books.get(position).getCard_title());
        holder.txt_book_title.setText(books.get(position).getCard_title());
        holder.txt_book_author.setText(books.get(position).getBook_author());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, DetailBook.class);
                intent.putExtra("card_title", books.get(position).getCard_title());
                intent.putExtra("book_cover", books.get(position).getBook_cover());
                intent.putExtra("book_author", books.get(position).getBook_author());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder {

        private TextView card_title, txt_book_title, txt_book_author;
        private ImageView img_book_cover;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            card_title = itemView.findViewById(R.id.card_title);
            txt_book_title = itemView.findViewById(R.id.txt_book_title);
            txt_book_author = itemView.findViewById(R.id.txt_book_author);
            img_book_cover = itemView.findViewById(R.id.img_book_cover);

        }
    }
}
