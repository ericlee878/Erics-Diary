package com.example.hellocoding.sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hellocoding.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    private ActivitySecondBinding binding;
    public static String NAME = "name";
    public static String GRADE = "grade";
    public static String BUNDLE = "bundle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(BUNDLE);
        String name = bundle.getString(NAME);
        String grade = bundle.getString(GRADE);

        binding.introduction.setText("I am " + name + ", " + grade);

        binding.secondNextPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(ThirdActivity.NAME, name);
                bundle.putString(ThirdActivity.GRADE, grade);
                intent.putExtra(ThirdActivity.BUNDLE, bundle);
                startActivity(intent);
            }
        });

    }
}
