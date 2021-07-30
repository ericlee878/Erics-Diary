package com.example.hellocoding;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class DiaryViewModel extends AndroidViewModel {

    private DiaryRepository repository;

    private final LiveData<List<Diary>> diaries;

    public DiaryViewModel (Application application) {
        super(application);
        repository = new DiaryRepository(application);
        diaries = repository.getDiaries();
    }

    LiveData<List<Diary>> getDiaries() { return diaries; }

    public void insert(Diary diary) { repository.insert(diary); }
}