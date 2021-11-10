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

public class StreetsFragment extends Fragment implements PlaceAdapter.PlaceListener {

    //Define the list to put the places data in
    ArrayList<PlaceInfo> places = new ArrayList<>();
    //define RecyclerView
    RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //Define View to bind xml elements
        View root = inflater.inflate(R.layout.fragment_list_place, container, false);
        //find element recyclerView
        recyclerView = root.findViewById(R.id.recycler_view);
        // set Data places
        places.add(new PlaceInfo(getString(R.string.str_Nile_name),
                getString(R.string.str_Nile_addeess),
                getString(R.string.str_Nile_about),
                getString(R.string.str_Nile_location),
                R.drawable.str_nile));

        places.add(new PlaceInfo(getString(R.string.str_Khan_name),
                getString(R.string.str_Khan_addeess),
                getString(R.string.str_Khan_about),
                getString(R.string.str_Khan_location),
                R.drawable.str_khan));

        places.add(new PlaceInfo(getString(R.string.str_Azhar_name),
                getString(R.string.str_Azhar_addeess),
                getString(R.string.str_Azhar_about),
                getString(R.string.str_Azhar_location),
                R.drawable.str_azhar));

        places.add(new PlaceInfo(getString(R.string.str_Moez_name),
                getString(R.string.str_Moez_addeess),
                getString(R.string.str_Moez_about),
                getString(R.string.str_Moez_location),
                R.drawable.str_moez));

        places.add(new PlaceInfo(getString(R.string.str_Ghouria_name),
                getString(R.string.str_Ghouria_addeess),
                getString(R.string.str_Ghouria_about),
                getString(R.string.str_Ghouria_location),
                R.drawable.str_ghouria));

        places.add(new PlaceInfo(getString(R.string.str_Kasr_name),
                getString(R.string.str_Kasr_addeess),
                getString(R.string.str_Kasr_about),
                getString(R.string.str_Kasr_location),
                R.drawable.str_kasr));

        places.add(new PlaceInfo(getString(R.string.str_Talaat_name),
                getString(R.string.str_Talaat_addeess),
                getString(R.string.str_Talaat_about),
                getString(R.string.str_Talaat_location),
                R.drawable.str_talaat));

        places.add(new PlaceInfo(getString(R.string.str_Zuwayla_name),
                getString(R.string.str_Zuwayla_addeess),
                getString(R.string.str_Zuwayla_about),
                getString(R.string.str_Zuwayla_location),
                R.drawable.str_zuwayla));

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
        intent.putExtra(PlaceShow.TITLE_ACTIVITY_KEY , 4);
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
