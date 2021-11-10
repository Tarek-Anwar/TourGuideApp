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

public class RestaurantsFragment extends Fragment implements PlaceAdapter.PlaceListener {

    //Define the list to put the places data in
    ArrayList<PlaceInfo> places = new ArrayList<>();

    //define RecyclerView
    RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //Define View to bind xml elements
        View root = inflater.inflate(R.layout.fragment_list_place, container, false);
        //find element recyclerView
        recyclerView  = root.findViewById(R.id.recycler_view);
        // set Data places
        places.add(new PlaceInfo(getString(R.string.res_AbouElsid_name),
                getString(R.string.res_AbouElsid_addeess),
                getString(R.string.res_AbouElsid_about),
                getString(R.string.res_AbouElsid_phone),
                getString(R.string.res_AbouElsid_location),
                R.drawable.res_abouelsid));

        places.add(new PlaceInfo(getString(R.string.res_Rotating_name),
                getString(R.string.res_Rotating_addeess),
                getString(R.string.res_Rotating_about),
                getString(R.string.res_Rotating_phone),
                getString(R.string.res_Rotating_location),
                R.drawable.res_rotating));

        places.add(new PlaceInfo(getString(R.string.res_Naguib_name),
                getString(R.string.res_Naguib_addeess),
                getString(R.string.res_Naguib_about),
                getString(R.string.res_Naguib_phone),
                getString(R.string.res_Naguib_location),
                R.drawable.res_naguib));

        places.add(new PlaceInfo(getString(R.string.res_Tarek_name),
                getString(R.string.res_Tarek_addeess),
                getString(R.string.res_Tarek_about),
                getString(R.string.res_Tarek_phone),
                getString(R.string.res_Tarek_location),
                R.drawable.res_tarek));

        places.add(new PlaceInfo(getString(R.string.res_Taboula_name),
                getString(R.string.res_Taboula_addeess),
                getString(R.string.res_Taboula_about),
                getString(R.string.res_Taboula_phone),
                getString(R.string.res_Taboula_location),
                R.drawable.res_taboula));

        places.add(new PlaceInfo(getString(R.string.res_Saigon_name),
                getString(R.string.res_Saigon_addeess),
                getString(R.string.res_Saigon_about),
                getString(R.string.res_Saigon_phone),
                getString(R.string.res_Saigon_location),
                R.drawable.res_saigon));

        //defind object from PlaceAdapter to pass to recyclerView
        PlaceAdapter adapter = new PlaceAdapter(getContext(),places,this );
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
        intent.putExtra(PlaceShow.TITLE_ACTIVITY_KEY , 2);
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
