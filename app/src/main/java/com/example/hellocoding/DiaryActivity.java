package com.example.hellocoding;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
                if (!clickedFeelingForDay) {
                    feelingForDay = "sad";
                    binding.sadButton.setTextColor(Color.BLACK);
                    clickedFeelingForDay = true;
                }
            }
        });
        binding.neutralButton.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View v){
                if (!clickedFeelingForDay) {
                    feelingForDay = "neutral";
                    binding.neutralButton.setTextColor(Color.BLACK);
                    clickedFeelingForDay = true;
                }
            }
        });
        binding.happyButton.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View v){
                if (!clickedFeelingForDay){
                feelingForDay = "happy";
                binding.happyButton.setTextColor(Color.BLACK);
                clickedFeelingForDay = true;
                }
            }
        });
        binding.finishDiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diaryTextForDay = binding.diaryText.getText().toString();
            }
        });
    }
}