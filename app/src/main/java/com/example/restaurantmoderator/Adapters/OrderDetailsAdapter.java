package com.example.restaurantmoderator.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.restaurantmoderator.Model.OrderRequest;
import com.example.restaurantmoderator.databinding.OrderProductsItemBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class OrderDetailsAdapter extends RecyclerView.Adapter<OrderDetailsAdapter.OrderDetailsViewHolder> {


    List<OrderRequest> ArrayList;
    private onClickItemListener itemListener;
    Context context;
    OrderProductsItemBinding binding;

    public OrderDetailsAdapter(List<OrderRequest> ArrayList, Context context) {
        this.ArrayList = ArrayList;

        this.context = context;
    }

    @NonNull

    @Override
    public OrderDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new OrderDetailsViewHolder(OrderProductsItemBinding.
                inflate(LayoutInflater.from(parent.getContext()),
                        parent,false));



        //  View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.partial_item, parent, false);
        //  OrderDetailsViewHolder = new PartialOrderDetailsViewHolder(view2, itemListener);


    }

    private static final String TAG = "OrderDetailsAdapter";

    public void onBindViewHolder(@NonNull OrderDetailsViewHolder holder, int position) {
        OrderRequest currentItem = ArrayList.get(position);

    //    holder.binding.ivProductImg.set(currentItem.getProductImg());
        holder.binding.tvProductName.setText(currentItem.getProductName());
        holder.binding.tvOptions.setText(currentItem.getOptions());
        holder.binding.tvAdditions.setText(currentItem.getAdditions());
        holder.binding.tvNotes.setText(currentItem.getNote());
        holder.binding.tvPrice.setText(currentItem.getPrice());
        holder.binding.tvProductDescription.setText(currentItem.getDescription());
        holder.binding.tvQuantity.setText(currentItem.getQuantity());
        // CategoriesResponse currentItem = MessagesArrayList.get(position);
//        Log.d(TAG, "onBindOrderDetailsViewHolder: "+MessagesArrayList.get(position).getName());
//        holder.itemName.setText(MessagesArrayList.get(position).getName());
//
//        Glide.with(context).load("http://app.al-jaddaf.com/public/uploads/"+ MessagesArrayList.get(position).getImage()).into(holder.itemImage);
    }


    class OrderDetailsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        OrderProductsItemBinding binding;
        public OrderDetailsViewHolder(@NonNull OrderProductsItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }


        @Override
        public void onClick(View v) {
//            itemListener.onClickItemListener(getAdapterPosition(),MessagesArrayList.get(getAdapterPosition()).getId());

        }
    }

    public void setProductsArrayList(List<OrderRequest> ArrayList) {
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



