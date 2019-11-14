package com.example.group_assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.group_assignment.db.AppDatabase;

import java.util.ArrayList;

public class Learn extends AppCompatActivity {
    ArrayList tolearnlist;
    Button next=findViewById(R.id.next);;
    TextView characters=findViewById(R.id.characters);;
    TextView pinyin=findViewById(R.id.pinyin);;
    TextView explain=findViewById(R.id.explain);;
    TextView example=findViewById(R.id.example);;
    TextView translation=findViewById(R.id.translation);
    int learning_count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn);
        Intent intent = getIntent();
        final String category = intent.getStringExtra ("category");
        if(category.equals("character")){
            tolearnlist= (ArrayList) AppDatabase.getInstance(getApplicationContext()).characterDAO().getStatusChar("new");
        }else{
            tolearnlist= (ArrayList) AppDatabase.getInstance(getApplicationContext()).wordDAO().getStatusWords("new");
        }
        setuidata(tolearnlist.get(learning_count));
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                learning_count=learning_count+1;
                setuidata(tolearnlist.get(learning_count));
            }
        });

    }

    public void setuidata(Object object){
        if(object instanceof Characters){
            characters.setText(((Characters) object).getCharacter());
            pinyin.setText(((Characters) object).getPinyin());
            explain.setText(((Characters) object).getExplaination());
            translation.setText(((Characters) object).getTranslation());
            ((Characters) object).setStatus("totest");
        }else{
            characters.setText(((Word)object).getWord());
            pinyin.setText(((Word)object).getPinyin());
            explain.setText(((Word)object).getExplanation());
            example.setText(((Word)object).getExample());
            translation.setText(((Word) object).getTranslation());
            ((Word)object).setStatus("totest");
        }

    }

}
