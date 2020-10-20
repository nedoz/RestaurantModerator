package com.example.restaurantmoderator.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.restaurantmoderator.Adapters.NotificationAdapter;
import com.example.restaurantmoderator.Model.NotificationModel;
import com.example.restaurantmoderator.databinding.FragmentNotificationsBinding;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    FragmentNotificationsBinding binding;
    ArrayList<NotificationModel> notificationArrayList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        notificationArrayList.add(new NotificationModel("please Updated Now!", "1/1/2020"));
        notificationArrayList.add(new NotificationModel("please Updated Now!", "1/1/2020"));

        notificationArrayList.add(new NotificationModel("please Updated Now!", "1/1/2020"));

        notificationArrayList.add(new NotificationModel("please Updated Now!", "1/1/2020"));

        notificationArrayList.add(new NotificationModel("please Updated Now!", "1/1/2020"));
        notificationArrayList.add(new NotificationModel("please Updated Now!", "1/1/2020"));

        notificationArrayList.add(new NotificationModel("please Updated Now!", "1/1/2020"));

        NotificationAdapter adapter = new NotificationAdapter(notificationArrayList,getContext());

        binding.notificationRecycler.setAdapter(adapter);
    }
}