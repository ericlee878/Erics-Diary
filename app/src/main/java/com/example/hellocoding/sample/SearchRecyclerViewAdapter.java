package com.example.hellocoding.sample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hellocoding.R;

import java.util.List;

public class SearchRecyclerViewAdapter extends RecyclerView.Adapter<SearchViewHolder> {
    private List<Docs> data;

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.searchrecyclerview_adapter, parent, false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.snippetTextView.setText(data.get(position).snippet);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void update(List<Docs> data) {
        this.data =data;
        notifyDataSetChanged();
    }
}

class SearchViewHolder extends RecyclerView.ViewHolder {
    public TextView snippetTextView;

    public SearchViewHolder(@NonNull View itemView) {
        super(itemView);
       snippetTextView = itemView.findViewById(R.id.snippetTextView);
    }
}
