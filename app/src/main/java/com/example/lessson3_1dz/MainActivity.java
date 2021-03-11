package com.example.lessson3_1dz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MainAdapter adapter;
    List<String> list;
    RecyclerView recyclerView;
    EditText editText;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        if (savedInstanceState != null)
            list = savedInstanceState.getStringArrayList("arrayList");
        init();
        btn.setOnClickListener(this);

    }

    private void init() {
        recyclerView = findViewById(R.id.recyclerView);
        editText = findViewById(R.id.editText);
        btn = findViewById(R.id.button);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter =  new MainAdapter(list,this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        String itemText = editText.getText().toString();
        if (!itemText.equals("")){
            list.add(itemText);
            adapter.notifyDataSetChanged();
            editText.setText("");
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("arrayList", (ArrayList<String>) list);
    }

}