package com.example.countries.presentation.home;

import android.os.Bundle;

import com.example.countries.R;
import com.example.countries.databinding.ActivityHomeBinding;
import com.example.countries.presentation.base.BaseActivity;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class HomeActivity extends BaseActivity {

    NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHomeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        binding.setViewModel(ViewModelProviders.of(this, factory).get(HomeViewModel.class));

        //for navigation I used AndroidNavigation component
        initNavigation();
    }

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp();
    }

    private void initNavigation(){
        NavHostFragment host = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment));
        navController = host.getNavController();
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    }
}
