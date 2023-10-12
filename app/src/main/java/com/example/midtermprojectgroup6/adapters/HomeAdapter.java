package com.example.midtermprojectgroup6.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.midtermprojectgroup6.R;
import com.example.midtermprojectgroup6.models.HomeModel;
import com.example.midtermprojectgroup6.models.HomeVerModel;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>{

    UpdateVerticalRec updateVerticalRec;
    Activity activity;
    ArrayList<HomeModel> list;

    boolean check = true;
    boolean select = true;
    int row_index = -1;

    public HomeAdapter(UpdateVerticalRec updateVerticalRec, Activity activity, ArrayList<HomeModel> list) {
        this.updateVerticalRec = updateVerticalRec;
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());

        if (check) {
            ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
            homeVerModels.add(new HomeVerModel(R.drawable.breakfast_img, "Breakfast", "10:00 - 23:00", "4.9", "Min - $35"));
            homeVerModels.add(new HomeVerModel(R.drawable.breakfast_img, "Breakfast", "10:00 - 23:00", "4.9", "Min - $35"));
            homeVerModels.add(new HomeVerModel(R.drawable.breakfast_img, "Breakfast", "10:00 - 23:00", "4.9", "Min - $35"));
            homeVerModels.add(new HomeVerModel(R.drawable.breakfast_img, "Breakfast", "10:00 - 23:00", "4.9", "Min - $35"));

            updateVerticalRec.callBack(position, homeVerModels);
            check = false;
        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row_index = position;
                notifyDataSetChanged();
                if (position == 0){

                    ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();

                    homeVerModels.add(new HomeVerModel(R.drawable.breakfast_img, "Breakfast", "10:00 - 23:00", "4.9", "Min - $35"));
                    homeVerModels.add(new HomeVerModel(R.drawable.breakfast_img, "Breakfast", "10:00 - 23:00", "4.9", "Min - $35"));
                    homeVerModels.add(new HomeVerModel(R.drawable.breakfast_img, "Breakfast", "10:00 - 23:00", "4.9", "Min - $35"));
                    homeVerModels.add(new HomeVerModel(R.drawable.breakfast_img, "Breakfast", "10:00 - 23:00", "4.9", "Min - $35"));

                    updateVerticalRec.callBack(position, homeVerModels);
                }
                else if (position == 1){
                    ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();

                    homeVerModels.add(new HomeVerModel(R.drawable.lunch_img, "Lunch", "10:00 - 23:00", "4.9", "Min - $35"));
                    homeVerModels.add(new HomeVerModel(R.drawable.lunch_img, "Lunch", "10:00 - 23:00", "4.9", "Min - $35"));
                    homeVerModels.add(new HomeVerModel(R.drawable.lunch_img, "Lunch", "10:00 - 23:00", "4.9", "Min - $35"));
                    homeVerModels.add(new HomeVerModel(R.drawable.lunch_img, "Lunch", "10:00 - 23:00", "4.9", "Min - $35"));

                    updateVerticalRec.callBack(position, homeVerModels);
                }
                else if (position == 2){
                    ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();

                    homeVerModels.add(new HomeVerModel(R.drawable.dinner_img, "Dinner", "10:00 - 23:00", "4.9", "Min - $35"));
                    homeVerModels.add(new HomeVerModel(R.drawable.dinner_img, "Dinner", "10:00 - 23:00", "4.9", "Min - $35"));
                    homeVerModels.add(new HomeVerModel(R.drawable.dinner_img, "Dinner", "10:00 - 23:00", "4.9", "Min - $35"));
                    homeVerModels.add(new HomeVerModel(R.drawable.dinner_img, "Dinner", "10:00 - 23:00", "4.9", "Min - $35"));

                    updateVerticalRec.callBack(position, homeVerModels);
                }
            }
        });

        if (select) {
            if (position == 0) {
                holder.cardView.setBackgroundResource(R.drawable.change_bg);
                select = false;
            }
        }
        else {
            if (row_index == position){
                holder.cardView.setBackgroundResource(R.drawable.change_bg);
            } else {
                holder.cardView.setBackgroundResource(R.drawable.default_bg);
            }
        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.breakfast_img);
            name = itemView.findViewById(R.id.breakfast_text);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}