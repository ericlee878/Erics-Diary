package com.example.hellocoding;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DiaryDao {
    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Diary diary);

    @Query("DELETE FROM diary_table")
    void deleteAll();

    @Query("SELECT * FROM diary_table ORDER BY datetime ASC")
    LiveData<List<Diary>> getDiaries();
}
