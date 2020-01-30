package com.example.task.views.searchimage;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.task.R;
import com.example.task.databinding.FragmentSearchBinding;
import com.example.task.di.Injector;
import com.example.task.utils.FragmentUtils;
import com.example.task.viewmodel.SearchViewModel;


public class SearchFragment extends Fragment implements View.OnClickListener {
    private FragmentSearchBinding binding;
    private SearchViewModel searchViewModel;


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding =  DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false);
        binding.setHandler(this);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        searchViewModel = ViewModelProviders.of(getActivity(), Injector.getAppViewModelFacotry()).get(SearchViewModel.class);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.search:
                searchViewModel.validate(binding.searchView.getText().toString());
                searchViewModel.getValidationLiveData().observe(this, new Observer<Boolean>() {
                    @Override
                    public void onChanged(Boolean aBoolean) {
                        if (aBoolean) {
                            FragmentUtils.replaceFragment(ImageListingFragment.getInstance(binding.searchView.getText().toString()), getFragmentManager());
                        }
                    }
                });
                break;
        }
    }
}
