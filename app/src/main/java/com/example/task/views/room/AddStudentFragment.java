package com.example.task.views.room;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.task.R;
import com.example.task.data.model.Student;
import com.example.task.databinding.FragmentAddStudentBinding;
import com.example.task.di.Injector;
import com.example.task.viewmodel.DatabaseViewModel;


public class AddStudentFragment extends Fragment implements View.OnClickListener{
    private FragmentAddStudentBinding binding;
    private DatabaseViewModel databaseViewModel;

    public AddStudentFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_student, container, false);
        binding.setHandler(this);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        databaseViewModel = ViewModelProviders.of(getActivity(), Injector.getAppViewModelFacotry()).get(DatabaseViewModel.class);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                databaseViewModel.addStudentData(new Student(binding.name.getText().toString(),
                        Integer.valueOf(binding.rollNo.getText().toString()), binding.standard.getText().toString(), binding.from.getText().toString()))
                        .observe(getViewLifecycleOwner(), new Observer<Boolean>() {
                            @Override
                            public void onChanged(Boolean aBoolean) {
                                if(aBoolean)
                                    Toast.makeText(getContext(),"Data saved", Toast.LENGTH_SHORT).show();
                                else
                                    Toast.makeText(getContext(),"Data saving failed", Toast.LENGTH_SHORT).show();
                            }
                        });
                break;
        }
    }
}
