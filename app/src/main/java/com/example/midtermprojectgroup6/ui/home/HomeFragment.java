package com.example.midtermprojectgroup6.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.midtermprojectgroup6.R;
import com.example.midtermprojectgroup6.adapters.HomeAdapter;
import com.example.midtermprojectgroup6.adapters.HomeVerAdapter;
import com.example.midtermprojectgroup6.adapters.UpdateVerticalRec;
import com.example.midtermprojectgroup6.databinding.FragmentHomeBinding;
import com.example.midtermprojectgroup6.models.HomeModel;
import com.example.midtermprojectgroup6.models.HomeVerModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements UpdateVerticalRec {

    RecyclerView homeHorizontalRec,homeVerticalRec;
    ArrayList<HomeModel> homeModelList;
    HomeAdapter homeAdapter;

    ////////////////Vertical
    ArrayList<HomeVerModel> homeVerModelList;
    HomeVerAdapter homeVerAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        homeHorizontalRec = root.findViewById(R.id.home_rec);
        homeVerticalRec = root.findViewById(R.id.home_ver_rec);

        //////////////Horizontal RecyclerView
        homeModelList = new ArrayList<>();

        homeModelList.add(new HomeModel(R.drawable.breakfast_icon, "Breakfast"));
        homeModelList.add(new HomeModel(R.drawable.lunch, "Lunch"));
        homeModelList.add(new HomeModel(R.drawable.dinner, "Dinner"));

        homeAdapter = new HomeAdapter(this,getActivity(),homeModelList);
        homeHorizontalRec.setAdapter(homeAdapter);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        homeHorizontalRec.setHasFixedSize(true);
        homeHorizontalRec.setNestedScrollingEnabled(false);

        //////////////Vertical RecyclerView
        homeVerModelList = new ArrayList<>();

        homeVerAdapter = new HomeVerAdapter(getActivity(),homeVerModelList);
        homeVerticalRec.setAdapter(homeVerAdapter);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));

        return root;
    }

    @Override
    public void callBack(int position, ArrayList<HomeVerModel> list) {

        homeVerAdapter = new HomeVerAdapter(getContext(),list);
        homeVerAdapter.notifyDataSetChanged();
        homeVerticalRec.setAdapter(homeVerAdapter);
    }
}