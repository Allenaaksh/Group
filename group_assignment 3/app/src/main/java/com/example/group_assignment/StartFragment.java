package com.example.group_assignment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.group_assignment.db.AppDatabase;
import com.example.group_assignment.db.AsyncTaskDelegate;
import com.example.group_assignment.db.InsertDataBaseCi;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StartFragment extends Fragment implements AsyncTaskDelegate {
    public StartFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final StartFragment thisFragment = this;
        final View view = inflater.inflate(R.layout.startfragment, container, false);
        final RequestQueue requestQueue = Volley.newRequestQueue(view.getContext());
        String url = " https://raw.githubusercontent.com/Allenaaksh/chinese-xinhua/master/data/ci.json";
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                Word[] enums = gson.fromJson(response, Word[].class);
                final List<Word> objectList = Arrays.asList(enums);
                AppDatabase appDatabase = AppDatabase.getInstance(view.getContext());
                //Async Task
                InsertDataBaseCi insertDataBase = new InsertDataBaseCi();
                insertDataBase.setDatabase(appDatabase);
                insertDataBase.setDelegate(thisFragment);

                insertDataBase.execute(enums);
            }

        };
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("GSON VOLLEY ERROR !");

            }
        };
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener, errorListener);
        requestQueue.add(stringRequest);


        Button character = view.findViewById(R.id.characters);
        Button word = view.findViewById(R.id.word);
        character.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = view.getContext();
                Intent intent = new Intent(context, Learn.class);
                intent.putExtra("category", "character");
                context.startActivity(intent);

            }
        });
        word.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = view.getContext();
                Intent intent = new Intent(context, Learn.class);
                intent.putExtra("category", "word");
                context.startActivity(intent);

            }
        });
        return view;

    }

    @Override
    public void handleTaskResult(ArrayList<Word> words) {

    }


    // Inflate the layout for this fragment

    // ImageView imageView8= view.findViewById(R.id.imageView8);
    // ImageView imageView9= view.findViewById(R.id.imageView9);


}

