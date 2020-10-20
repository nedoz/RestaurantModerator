package com.example.restaurantmoderator.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.restaurantmoderator.Model.NotificationModel;
import com.example.restaurantmoderator.databinding.NotificationItemBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {


    List<NotificationModel> ArrayList;
    private onClickItemListener itemListener;
    Context context;

    public NotificationAdapter(List<NotificationModel> ArrayList, Context context) {
        this.ArrayList = ArrayList;
        this.context = context;
    }

    @NonNull

    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new NotificationViewHolder(NotificationItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));

        //  View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.partial_item, parent, false);
        //  NotificationViewHolder = new PartialNotificationViewHolder(view2, itemListener);


    }

    private static final String TAG = "NotificationAdapter";

    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        NotificationModel currentItem = ArrayList.get(position);

        holder.binding.notificationDate.setText(currentItem.getNotificationDate());
        holder.binding.tvNotificationTitle.setText(currentItem.getNotificationTitle());
        // CategoriesResponse currentItem = MessagesArrayList.get(position);
//        Log.d(TAG, "onBindNotificationViewHolder: "+MessagesArrayList.get(position).getName());
//        holder.itemName.setText(MessagesArrayList.get(position).getName());
//
//        Glide.with(context).load("http://app.al-jaddaf.com/public/uploads/"+ MessagesArrayList.get(position).getImage()).into(holder.itemImage);
    }


    class NotificationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView notificationTitle,notificationID;
        NotificationItemBinding binding;
        onClickItemListener listener;

        public NotificationViewHolder(@NonNull @NotNull NotificationItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }


        @Override
        public void onClick(View v) {
//            itemListener.onClickItemListener(getAdapterPosition(),MessagesArrayList.get(getAdapterPosition()).getId());

        }
    }

    public void setNotificationList(List<NotificationModel> ArrayList) {
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



