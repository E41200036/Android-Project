package com.example.whatsappapplication_bottomnavigation;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.StatusViewHolder> {
    private ArrayList<Status> statuses;

    public StatusAdapter(ArrayList<Status> statuses) {
        this.statuses = statuses;
    }

    @NonNull
    @Override
    public StatusAdapter.StatusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.status_item, parent, false);
        return new StatusViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StatusAdapter.StatusViewHolder holder, int position) {
        holder.txt_status_name.setText(statuses.get(position).getStatus_name());
        holder.txt_status_time.setText(statuses.get(position).getStatus_time());
        holder.img_status_image.setImageResource(statuses.get(position).getStatus_image());
    }

    @Override
    public int getItemCount() {
        return (statuses != null) ? statuses.size() : 0;
    }

    public static class StatusViewHolder extends RecyclerView.ViewHolder {
        private TextView txt_status_name, txt_status_time;
        private ImageView img_status_image;
        public StatusViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_status_name = itemView.findViewById(R.id.txt_status_name);
            txt_status_time = itemView.findViewById(R.id.txt_status_time);
            img_status_image = itemView.findViewById(R.id.img_status_image);
        }
    }
}
