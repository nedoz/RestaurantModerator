package com.example.restaurantmoderator.ui.orders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.restaurantmoderator.Model.OrderDetailsAdapter;
import com.example.restaurantmoderator.Model.OrderRequest;
import com.example.restaurantmoderator.R;
import com.example.restaurantmoderator.databinding.FragmentOrderDetailsBinding;

import java.util.ArrayList;


public class OrderDetailsFragment extends Fragment {

    FragmentOrderDetailsBinding binding;
    ArrayList<OrderRequest> orderRequestArrayList = new ArrayList<>();

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
//        View view = inflater.inflate(R.layout.fragment_order_details, container, false);
        binding = FragmentOrderDetailsBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        orderRequestArrayList.add(new OrderRequest(R.drawable.food, "اسم المنتج", "Description   Description",
                "2", "22 ريال",
                "لا يوجد","لا يوجد" , "لا يوجد"));
        orderRequestArrayList.add(new OrderRequest(R.drawable.food, "اسم المنتج", "Description   Description",
                "2", "22 ريال",
                "لا يوجد","لا يوجد" , "لا يوجد"));
        orderRequestArrayList.add(new OrderRequest(R.drawable.food, "اسم المنتج", "Description   Description",
                "2", "22 ريال",
                "لا يوجد","لا يوجد" , "لا يوجد"));
        orderRequestArrayList.add(new OrderRequest(R.drawable.food, "اسم المنتج", "Description   Description",
                "2", "22 ريال",
                "لا يوجد","لا يوجد" , "لا يوجد"));

        OrderDetailsAdapter adapter = new OrderDetailsAdapter(orderRequestArrayList,getActivity());
        binding.orderItemsRecycler.setAdapter(adapter);
    }
}