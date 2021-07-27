package com.example.hellocoding.sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hellocoding.databinding.ActivitySecondBinding;
import com.example.hellocoding.databinding.ActivityThirdBinding;

public class ThirdActivity extends AppCompatActivity
{
    private ActivityThirdBinding binding;
    public static String NAME = "name";
    public static String GRADE = "grade";
    public static String BUNDLE = "bundle";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = ActivityThirdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(BUNDLE);
        String name = bundle.getString(NAME);
        String grade = bundle.getString(GRADE);
    }
}

