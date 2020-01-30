package com.example.task.utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.task.R;

public class FragmentUtils {


    public static void replaceFragment(Fragment destFragment, FragmentManager fragmentManager) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.base_container, destFragment);
        fragmentTransaction.commit();
    }
}
