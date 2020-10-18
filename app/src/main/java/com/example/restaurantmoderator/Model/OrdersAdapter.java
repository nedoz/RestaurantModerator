package com.example.restaurantmoderator.Model;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.restaurantmoderator.R;
import com.example.restaurantmoderator.databinding.OrderItemBinding;

import java.util.ArrayList;
import java.util.List;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.OrdersViewHolder> {


    List<Orders> ArrayList;
    private onClickItemListener itemListener;
    Context context;

    public OrdersAdapter(List<Orders> MessagesArrayList, onClickItemListener listener, Context context) {
        this.ArrayList = MessagesArrayList;
        this.itemListener = listener;
        this.context = context;
    }

    @NonNull
    @Override
    public OrdersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new OrdersViewHolder(OrderItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    private static final String TAG = "OrdersAdapter";
@Override
    public void onBindViewHolder(@NonNull OrdersViewHolder holder, int position) {
        Orders currentItem = ArrayList.get(position);

        holder.binding.tvOrderDate.setText(currentItem.getOrder_date());
        holder.binding.tvOrderQuantity.setText(currentItem.getOrder_quantity());
        holder.binding.tvOrderPrice.setText(currentItem.getOrder_price());
        holder.binding.orderNum.setText(currentItem.getOrder_num()+"");
        // CategoriesResponse currentItem = MessagesArrayList.get(position);
//        Log.d(TAG, "onBindOrdersViewHolder: "+MessagesArrayList.get(position).getName());
//        holder.itemName.setText(MessagesArrayList.get(position).getName());
//
//        Glide.with(context).load("http://app.al-jaddaf.com/public/uploads/"+ MessagesArrayList.get(position).getImage()).into(holder.itemImage);
    }


    class OrdersViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
       OrderItemBinding binding;
        onClickItemListener listener;

        public OrdersViewHolder(@NonNull OrderItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

//            tvDate = itemView.findViewById(R.id.tv_order_date);
//            tvOrderNum = itemView.findViewById(R.id.order_num);
//            tvOrderPrice = itemView.findViewById(R.id.tv_order_price);
//            tvOrderQuantity = itemView.findViewById(R.id.tv_quantity);
//            tvDetails = itemView.findViewById(R.id.tv_view_details);
//            tvDetails.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
//            itemListener.onClickItemListener(getAdapterPosition(),MessagesArrayList.get(getAdapterPosition()).getId());

        }
    }

    public void setOrdersArrayList(List<Orders> ArrayList) {
        ArrayList = ArrayList;
        notifyDataSetChanged();
    }





    @Override
    public int getItemCount() {
        return ArrayList == null ? 0 : ArrayList.size();
    }

    public interface onClickItemListener {
        void onClickItemListener(int position, int itemID);

    }
}



