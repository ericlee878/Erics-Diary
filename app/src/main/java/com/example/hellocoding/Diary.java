package com.example.hellocoding;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "diary_table")
public class Diary {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @NonNull
    @ColumnInfo(name = "feeling")
    public String feeling;
    @NonNull
    @ColumnInfo(name = "content")
    public String content;
    @NonNull
    @ColumnInfo(name = "datetime")
    public String dateTime;

    public Diary(@NonNull String feeling, @NonNull String content, @NonNull String dateTime) {
        this.feeling = feeling;
        this.content = content;
        this.dateTime = dateTime;
    }
}