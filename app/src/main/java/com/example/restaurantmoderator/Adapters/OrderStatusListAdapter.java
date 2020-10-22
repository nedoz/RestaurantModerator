package com.example.restaurantmoderator.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.restaurantmoderator.Model.OrderStatusModel;
import com.example.restaurantmoderator.R;
import com.example.restaurantmoderator.databinding.OrderItemBinding;
import com.example.restaurantmoderator.databinding.OrderStatusListItemBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class OrderStatusListAdapter extends RecyclerView.Adapter<OrderStatusListAdapter.OrderStatusListViewHolder> {


    List<OrderStatusModel> ArrayList;
    private onClickItemListener itemListener;
    Context context;
    private int selected_position = -1;
    OrderStatusListItemBinding binding;

    public OrderStatusListAdapter(List<OrderStatusModel> MessagesArrayList, onClickItemListener listener, Context context) {
        this.ArrayList = MessagesArrayList;
        this.itemListener = listener;
        this.context = context;
    }

    @NonNull

    @Override
    public OrderStatusListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new OrderStatusListViewHolder(OrderStatusListItemBinding
                .inflate(LayoutInflater
                        .from(parent.getContext()),parent,false));
    }

    private static final String TAG = "OrderStatusListAdapter";

    public void onBindViewHolder(@NonNull OrderStatusListViewHolder holder, final int position) {
        OrderStatusModel currentItem = ArrayList.get(position);
             holder.binding.orderStatusTxt.setText(currentItem.getOrderStatus());
//             holder.binding.orderStatusTxt.setTextColor(selected_position == position ?
//                     (context.getResources().getColor(R.color.red))
//                     : (context.getResources().getColor(R.color.green)));

            holder.binding.orderStatusTxt.setAlpha(selected_position >= position  ? 1 : .4f);
            holder.binding.checkedImg.setAlpha(selected_position >= position  ? 1 : .4f);
            holder.binding.ivDone.setAlpha(selected_position >= position  ? 1 : .4f);
            holder.binding.line1.setAlpha(selected_position >= position  ? 1 : .4f);
            if (position == 2)
            {holder.binding.line1.setVisibility(View.GONE);}

            if(selected_position == 2)
            {
                holder.binding.line1.setVisibility(View.GONE);
               
            }

            holder.binding.orderStatusTxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (selected_position == position) {
                        selected_position = -1;
                        notifyDataSetChanged();
                        return;
                    }
                    selected_position = position;
                    notifyDataSetChanged();
                }

            });
    }


    class OrderStatusListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView msgContent, msgLink, seenNum, time;
        onClickItemListener listener;
        OrderStatusListItemBinding binding;

        public OrderStatusListViewHolder(@NonNull OrderStatusListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }


        @Override
        public void onClick(View v) {

        }
    }

    public void setOrderStatusArrayList(List<OrderStatusModel> ArrayList) {
        ArrayList = ArrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return ArrayList == null ? 0 : ArrayList.size();
    }

    public interface onClickItemListener {
        void onClickItemListener(int position);


    }
}



