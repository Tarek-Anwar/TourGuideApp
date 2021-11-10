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

public class ShoppingFragment extends Fragment implements PlaceAdapter.PlaceListener {

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
        places.add(new PlaceInfo(getString(R.string.sho_Khan_name),
                getString(R.string.sho_Khan_addeess),
                getString(R.string.sho_Khan_about),
                getString(R.string.sho_Khanlocation),
                R.drawable.sho_khan));

        places.add(new PlaceInfo(getString(R.string.sho_Festival_name),
                getString(R.string.sho_Festival_addeess),
                getString(R.string.sho_Festival_about),
                getString(R.string.sho_Festival_phone),
                getString(R.string.sho_Festival_location),
                R.drawable.sho_festival));

        places.add(new PlaceInfo(getString(R.string.sho_Stars_name),
                getString(R.string.sho_Stars_addeess),
                getString(R.string.sho_Stars_about),
                getString(R.string.sho_Stars_phone),
                getString(R.string.sho_Stars_location),
                R.drawable.sho_stars));

        places.add(new PlaceInfo(getString(R.string.sho_Arabia_name),
                getString(R.string.sho_Arabia_addeess),
                getString(R.string.sho_Arabia_about),
                getString(R.string.sho_Arabia_phone),
                getString(R.string.sho_Arabia_location),
                R.drawable.sho_arabia));

        places.add(new PlaceInfo(getString(R.string.sho_Downtown_name),
                getString(R.string.sho_Downtown_addeess),
                getString(R.string.sho_Downtown_about),
                getString(R.string.sho_Downtown_phone),
                getString(R.string.sho_Downtown_location),
                R.drawable.sho_downtown));

        places.add(new PlaceInfo(getString(R.string.sho_Genena_name),
                getString(R.string.sho_Genena_addeess),
                getString(R.string.sho_Genena_about),
                getString(R.string.sho_Genena_phone),
                getString(R.string.sho_Genena_location),
                R.drawable.sho_genena));

        places.add(new PlaceInfo(getString(R.string.sho_Sun_name),
                getString(R.string.sho_Sun_addeess),
                getString(R.string.sho_Sun_about),
                getString(R.string.sho_Stars_location),
                R.drawable.sho_sun));

        places.add(new PlaceInfo(getString(R.string.sho_Tiba_name),
                getString(R.string.sho_Tiba_addeess),
                getString(R.string.sho_Tiba_about),
                getString(R.string.sho_Tiba_phone),
                getString(R.string.sho_Tiba_location),
                R.drawable.sho_tiba));

        //defind object from PlaceAdapter to pass to recyclerView
        PlaceAdapter adapter = new PlaceAdapter(getContext(),places,this);
        //put LinearLayoutManager to recyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        //set adapter
        recyclerView.setAdapter(adapter);
        return root;
    }

    //method listener to recyclerView substitute of tOnItemClickListener
    @Override
    public void PlaceListener(PlaceInfo placeInfo) {
        Intent intent = new Intent(getContext(), PlaceShow.class);
        //created intent to pass data
        intent.putExtra(PlaceShow.TITLE_ACTIVITY_KEY , 3);
        // Sent data
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
