package com.example.restaurantmoderator.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.restaurantmoderator.NavigationActivity;
import com.example.restaurantmoderator.R;
import com.example.restaurantmoderator.databinding.ActivityNavigationBinding;
import com.example.restaurantmoderator.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
  FragmentHomeBinding binding;
Toolbar toolbar;
    NavigationActivity activity = new NavigationActivity();



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;
//        View root = inflater.inflate(R.layout.fragment_home, container, false);
////      //  final TextView textView = root.findViewById(R.id.text_home);
////        Navigation.findNavController(root);
////        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
////            @Override
////            public void onChanged(@Nullable String s) {
////                textView.setText(s);
////            }
////        });
//
//        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
   //   activity.toolbarTile.setText("الحساب");
//        final AppCompatActivity act = (AppCompatActivity) getActivity();
//        if (act.getSupportActionBar() != null) {
//            Toolbar toolbar = (Toolbar) act.getSupportActionBar().getCustomView();
//
//        }

    }
}