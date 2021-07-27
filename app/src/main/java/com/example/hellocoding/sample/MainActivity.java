package com.example.hellocoding.sample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.example.hellocoding.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.nameButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String input = binding.nameEditText.getText().toString();
                binding.nameTextView.setText(input);
            }
        });

        binding.nameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                String input = binding.nameEditText.getText().toString();
                if (input.length() < 3)
                {
                    binding.nameButton.setEnabled(false);
                }
                else
                {
                    binding.nameButton.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });

        binding.gradeButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String input = binding.gradeEditText.getText().toString();
                binding.nameTextView.setText(input);
            }
        });

        binding.gradeEditText.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s2, int start2, int count2, int after2) { }

            @Override
            public void onTextChanged(CharSequence s2, int start2, int before2, int count2)
            {
                String input = binding.gradeEditText.getText().toString();
                if(input.length()<1)
                {
                    binding.gradeButton.setEnabled(false);
                }
                else
                {
                    binding.gradeButton.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s2) { }
        });

        binding.nextPageButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(SecondActivity.NAME, binding.nameEditText.getText().toString());
                bundle.putString(SecondActivity.GRADE, binding.gradeEditText.getText().toString());
                intent.putExtra(SecondActivity.BUNDLE, bundle);
                startActivity(intent);
            }
        });
        RecyclerViewAdapter adapter = new RecyclerViewAdapter();
        adapter.update(generatePeople());
        binding.recyclerview.setAdapter(adapter);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private List<Person> generatePeople() {
        List<Person> list = new ArrayList<Person>();
        list.add(new Person("Eric", "11th", "chicken"));
        list.add(new Person("Oscar", "1th","beef"));
        list.add(new Person("John", "2th","rice"));
        list.add(new Person("Brian", "3th","pizza"));
        list.add(new Person("Matthew", "4th","hamburgers"));
        list.add(new Person("Peter", "5th","pasta"));
        list.add(new Person("Jessica", "6th","pork"));
        list.add(new Person("Olivia", "7th","carrots"));
        list.add(new Person("Chris", "8th","eggs"));
        list.add(new Person("Daniel", "9th","fish"));
        list.add(new Person("David", "10th","soup"));
        list.add(new Person("Alex", "12th","noodles"));
        return list;
    }
}