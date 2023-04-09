package com.example.tourismapp.data.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tourismapp.R;
import com.example.tourismapp.data.model.Item;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private List<Item> items;

    private final Context mContext;

    public MyRecyclerViewAdapter(Context context, List<Item> items) {
        this.inflater = LayoutInflater.from(context);
        this.items = items;
        mContext = context;
    }

    @NonNull
    @Override
    public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.ViewHolder holder, int position) {
        Item item = items.get(position);
        holder.textView.setText(item.getText());
        if (item.getImageId() != 0) {
            holder.imageView.setImageResource(item.getImageId());
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Adapter", "WORK");
            }
        });
    }
    public void setItems(List<Item> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;
        final ImageView imageView;
        ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.item_text);
            imageView = view.findViewById(R.id.item_image);
        }
    }
}
