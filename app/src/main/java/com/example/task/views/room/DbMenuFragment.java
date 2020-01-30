package com.example.task.views.room;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.task.R;
import com.example.task.databinding.FragmentDbMenuBinding;
import com.example.task.di.Injector;
import com.example.task.utils.FragmentUtils;
import com.example.task.viewmodel.DatabaseViewModel;


public class DbMenuFragment extends Fragment implements View.OnClickListener{
    private FragmentDbMenuBinding binding;

    public DbMenuFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding =  DataBindingUtil.inflate(inflater, R.layout.fragment_db_menu, container, false);
        binding.setHandler(this);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                FragmentUtils.replaceFragment(new AddStudentFragment(), getFragmentManager());
                break;
            case R.id.update:
                break;
            case R.id.delete:
                break;
            case R.id.view:
                break;
            case R.id.view_all:
                break;
        }
    }
}
