package com.example.restaurantmoderator.ui.home;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.restaurantmoderator.LocaleHelper;
import com.example.restaurantmoderator.NavigationActivity;
import com.example.restaurantmoderator.R;
import com.example.restaurantmoderator.databinding.ActivityNavigationBinding;
import com.example.restaurantmoderator.databinding.FragmentHomeBinding;

import java.util.Locale;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    FragmentHomeBinding binding;
    Toolbar toolbar;
    boolean lang_selected;
    static int checkedItem;

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

        binding.tvAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_navigation_home_to_aboutAppFragment);

            }
        });

        binding.tvUsagePolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_navigation_home_to_usagePolicyFragment);

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
                binding.btnSave.setVisibility(View.VISIBLE);
                binding.etTime.setText(time);

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


        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.etTime.setVisibility(View.GONE);
                binding.btnEdit.setVisibility(View.VISIBLE);
                binding.tvTime.setText(binding.etTime.getText().toString());
                binding.btnSave.setVisibility(View.GONE);
               // binding.etTime.setVisibility(View.GONE);
            }
        });

        binding.tvLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] Language = {"ENGLISH", "العربية"};
                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(getResources().getString(R.string.selectLang))
                        .setSingleChoiceItems(Language,checkedItem, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                binding.tvLang.setText(Language[which]);
                            //    lang_selected= Language[which].equals("ENGLISH");
                                //if user select prefered language as English then
                                if(Language[which].equals("ENGLISH"))
                                {
                                    checkedItem =0;
                                    Context context = LocaleHelper.setLocale(getActivity(), "en");
                                }
                                //if user select prefered language as Hindi then
                                if(Language[which].equals("العربية"))
                                {
                                    checkedItem =1;
                                    Context context = LocaleHelper.setLocale(getActivity(), "ar");

                                 //   setAppLocale("ar");

                                }
                                getActivity().recreate();
                                binding.tvLang.setText(Language[which]);

                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                builder.create().show();

            }
        });


    }

    public void setAppLocale(String localeCode)
    {
        Resources resources= getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(new Locale(localeCode.toLowerCase()));
        resources.updateConfiguration(configuration, metrics);
    }
}