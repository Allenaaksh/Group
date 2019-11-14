package com.example.group_assignment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class TestFragment extends Fragment {
    public TestFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        final View view=inflater.inflate(R.layout.startfragment , container, false);
        ImageView imageView8= view.findViewById(R.id.imageView8);
        ImageView imageView9= view.findViewById(R.id.imageView9);
        //Button word=view.findViewById(R.id.word);
        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context=view.getContext();
                Intent intent = new Intent(context, Test.class);
                intent.putExtra("category","character");
                context.startActivity(intent);

            }
        });
        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context=view.getContext();
                Intent intent = new Intent(context, Test.class);
                intent.putExtra("category","word");
                context.startActivity(intent);
            }
        });
        return view;

    }
}
