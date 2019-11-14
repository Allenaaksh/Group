package com.example.group_assignment.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.group_assignment.Word;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface WordDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert (Word words);
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    public void insert(Word[] booksArrayList);
    @Query("select * from Word where word like :word")
    List<Word> getSimilarWords(String word);
    @Query("SELECT * FROM WORD WHERE status=:status")
    List<Word> getStatusWords(String status);
    @Query("SELECT * FROM Word")
    List<Word> getAllWords();




}
