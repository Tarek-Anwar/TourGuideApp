package com.android.tourguide.Adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.tourguide.R;

import java.util.ArrayList;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.viewholder> {
    //define context
    Context context;
    //Define the list to put the places data in
    ArrayList<PlaceInfo> placeArray;
    // object from interface Listener
    PlaceListener placeListener;

    public PlaceAdapter(Context context, ArrayList<PlaceInfo> placeArray , PlaceListener placeListener) {
        this.context = context;
        this.placeArray = placeArray;
        this.placeListener = placeListener;
    }

    //viewholder from RecyclerView.Adapter
    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Define View to bind xml elements
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.place_in_list,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        // reference from position class placeInfo
        PlaceInfo placeInfo = placeArray.get(position);
        //call method blud xml
        holder.bludIn(placeInfo);
    }

    // return Count list to RecyclerView.Adapter
    @Override
    public int getItemCount() {
        return placeArray.size();
    }

    // inner class viewholder
    public class viewholder extends RecyclerView.ViewHolder  {

        // define elements
        ImageView imageView;
        TextView placeName , placeAddress;
        LinearLayout placeView;
        //find elements from xml
        public viewholder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.place_image);
            placeName = itemView.findViewById(R.id.name_place_text);
            placeAddress = itemView.findViewById(R.id.address_place_text);
            placeView = itemView.findViewById(R.id.place_item_view);
        }

        // method bluid view in RecyclerView
        public void bludIn(PlaceInfo placeInfo){
            //set date in elemenet
            placeName.setText(placeInfo.getNamePlace());
            placeAddress.setText(placeInfo.getPlaceAddress());
            //call method decodeSampleBitmap
            Bitmap bitmap = decodeSampleBitmap(context.getResources(),placeInfo.getPlaceImg(),50,35);
            //set img
            imageView.setImageBitmap(bitmap);
            // Listener view for element in RecyclerView
            placeView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    placeListener.PlaceListener(placeInfo);
                }
            });
        }
    }

    // two method to Reduce image size to save memory and increase display efficiency
    public Bitmap decodeSampleBitmap(Resources res , int resId, int reqWidth , int reqHeight) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res,resId,options);
        options.inSampleSize = calcSampleSize(options ,reqWidth,reqHeight);
        options.inJustDecodeBounds =false;
        return BitmapFactory.decodeResource(res,resId,options);
    }
    public  int calcSampleSize(BitmapFactory.Options options ,int reqWihdth , int reqHight ){
        final int height = options.outHeight;
        final  int width = options.outWidth;
        int inSampleSize = 1;
        if (height>reqHight || width>reqHight){
            final int halfHeight = height/2;
            final  int halfWidth = width/2;
            while ((halfHeight/inSampleSize) > reqHight && (halfWidth/inSampleSize) > reqWihdth){
                inSampleSize*=2;
            }
        } return inSampleSize;
    }

    //interface to Listener view
    public interface PlaceListener{
        void PlaceListener(PlaceInfo placeInfo);
    }
}
