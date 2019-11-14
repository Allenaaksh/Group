package com.example.group_assignment.db;

import com.example.group_assignment.Characters;
import com.example.group_assignment.Word;

import java.util.ArrayList;

public interface AsyncTaskDelegate {
    void handleTaskResult(ArrayList<Word> words);
    //void handleTaskResult(String results);
}
