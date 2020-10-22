package com.example.restaurantmoderator.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.restaurantmoderator.R;
import com.example.restaurantmoderator.databinding.FragmentAboutAppBinding;
import com.example.restaurantmoderator.databinding.FragmentUsagePolicyBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UsagePolicyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UsagePolicyFragment extends Fragment {
FragmentUsagePolicyBinding binding;

    public UsagePolicyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UsagePolicyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UsagePolicyFragment newInstance(String param1, String param2) {
        UsagePolicyFragment fragment = new UsagePolicyFragment();

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
        binding = FragmentUsagePolicyBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.usagePolicyWebView.getSettings().setJavaScriptEnabled(true);
        binding.usagePolicyWebView.loadUrl("https://www.google.com");
    }
}