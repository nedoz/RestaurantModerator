package com.example.restaurantmoderator.ui.home;

import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Switch;
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
        binding = FragmentHomeBinding.inflate(inflater, container, false);
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
        binding.tvLastOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_navigation_home_to_navigation_orders);
            }
        });

        binding.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time = binding.tvTime.getText().toString();
                binding.btnEdit.setVisibility(View.GONE);
                binding.etTime.requestFocus();
                binding.etTime.setFocusableInTouchMode(true);
                binding.etTime.setVisibility(View.VISIBLE);
                binding.etTime.setText(time);

//            binding.etTime.addTextChangedListener(new TextWatcher() {
//                @Override
//                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//                }
//
//                @Override
//                public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//                }
//
//                @Override
//                public void afterTextChanged(Editable s) {
//
//                    String time = binding.etTime.getText().toString();
//                    binding.tvTime.setText(time);
//
//
//
//                }
//
//
//
//            });


            }
        });

        binding.etTime.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                        actionId == EditorInfo.IME_ACTION_DONE ||
                        event != null &&
                                event.getAction() == KeyEvent.ACTION_DOWN &&
                                event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    if (event == null || !event.isShiftPressed()) {
                        // the user is done typing.

                        binding.etTime.setVisibility(View.GONE);
                        binding.tvTime.setText(binding.etTime.getText().toString());
                        binding.btnEdit.setVisibility(View.VISIBLE);
                        binding.btnEdit.setFocusable(false);
                        View view = getActivity().getCurrentFocus();
                        if (view != null) {
                            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                            return true; // consume.
                        }
                    }
                }
                return false; // pass on to other listeners.
            }

        });

    }
}