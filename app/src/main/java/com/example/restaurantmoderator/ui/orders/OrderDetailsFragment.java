package com.example.restaurantmoderator.ui.orders;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.restaurantmoderator.R;


public class OrderDetailsFragment extends Fragment {


    public OrderDetailsFragment() {
        // Required empty public constructor
    }


    public static OrderDetailsFragment newInstance() {
        OrderDetailsFragment fragment = new OrderDetailsFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order_details, container, false);
        return view;
    }
}