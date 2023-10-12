package com.example.midtermprojectgroup6.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.midtermprojectgroup6.R;
import com.example.midtermprojectgroup6.adapters.CartAdapter;
import com.example.midtermprojectgroup6.models.CartModel;

import java.util.ArrayList;
import java.util.List;

public class MyCartFragment extends Fragment {

    List<CartModel> list;
    CartAdapter cartAdapter;

    RecyclerView recyclerView;

    public MyCartFragment () {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_cart, container, false);

        recyclerView = view.findViewById(R.id.cart_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        list = new ArrayList<>();
        CartModel monday = new CartModel(R.drawable.mon, "Monday", "Breakfast/Lunch/Dinner","100-150" );
        list.add(monday);
        list.add(new CartModel(R.drawable.tues, "Tuesday", "Breakfast/Lunch/Dinner","100-150"));
        list.add(new CartModel(R.drawable.wed, "Wednesday", "Breakfast/Lunch/Dinner","100-150"));
        list.add(new CartModel(R.drawable.thurs, "Thursday", "Breakfast/Lunch/Dinner","100-150"));
        list.add(new CartModel(R.drawable.fri, "Friday", "Breakfast/Lunch/Dinner","100-150"));
        list.add(new CartModel(R.drawable.sat, "Saturday", "Breakfast/Lunch/Dinner","100-150"));
        list.add(new CartModel(R.drawable.sun, "Sunday", "Breakfast/Lunch/Dinner","100-150"));
        cartAdapter = new CartAdapter(list);
        recyclerView.setAdapter(cartAdapter);


        return view;
    }
}