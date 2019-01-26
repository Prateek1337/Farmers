package com.example.prateek.farmers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int[] IMAGES={R.drawable.wheat,R.drawable.corn,R.drawable.sugarcane,R.drawable.rice,R.drawable.dal};
    String [] NAMES={"Wheat","Corn","Sugarcane","Rice","dal"};
    String[] STOCKS={"5","4","3","2","1"};
    String[] PORDERS={"0","1","2","3","4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listView=(ListView) findViewById(R.id.listview);
        CustomAdapter customAdapter=new CustomAdapter();
        listView.setAdapter(customAdapter);
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView=getLayoutInflater().inflate(R.layout.custom_layout,null);
            ImageView crop_image=(ImageView) convertView.findViewById(R.id.crop_image);
            TextView name=(TextView) convertView.findViewById(R.id.name);
            TextView stock=(TextView) convertView.findViewById(R.id.stock);
            TextView porders=(TextView) convertView.findViewById(R.id.porders);
            crop_image.setImageResource(IMAGES[position]);
            name.setText(NAMES[position]);
            stock.setText(STOCKS[position]);
            porders.setText(PORDERS[position]);
            return convertView;
        }
    }
}