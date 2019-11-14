package com.example.group_assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.group_assignment.db.AppDatabase;

import java.util.ArrayList;

public class Test extends AppCompatActivity {
    ArrayList totestlist;
    ArrayList fakelist;
    ArrayList wronglist;
    TextView totest=findViewById(R.id.totest);
    TextView ans1=findViewById(R.id.ans1);
    TextView ans2=findViewById(R.id.ans2);
    TextView ans3=findViewById(R.id.ans3);
    TextView ans4=findViewById(R.id.ans4);
    int testing_count;
    String correct_ans;
    boolean correct=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz1);
        Intent intent = getIntent();
        final String category = intent.getStringExtra ("category");
        if(category.equals("character")){
            totestlist= (ArrayList) AppDatabase.getInstance(getApplicationContext()).characterDAO().getStatusChar("totest");
            fakelist= (ArrayList) AppDatabase.getInstance(getApplicationContext()).characterDAO().getAllChar();
        }else{
            totestlist= (ArrayList) AppDatabase.getInstance(getApplicationContext()).wordDAO().getStatusWords("totest");
            fakelist= (ArrayList) AppDatabase.getInstance(getApplicationContext()).wordDAO().getAllWords();
        }
        testing_count=0;
        setuidata(testing_count);
        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setuidata(testing_count);
                if(ans1.getText().toString().equals(correct_ans)){
                    correct=true;
                }else{
                    wronglist.add(totestlist.get(testing_count));
                }

            }
        });
        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setuidata(testing_count);
                if(ans1.getText().toString().equals(correct_ans)){
                    correct=true;
                }else{
                    wronglist.add(totestlist.get(testing_count));
                }
            }
        });
        ans3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setuidata(testing_count);
                if(ans1.getText().toString().equals(correct_ans)){
                    correct=true;
                }else{
                    wronglist.add(totestlist.get(testing_count));
                }
            }
        });
        ans4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setuidata(testing_count);
                if(ans1.getText().toString().equals(correct_ans)){
                    correct=true;
                }else{
                    wronglist.add(totestlist.get(testing_count));
                }
            }
        });



    }
    public void setuidata(int testing_count){
        Object currentobject=totestlist.get(testing_count);
        Object newobject=totestlist.get(testing_count+1);
        if(newobject instanceof Characters){
            if(correct==true){
                ((Characters)currentobject).setStatus("learned");
            }
            totest.setText(((Characters) newobject).getCharacter());
            if(Math.random()%2==0){

            }else{

            }

        }else{
            if(correct==true){
                ((Word)currentobject).setStatus("learned");
            }
            totest.setText(((Word)newobject).getWord());
            if(Math.random()%2==0){

            }else{

            }
        }
        correct=false;
        testing_count=testing_count+1;
    }
}
