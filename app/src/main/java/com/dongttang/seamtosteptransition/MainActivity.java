package com.dongttang.seamtosteptransition;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SampleAdaptor.RecyclerViewClickListener{

    SampleAdaptor adaptor;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        adaptor = new SampleAdaptor(10, this);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adaptor);
        recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public void onListItemClicked(int position) {

        Toast.makeText(this, String.valueOf(position) + " is clicked!", Toast.LENGTH_SHORT).show();

    }

}
