package com.example.hellocoding;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class DiaryViewModel extends ViewModel {

    private DiaryRepository repository = new DiaryRepository();

    private final LiveData<List<Diary>> diaries = repository.getDiaries();

    LiveData<List<Diary>> getDiaries() { return diaries; }

    public void insert(Diary diary) { repository.insert(diary); }
}