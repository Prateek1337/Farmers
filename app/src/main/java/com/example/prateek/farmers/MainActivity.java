package com.example.prateek.farmers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int[] IMAGES = {R.drawable.wheat, R.drawable.corn, R.drawable.sugarcane, R.drawable.rice, R.drawable.dal};
    String[] NAMES = {"Wheat", "Corn", "Sugarcane", "Rice", "dal"};
    String[] STOCKS = {"5", "4", "3", "2", "1"};
    String[] PORDERS = {"0", "1", "2", "3", "4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView CropList = (RecyclerView) findViewById(R.id.recyclerView);
        CropList.setLayoutManager(new LinearLayoutManager(this));
        CropList.setAdapter(new FarmerAdapter(IMAGES, NAMES, STOCKS, PORDERS));
    }
}