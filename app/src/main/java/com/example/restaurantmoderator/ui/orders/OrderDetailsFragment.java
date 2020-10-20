package com.example.restaurantmoderator.ui.orders;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.restaurantmoderator.Adapters.OrderDetailsAdapter;
import com.example.restaurantmoderator.Adapters.OrderStatusListAdapter;
import com.example.restaurantmoderator.Model.OrderRequest;
import com.example.restaurantmoderator.Model.OrderStatusModel;
import com.example.restaurantmoderator.R;
import com.example.restaurantmoderator.databinding.FragmentOrderDetailsBinding;
import com.example.restaurantmoderator.databinding.OrderStatusListItemBinding;

import java.util.ArrayList;


public class OrderDetailsFragment extends Fragment implements OrderStatusListAdapter.onClickItemListener {

    FragmentOrderDetailsBinding binding;
    ArrayList<OrderRequest> orderRequestArrayList = new ArrayList<>();
    OrderStatusListAdapter statusListAdapter;
    ArrayList<OrderStatusModel> orderStatusModelArrayList = new ArrayList<>();
    OrderStatusListItemBinding binding2;

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
                "2", "22 جنيه",
                "لا يوجد","لا يوجد" , "لا يوجد"));
        orderRequestArrayList.add(new OrderRequest(R.drawable.food, "اسم المنتج", "Description   Description",
                "2", "22 جنيه",
                "لا يوجد","لا يوجد" , "لا يوجد"));
        orderRequestArrayList.add(new OrderRequest(R.drawable.food, "اسم المنتج", "Description   Description",
                "2", "22 جنيه",
                "لا يوجد","لا يوجد" , "لا يوجد"));
        orderRequestArrayList.add(new OrderRequest(R.drawable.food, "اسم المنتج", "Description   Description",
                "2", "22 جنيه",
                "لا يوجد","لا يوجد" , "لا يوجد"));

        OrderDetailsAdapter adapter = new OrderDetailsAdapter(orderRequestArrayList,getActivity());
        binding.orderItemsRecycler.setAdapter(adapter);

       orderStatusModelArrayList.add(new OrderStatusModel(getResources().getString(R.string.inProgress)));
        orderStatusModelArrayList.add(new OrderStatusModel(getResources().getString(R.string.Delivering)));
        orderStatusModelArrayList.add(new OrderStatusModel(getResources().getString(R.string.Delivered)));

        statusListAdapter    = new OrderStatusListAdapter(orderStatusModelArrayList,this,getActivity());
      binding.orderStatusList.setAdapter(statusListAdapter);






    }



    @Override
    public void onClickItemListener(int position) {


    }
}