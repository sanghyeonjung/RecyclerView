package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    Button reset;
    RecyclerView page;
    EditText editText;
    int colorFlag = 0;
    int cnt=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.buttonMainAdd);
        reset = findViewById(R.id.reset_button);
        page = findViewById(R.id.recyclerMainCommonList);
        editText = findViewById(R.id.edittext_add);

        ArrayList<Item> list= new ArrayList<>();
        RecyclerAdapter adapter = new RecyclerAdapter(list);
        page.setAdapter(adapter);
        page.setLayoutManager(new LinearLayoutManager(this));

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1 = (editText.getText().toString());
                list.add(new Item(num1,num1,num1));
                adapter.notifyDataSetChanged();
                editText.setText(null);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.clear();
                adapter.notifyDataSetChanged();
            }
        });
    }
}