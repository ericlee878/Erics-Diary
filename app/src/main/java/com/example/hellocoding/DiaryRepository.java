package com.example.hellocoding;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class DiaryRepository {

    private DiaryDao diaryDao;
    private LiveData<List<Diary>> diaries;

    // Note that in order to unit test the DiaryRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    DiaryRepository() {
        DiaryRoomDatabase db = DiaryRoomDatabase.getDatabase();
        diaryDao = db.diaryDao();
        diaries = diaryDao.getDiaries();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<Diary>> getDiaries() {
        return diaries;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(Diary diary) {
        DiaryRoomDatabase.databaseWriteExecutor.execute(() -> {
            diaryDao.insert(diary);
        });
    }
}
