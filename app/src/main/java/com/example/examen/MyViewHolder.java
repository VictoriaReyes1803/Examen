package com.example.examen;


import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;

import java.util.List;


public class MyViewHolder extends RecyclerView.ViewHolder {
    private TextView nameView;
    private TextView phoneView;
    private TextView edadView;
    private TextView descriptionView;
    private List<item_view> items;

    public MyViewHolder(@NonNull View itemView, List<item_view> items) {
        super(itemView);
        this.items = items;
        nameView = itemView.findViewById(R.id.name);
        phoneView = itemView.findViewById(R.id.phone);
        edadView = itemView.findViewById(R.id.edad);
        descriptionView = itemView.findViewById(R.id.description);

        nameView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleNameClick();
            }
        });

        phoneView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handlePhoneClick();
            }
        });
    }


    public void bind(item_view item) {
        nameView.setText(item.getName());
        phoneView.setText(item.getPhone());
        edadView.setText(item.getEdad());
        descriptionView.setText(item.getDescription());
    }

    private void handleNameClick() {
        item_view item = getItemAtAdapterPosition(getAdapterPosition());
        if (item != null) {
            Intent intent = new Intent(nameView.getContext(), MainActivity2.class);
            intent.putExtra("name", item.getName());
            intent.putExtra("description", item.getDescription());
            intent.putExtra("edad", item.getEdad());
            nameView.getContext().startActivity(intent);
        }
    }

    private void handlePhoneClick() {
        item_view item = getItemAtAdapterPosition(getAdapterPosition());
        if (item != null) {
            Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + item.getPhone()));
            phoneView.getContext().startActivity(callIntent);
        }
    }

    private item_view getItemAtAdapterPosition(int adapterPosition) {
        if (adapterPosition != RecyclerView.NO_POSITION && adapterPosition < items.size()) {
            return items.get(adapterPosition);
        }
        return null;
    }
}
