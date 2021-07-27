package com.example.hellocoding;

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
            public void onClick(View v){
                feelingForDay = "sad";
            }
        });
        binding.neutralButton.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View v){
                feelingForDay = "neutral";
            }
        });
        binding.happyButton.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View v){
                feelingForDay = "happy";
            }
        });
    }
}