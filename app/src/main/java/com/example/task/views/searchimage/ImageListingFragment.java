package com.example.task.views.searchimage;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.task.R;
import com.example.task.common.Constants;
import com.example.task.databinding.FragmentImageListingBinding;
import com.example.task.di.Injector;
import com.example.task.viewmodel.SearchViewModel;
import com.example.task.views.adapter.ImageListAdapter;
import com.example.task.views.uimodel.ImageUIModel;

import java.util.ArrayList;

import static com.example.task.common.Constants.BUNDLE_KEY;


public class ImageListingFragment extends Fragment {
    private FragmentImageListingBinding binding;
    private String searchText;
    private SearchViewModel searchViewModel;


    public ImageListingFragment() {

    }

    public static ImageListingFragment getInstance(String searchText) {
        ImageListingFragment imageListingFragment = new ImageListingFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_KEY, searchText);
        imageListingFragment.setArguments(bundle);
        return imageListingFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            searchText = getArguments().getString(BUNDLE_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_image_listing, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        searchViewModel = ViewModelProviders.of(getActivity(), Injector.getAppViewModelFacotry()).get(SearchViewModel.class);
        searchViewModel.getImageDetails(searchText);
        searchViewModel.getImageLiveData().observe(this, new Observer<ArrayList<ImageUIModel>>() {
            @Override
            public void onChanged(ArrayList<ImageUIModel> imageUIModels) {
                binding.progressBar.setVisibility(View.GONE);
                if (imageUIModels != null && imageUIModels.size() > 0) {
                    binding.tvNoImages.setVisibility(View.GONE);
                    binding.rvImages.setVisibility(View.VISIBLE);
                    initImageListingRecyclerView(imageUIModels);
                } else {
                    binding.tvNoImages.setVisibility(View.VISIBLE);
                    binding.rvImages.setVisibility(View.GONE);
                }
            }
        });
    }

    private void initImageListingRecyclerView(ArrayList<ImageUIModel> imageUIModels) {
        if (binding.rvImages != null) {
            binding.rvImages.setLayoutManager(new LinearLayoutManager(this.getContext()));
            binding.rvImages.setAdapter(new ImageListAdapter());
            binding.rvImages.setItemAnimator(new DefaultItemAnimator());
            ((ImageListAdapter)binding.rvImages.getAdapter()).setList(imageUIModels);
        }
    }
}
