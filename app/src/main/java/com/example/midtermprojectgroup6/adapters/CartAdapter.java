package com.example.midtermprojectgroup6.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.midtermprojectgroup6.R;
import com.example.midtermprojectgroup6.models.CartModel;
import com.example.midtermprojectgroup6.models.MondayFavorite;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private final List<CartModel> list;

    public CartAdapter(List<CartModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mycart_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CartModel cartModel = list.get(position);
        holder.imageView.setImageResource(cartModel.getImage());
        holder.name.setText(cartModel.getDay());
        holder.meal.setText(cartModel.getMeal());
        holder.price.setText(cartModel.getPrice());

        // Set click listener for image
        holder.imageView.setOnClickListener(v -> {
            // Handle image click, e.g., show breakfast, lunch, dinner for the day

            Intent intent = new Intent(v.getContext(), MondayFavorite.class);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,meal,price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.detailed_img);
            name = itemView.findViewById(R.id.detailed_name);
            meal = itemView.findViewById(R.id.detailed_meal);
            price = itemView.findViewById(R.id.textView12);
        }
    }
}