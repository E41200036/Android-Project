package com.example.whatsappapplication_bottomnavigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChatAdapter  extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {
    private ArrayList<Chat> chats;

    public ChatAdapter(ArrayList<Chat> chats) {
        this.chats = chats;
    }

    @NonNull
    @Override
    public ChatAdapter.ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.chat_item, parent, false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.ChatViewHolder holder, int position) {
        holder.txt_name.setText(chats.get(position).getName());
        holder.txt_chat.setText(chats.get(position).getChat());
        holder.txt_time.setText(chats.get(position).getTime());
        holder.img_profile_image.setImageResource(chats.get(position).getProfile_image());
    }

    @Override
    public int getItemCount() {
        return (chats != null) ? chats.size() : 0;
    }

    public static class ChatViewHolder extends RecyclerView.ViewHolder {
        TextView txt_chat, txt_name, txt_time;
        ImageView img_profile_image;

        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_name = itemView.findViewById(R.id.txt_name);
            txt_chat = itemView.findViewById(R.id.txt_chat);
            txt_time = itemView.findViewById(R.id.txt_time);
            img_profile_image = itemView.findViewById(R.id.img_profile_image);
        }
    }
}
