package com.android.tourguide.Fragmet;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.tourguide.Adapter.PlaceAdapter;
import com.android.tourguide.Adapter.PlaceInfo;
import com.android.tourguide.Adapter.PlaceShow;
import com.android.tourguide.R;

import java.util.ArrayList;

public class HistoricalFragmet extends Fragment implements PlaceAdapter.PlaceListener {
    //Define the list to put the places data in
    ArrayList <PlaceInfo> places = new ArrayList<>();
    //define RecyclerView
    RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //Define View to bind xml elements
        View root = inflater.inflate(R.layout.fragment_list_place, container, false);
        //find element recyclerView
        recyclerView = root.findViewById(R.id.recycler_view);
        // set Data places
        places.add(new PlaceInfo(getString(R.string.his_pyramids_name),
                getString(R.string.his_pyramids_addeess),
                getString(R.string.his_pyramids_about),
                getString(R.string.his_pyramids_phone),
                getString(R.string.his_pyramids_location),
                R.drawable.his_pyramids));

        places.add(new PlaceInfo(getString(R.string.his_EgyMuseum_name),
                getString(R.string.his_EgyMuseum_addeess),
                getString(R.string.his_EgyMuseum_about),
                getString(R.string.his_EgyMuseum_phone),
                getString(R.string.his_EgyMuseum_location),
                R.drawable.his_egy_museum));

        places.add(new PlaceInfo(getString(R.string.his_Azhar_name),
                getString(R.string.his_Azhar_addeess),
                getString(R.string.his_Azhar_about),
                getString(R.string.his_Azhar_location),
                R.drawable.his_azhar));

        places.add(new PlaceInfo(getString(R.string.his_Coptic_name),
                getString(R.string.his_Coptic_addeess),
                getString(R.string.his_Coptic_about),
                getString(R.string.his_Coptic_phone),
                getString(R.string.his_Coptic_location),
                R.drawable.his_coptic));

        places.add(new PlaceInfo(getString(R.string.his_Citadel_name),
                getString(R.string.his_Citadel_addeess),
                getString(R.string.his_Citadel_about),
                getString(R.string.his_Citadel_phone),
                getString(R.string.his_Citadel_location),
                R.drawable.his_citadel));

        places.add(new PlaceInfo(getString(R.string.his_Tower_name),
                getString(R.string.his_Tower_addeess),
                getString(R.string.his_Tower_about),
                getString(R.string.his_Tower_phone),
                getString(R.string.his_Tower_location),
                R.drawable.his_tower));

        places.add(new PlaceInfo(getString(R.string.his_Baron_name),
                getString(R.string.his_Baron_addeess),
                getString(R.string.his_Baron_about),
                getString(R.string.his_Baron_location),
                R.drawable.his_barone));

        places.add(new PlaceInfo(getString(R.string.his_Sphinx_name),
                getString(R.string.his_Sphinx_addeess),
                getString(R.string.his_Sphinx_about),
                getString(R.string.his_Sphinx_location),
                R.drawable.his_sphinx));

        places.add(new PlaceInfo(getString(R.string.his_Opera_name),
                getString(R.string.his_Opera_addeess),
                getString(R.string.his_Opera_about),
                getString(R.string.his_Opera_phone),
                getString(R.string.his_Opera_location),
                R.drawable.his_opera));

        places.add(new PlaceInfo(getString(R.string.his_Church_name),
                getString(R.string.his_Church_addeess),
                getString(R.string.his_Church_about),
                getString(R.string.his_Church_location),
                R.drawable.his_church));

        //defind object from PlaceAdapter to pass to recyclerView
        PlaceAdapter adapter = new PlaceAdapter(getContext(),places,this);
        //put LinearLayoutManager to recyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext() , RecyclerView.VERTICAL , false));
        //set adapter
        recyclerView.setAdapter(adapter);
        return root;
    }
    //method listener to recyclerView substitute of tOnItemClickListener
    @Override
    public void PlaceListener(PlaceInfo placeInfo) {
        //created intent to pass data
        Intent intent = new Intent(getContext(), PlaceShow.class);
        // Sent data
        intent.putExtra(PlaceShow.TITLE_ACTIVITY_KEY , 1);
        intent.putExtra(PlaceShow.ABOUT_PLACE_KEY , placeInfo.getAboutPlace());
        intent.putExtra(PlaceShow.NAME_PLACE_KEY , placeInfo.getNamePlace());
        intent.putExtra(PlaceShow.ADDEESS_PLACE_KEY , placeInfo.getPlaceAddress());
        intent.putExtra(PlaceShow.PHONE_PLACE_KEY , placeInfo.getPhonePlace());
        intent.putExtra(PlaceShow.lOCATION_PLACE_KEY , placeInfo.getLactionPlace());
        intent.putExtra(PlaceShow.PHOTO_PLACE_KEY , placeInfo.getPlaceImg());
        //  start intent
        startActivity(intent);
    }
}
