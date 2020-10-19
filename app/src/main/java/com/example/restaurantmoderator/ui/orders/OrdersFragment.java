package com.example.restaurantmoderator.ui.orders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.restaurantmoderator.Model.Orders;
import com.example.restaurantmoderator.Model.OrdersAdapter;
import com.example.restaurantmoderator.R;
import com.example.restaurantmoderator.databinding.FragmentOrdersBinding;

import java.util.ArrayList;

public class OrdersFragment extends Fragment implements OrdersAdapter.onClickItemListener {

    private OrdersViewModel ordersViewModel;
    ArrayList<Orders> ordersArrayList = new ArrayList();
    FragmentOrdersBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ordersViewModel =
                ViewModelProviders.of(this).get(OrdersViewModel.class);
        binding = FragmentOrdersBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ordersArrayList.add(new Orders("tuesday 2020.9.20", 2, "99 ريال", "3"));
        ordersArrayList.add(new Orders("tuesday 2020.9.20", 2, "99 ريال", "3"));
        ordersArrayList.add(new Orders("tuesday 2020.9.20", 2, "99 ريال", "3"));
        OrdersAdapter adapter = new OrdersAdapter(ordersArrayList,this,getContext());
        binding.ordersRecyclerView.setAdapter(adapter);



    }

    @Override
    public void onClickItemListener(int position, int itemID) {



    }
}