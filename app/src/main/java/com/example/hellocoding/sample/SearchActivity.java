package com.example.hellocoding.sample;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.hellocoding.databinding.ActivitySearchBinding;

public class SearchActivity extends AppCompatActivity
{
    private ActivitySearchBinding binding;
    private SearchViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        viewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(SearchViewModel.class);

        viewModel.liveData.observe(this, new Observer<NYTModel>() {
            @Override
            public void onChanged(NYTModel nytModel) {
                if (!nytModel.response.docs.isEmpty()) {
                    String snippet = nytModel.response.docs.get(0).snippet;
                    binding.resultTextView.setText(snippet);
                    SearchRecyclerViewAdapter adapter = new SearchRecyclerViewAdapter();
                    adapter.update(nytModel.response.docs);
                    binding.searchRecyclerView.setAdapter(adapter);
                    binding.searchRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    binding.searchRecyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL));
                }
            }
        });

        binding.searchButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String searchTextValue = binding.searchEditText.getText().toString();
                viewModel.fetchArticles(searchTextValue);
            }
        });
    }
    }

