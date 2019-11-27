package com.msssolution.convostartertest2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends SingleFragment {

    @Override
    protected Fragment createFragment() {
        return new RecyclerFragment().newInstance();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
