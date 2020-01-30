package com.example.task.views.searchimage;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.task.R;
import com.example.task.databinding.ActivityHomeBinding;
import com.example.task.di.Injector;
import com.example.task.utils.FragmentUtils;
import com.example.task.viewmodel.SearchViewModel;

public class SearchActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        FragmentUtils.replaceFragment(new SearchFragment(), getSupportFragmentManager());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding.unbind();
    }
}
