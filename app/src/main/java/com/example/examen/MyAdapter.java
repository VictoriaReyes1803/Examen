package com.example.examen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<item_view> items;

    private Maindetail maindetail;

    public MyAdapter(Context context, List<item_view> items, Maindetail maindetail) {
        this.context = context;
        this.items = items;
        this.maindetail = maindetail;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.itemview, parent, false);
        return new MyViewHolder(itemView, items);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        item_view currentItem = items.get(position);
        holder.bind(currentItem);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (maindetail != null) {
                    maindetail.onItemClick(currentItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
