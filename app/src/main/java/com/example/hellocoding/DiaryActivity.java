package com.example.hellocoding;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;


import com.example.hellocoding.sample.SearchViewModel;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.hellocoding.databinding.ActivityDiaryBinding;

import java.util.List;

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
    public DiaryViewModel viewModel;

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
        viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(DiaryViewModel.class);

        //
//        binding.diaryText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                diaryTextForDay = binding.diaryText.getText().toString();
//            }
//            });

        binding.sadButton.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                    feelingForDay = "sad";
                    binding.sadButton.setTextColor(Color.BLACK);
                    binding.happyButton.setTextColor(Color.WHITE);
                    binding.neutralButton.setTextColor(Color.WHITE);
                    clickedFeelingForDay = true;
                updateButtonState();
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
                updateButtonState();
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
                updateButtonState();
            }
        });

        binding.diaryText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateButtonState();
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });

        binding.dateHeader.setText(MONTH + " " + DAY + ", " + YEAR);
        binding.dateHeader.setGravity(Gravity.CENTER);
        binding.finishDiary.setEnabled(false);

        binding.finishDiary.setOnClickListener(new View.OnClickListener ()
        {
            @Override
            public void onClick (View v) {
                Diary diary = new Diary(feelingForDay, binding.diaryText.getText().toString(), MONTH + " " + DAY + ", " + YEAR);
                viewModel.insert(diary);
            }});

        viewModel.getDiaries().observe(this, new Observer<List<Diary>>() {
            @Override
            public void onChanged(List<Diary> diaries) {
                for(int i=0;i<diaries.size();i++)
                {
                    if(diaries.get(i).dateTime.equals(MONTH + " " + DAY + ", " + YEAR))
                    {
                        Toast.makeText(getApplicationContext(), "Found diary", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void updateButtonState() {
        if (clickedFeelingForDay && !binding.diaryText.getText().toString().isEmpty()) {
            binding.finishDiary.setEnabled(true);
        } else {
            binding.finishDiary.setEnabled(false);
        }
    }
}