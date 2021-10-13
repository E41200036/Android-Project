package com.example.whatsappapplication_bottomnavigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CallAdapter extends RecyclerView.Adapter<CallAdapter.CallViewHolder> {

    private ArrayList<Call> calls;

    public CallAdapter(ArrayList<Call> calls) {
        this.calls = calls;
    }
    @NonNull
    @Override
    public CallAdapter.CallViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.call_item, parent, false);
        return new CallViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CallAdapter.CallViewHolder holder, int position) {
        holder.img_call_profile.setImageResource(calls.get(position).getCall_profile());
        holder.img_call_status.setImageResource(calls.get(position).getCall_status());
        holder.img_call_diff.setImageResource(calls.get(position).getCall_diff());
        holder.txt_call_name.setText(calls.get(position).getCall_name());
        holder.txt_call_time.setText(calls.get(position).getCall_time());
    }

    @Override
    public int getItemCount() {
        return (calls != null) ? calls.size() : 0;
    }

    public static class CallViewHolder extends RecyclerView.ViewHolder {

        private ImageView img_call_profile, img_call_status, img_call_diff;
        private TextView txt_call_name, txt_call_time;

        public CallViewHolder(@NonNull View itemView) {
            super(itemView);

            img_call_profile = itemView.findViewById(R.id.img_call_profile);
            img_call_status = itemView.findViewById(R.id.img_call_status);
            img_call_diff = itemView.findViewById(R.id.img_call_diff);
            txt_call_name = itemView.findViewById(R.id.txt_call_name);
            txt_call_time = itemView.findViewById(R.id.txt_call_time);

        }
    }
}
