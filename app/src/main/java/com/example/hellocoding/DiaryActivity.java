package com.example.hellocoding;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;


import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Gravity;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.hellocoding.databinding.ActivityDiaryBinding;

public class DiaryActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityDiaryBinding binding;
    public String diaryTextForDay;
    public String feelingForDay;
    private boolean clickedFeelingForDay = false;
    public static String DAY = "day";
    public static String MONTH = "month";
    public static String YEAR = "year";
    public static String BUNDLE = "bundle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent1 = getIntent();
        Bundle bundle = intent1.getBundleExtra(BUNDLE);
        DAY = bundle.getString(DAY);
        MONTH = bundle.getString(MONTH);
        YEAR = bundle.getString(YEAR);

        binding = ActivityDiaryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.diaryText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diaryTextForDay = binding.diaryText.getText().toString();
            }
            });

        binding.sadButton.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                    feelingForDay = "sad";
                    binding.sadButton.setTextColor(Color.BLACK);
                    binding.happyButton.setTextColor(Color.WHITE);
                    binding.neutralButton.setTextColor(Color.WHITE);
                    clickedFeelingForDay = true;
            }
        });
        binding.neutralButton.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View v){
                    feelingForDay = "neutral";
                    binding.neutralButton.setTextColor(Color.BLACK);
                    binding.happyButton.setTextColor(Color.WHITE);
                    binding.sadButton.setTextColor(Color.WHITE);
                    clickedFeelingForDay = true;
            }
        });
        binding.happyButton.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View v){
                feelingForDay = "happy";
                binding.happyButton.setTextColor(Color.BLACK);
                binding.sadButton.setTextColor(Color.WHITE);
                binding.neutralButton.setTextColor(Color.WHITE);
                clickedFeelingForDay = true;
            }
        });
        if(clickedFeelingForDay && !diaryTextForDay.isEmpty()) {
            binding.finishDiary.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    diaryTextForDay = binding.diaryText.getText().toString();
                }
            });
        }

        binding.dateHeader.setText(MONTH + " " + DAY + ", " + YEAR);
        binding.dateHeader.setGravity(Gravity.CENTER);
    }
}