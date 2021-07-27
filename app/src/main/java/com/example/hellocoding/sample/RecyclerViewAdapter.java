package com.example.hellocoding.sample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hellocoding.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<Person> data;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameTextView.setText(data.get(position).name);
        holder.gradeTextView.setText(data.get(position).grade);
        holder.foodTextView.setText(data.get(position).food);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void update(List<Person> data) {
        this.data =data;
        notifyDataSetChanged();
    }
}

class ViewHolder extends RecyclerView.ViewHolder {
    public TextView nameTextView;
    public TextView gradeTextView;
    public TextView foodTextView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.nameTextView2);
        gradeTextView = itemView.findViewById(R.id.gradeTextView);
        foodTextView = itemView.findViewById(R.id.snippetts);
    }
}
