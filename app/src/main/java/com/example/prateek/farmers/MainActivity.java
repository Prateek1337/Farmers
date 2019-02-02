package com.example.prateek.farmers;

import android.content.Intent;
import android.os.CpuUsageInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Crop> cropList;
    FarmerAdapter farmerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView CropList = (RecyclerView) findViewById(R.id.recyclerView);
        cropList=new ArrayList<>();

        cropList.add(new Crop(R.drawable.wheat,"Wheat","1","2"));
        cropList.add(new Crop(R.drawable.corn,"Corn","1","2"));
        cropList.add(new Crop(R.drawable.sugarcane,"Sugarcane","1","2"));
        cropList.add(new Crop(R.drawable.rice,"Rice","1","2"));

        CropList.setLayoutManager(new LinearLayoutManager(this));
        farmerAdapter=new FarmerAdapter(this,cropList);
        CropList.setAdapter(farmerAdapter);
        EditText searchBar=(EditText) findViewById(R.id.searchbar);
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

        Onclick();

        ImageView profileImage=findViewById(R.id.profileImage);
        profileImage.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                openActivity2();
            }
        });
    }
    public void openActivity2(){
        Intent intent=new Intent(this,Activity2.class);
        startActivity(intent);
    }


    private void filter(String text){
        List<Crop> filteredList=new ArrayList<>();
        for (Crop crop:cropList){
            if(crop.getName().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(crop);
            }
        }
        farmerAdapter.filterList(filteredList);
    }

    public void Onclick(){
        farmerAdapter.setOnItemClickListener(new FarmerAdapter.OnItemCLickListener() {
            @Override
            public void onItemClick(int position) {
                int pos=position;
                Log.i("Item clicked",String.valueOf(pos));
                if(pos==0){
                    Intent intent=new Intent(MainActivity.this,WheatActivity.class);
                    startActivity(intent);
                }
                else if(pos==1){
                    Intent intent=new Intent(MainActivity.this,CornActivity.class);
                    startActivity(intent);
                }
                else if(pos==2){
                    Intent intent=new Intent(MainActivity.this,SugarcaneActivity.class);
                    startActivity(intent);
                }
                else{
                    Intent intent=new Intent(MainActivity.this,RiceActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}