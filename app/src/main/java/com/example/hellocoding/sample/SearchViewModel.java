package com.example.hellocoding.sample;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class SearchViewModel extends ViewModel {
    private SearchRepository searchRepository = new SearchRepository();
    public MutableLiveData<NYTModel> liveData = searchRepository.liveData;

    public List<String> fetchArticles(String searchTerm) {
        searchRepository.fetchArticles(searchTerm);
        return new ArrayList<String>();
    }
}
