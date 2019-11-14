package com.example.group_assignment.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.group_assignment.Characters;
import com.example.group_assignment.Word;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface CharacterDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert (Characters characters);
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insert(Characters[] characters);
    @Query("select * from Characters where status=:status")
    List<Characters> getStatusChar(String status);
    @Query("SELECT * FROM Characters")
    List<Characters> getAllChar();

}
