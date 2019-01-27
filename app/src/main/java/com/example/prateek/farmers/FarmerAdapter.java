package com.example.prateek.farmers;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class FarmerAdapter extends RecyclerView.Adapter<FarmerAdapter.FarmerViewHolder> {

    private int[] mImages;
    private String[] mNames;
    private String[] mStock;
    private String[] mPorders;

    public class FarmerViewHolder extends RecyclerView.ViewHolder{
        public ImageView CropImage;
        public TextView Name,Stock,Porders;

        public FarmerViewHolder(View itemView) {
            super(itemView);
            Log.i("Info","FarmerViewHolder called");
            CropImage=(ImageView) itemView.findViewById(R.id.crop_image);
            Name=(TextView) itemView.findViewById(R.id.name);
            Stock=(TextView) itemView.findViewById(R.id.stock);
            Porders=(TextView) itemView.findViewById(R.id.porders);
        }
    }


    public FarmerAdapter( int[] Images, String[] Names, String[] Stock, String[] Porders){
        mImages=Images;
        mNames=Names;
        mStock=Stock;
        mPorders=Porders;
    }
    @NonNull
    @Override
    public FarmerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.i("Info","onCreateViewHolder called");
        View v =  LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_layout, viewGroup, false);
        FarmerViewHolder farmerViewHolder=new FarmerViewHolder(v);
        return farmerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FarmerViewHolder farmerViewHolder, int i) {
        Log.i("Info","onBindViewholder called");
        farmerViewHolder.CropImage.setImageResource(mImages[i]);
        farmerViewHolder.Stock.setText(mStock[i]);
        farmerViewHolder.Name.setText(mNames[i]);
        farmerViewHolder.Porders.setText(mPorders[i]);
    }

    @Override
    public int getItemCount() {
        return mImages.length;
    }

}
