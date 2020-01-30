package com.example.task.views.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.task.R;
import com.example.task.databinding.ActivityRoomDbBinding;
import com.example.task.utils.FragmentUtils;

public class RoomDbActivity extends AppCompatActivity {
    private ActivityRoomDbBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_room_db);
        FragmentUtils.replaceFragment(new DbMenuFragment(), getSupportFragmentManager());
    }
}
