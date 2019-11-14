package com.example.group_assignment.db;  // CHANGE ME

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.group_assignment.Characters;
import com.example.group_assignment.Word;

@Database(entities = {Characters.class, Word.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CharacterDAO characterDAO();
    public abstract WordDAO wordDAO();
    private static AppDatabase instance;
    public static AppDatabase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context, AppDatabase.class, "breedsDb")
                    .build();
        }
        return instance;
    }
}