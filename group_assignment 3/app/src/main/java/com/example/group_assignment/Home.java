package com.example.group_assignment;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.group_assignment.db.AppDatabase;
import com.example.group_assignment.db.AsyncTaskDelegate2;
import com.example.group_assignment.db.InsertDataBaseCi;
import com.example.group_assignment.db.InsertDataBaseZi;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Home extends AppCompatActivity implements AsyncTaskDelegate2 {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        final Home thisActivity = this;
        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String url = "https://raw.githubusercontent.com/Allenaaksh/chinese-xinhua/master/data/word.json";
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                Characters[] enums = gson.fromJson(response, Characters[].class);
                final List<Characters> objectList = Arrays.asList(enums);
                AppDatabase appDatabase = AppDatabase.getInstance(getApplicationContext());
                //Async Task
                InsertDataBaseZi insertDataBase = new InsertDataBaseZi();
                insertDataBase.setDatabase(appDatabase);
                insertDataBase.setDelegate(thisActivity);

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
        setContentView(R.layout.home);
        Fragment fragment = new StartFragment();
        swapFragment(fragment);
        bottomNavigationView = findViewById(R.id.bottom_navi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.learn) {
                    Fragment fragment = new StartFragment();
                    swapFragment(fragment);
                    return true;
                } else if (menuItem.getItemId() == R.id.profile) {
                    Fragment fragment = new ProfileFragment();
                    swapFragment(fragment);
                    return true;
                } else if (menuItem.getItemId() == R.id.test) {
                    Fragment fragment = new TestFragment();
                    swapFragment(fragment);
                    return true;
                }
                return false;
            }
        });
    }

    public void swapFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_slot, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void handleTaskResult2(ArrayList<Characters> characters) {

    }
}
