package com.example.restaurantmoderator;

import android.os.Bundle;
import android.widget.TextView;

import com.example.restaurantmoderator.databinding.ActivityLoginBinding;
import com.example.restaurantmoderator.databinding.ActivityNavigationBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class NavigationActivity extends AppCompatActivity {
public Toolbar toolbar;
public TextView toolbarTile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  setContentView(R.layout.activity_navigation);
        ActivityNavigationBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_navigation);

        setSupportActionBar(binding.toolBar.toolBar1);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_orders, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        toolbar = findViewById(R.id.toolBar);
        toolbarTile = toolbar.findViewById(R.id.toolbar_title);
navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
    @Override
    public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
     if (destination.getId()==R.id.navigation_home)
       toolbarTile.setText("الحساب");
     else if(destination.getId()==R.id.navigation_orders)
         toolbarTile.setText("الطلبات الحالية");
     else if(destination.getId()==R.id.navigation_notifications)
         toolbarTile.setText(" الاشعارات");
    }

});
    }

}