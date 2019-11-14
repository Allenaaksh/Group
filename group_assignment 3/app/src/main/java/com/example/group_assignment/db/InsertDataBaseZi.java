package com.example.group_assignment.db;

import android.os.AsyncTask;

import com.example.group_assignment.Characters;
import com.example.group_assignment.Word;

import java.util.ArrayList;

public class InsertDataBaseZi extends AsyncTask<Characters, Integer, ArrayList<Characters>> {
    private AsyncTaskDelegate2 delegate;

    // This asynctask will also need to be given a database instance, so it can perform database
    // queries. If your Room database class is named something else, change this.
    private AppDatabase database;

    public void setDelegate(AsyncTaskDelegate2 delegate) {
        this.delegate = delegate;
    }

    public void setDatabase(AppDatabase database) {
        this.database = database;
    }

    @Override
    protected ArrayList<Characters> doInBackground(Characters... Characters) {
        CharacterDAO characterDAO = database.characterDAO();
        characterDAO.insert(Characters);
        //Sometimes would not want to get books - two large query
        return (ArrayList<Characters>) characterDAO.getAllChar();
    }
    @Override
    protected void onPostExecute(ArrayList<Characters> result) {
        // Once doInBackground is completed, this method will run.
        // The "result" comes from doInBackground.

        // This is where we give our result to the delegate and let them handle it.
        // Our delegate should be the original Fragment/Activity, so then it can use the result to
        // update the UI, for example.

        delegate.handleTaskResult2(result);

    }


}
