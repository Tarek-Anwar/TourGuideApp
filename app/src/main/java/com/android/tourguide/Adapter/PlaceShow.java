package com.android.tourguide.Adapter;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.tourguide.R;

public class PlaceShow extends AppCompatActivity {
    // keys use to send data between fragments
    public static  String NAME_PLACE_KEY = "name";
    public static  String ADDEESS_PLACE_KEY = "address";
    public static  String ABOUT_PLACE_KEY = "about";
    public static  String PHONE_PLACE_KEY = "phone";
    public static  String lOCATION_PLACE_KEY = "location";
    public static  String PHOTO_PLACE_KEY = "photo";
    public static  String TITLE_ACTIVITY_KEY = "title";

    private String getNamePlace ;

    public PlaceShow() { }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_show);

        //get Value title
        int title = getIntent().getIntExtra(TITLE_ACTIVITY_KEY,-1);
        //check value and set title
        switch (title) {
            case 1:
                setTitle(getString(R.string.menu_historical));
                break;
            case 2:
                setTitle(getString(R.string.menu_restaurants));
                break;
            case 3:
                setTitle(getString(R.string.menu_shopping));
                break;
            case 4:
                setTitle(R.string.menu_streets);
                break;
        }

        // fine elemet , receive and set data
        TextView namePlace = findViewById(R.id.palce_name);
        getNamePlace = getIntent().getStringExtra(NAME_PLACE_KEY);
        namePlace.setText(getNamePlace);

        String info = getIntent().getStringExtra(ABOUT_PLACE_KEY);
        TextView infoPlace = findViewById(R.id.info_place);
        infoPlace.setText(info);

        // Text copy feature mode
        infoPlace.setOnLongClickListener(new View.OnLongClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public boolean onLongClick(View v) {
                //Define Vibrator to call
                Vibrator vibrator = (Vibrator) getSystemService(getApplicationContext().VIBRATOR_SERVICE);

                // SDK Check for Android Phones
                if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB) {

                    // Definition of Clipboard Manager old version of SDK
                    android.text.ClipboardManager clipboard = (android.text.ClipboardManager)
                            getApplicationContext().getSystemService(getApplicationContext().CLIPBOARD_SERVICE);
                    clipboard.setText(info);
                    // Definition of vibratorr old version of SDK
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));

                } else {
                    // Definition of Clipboard Manager new version of SDK
                    android.content.ClipboardManager clipboard = (android.content.ClipboardManager)
                            getApplicationContext().getSystemService(getApplicationContext().CLIPBOARD_SERVICE);

                    android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", info);
                    clipboard.setPrimaryClip(clip);

                    // Definition of vibratorr new version of SDK
                    vibrator.vibrate(100);
                }
                // make Toast To alert the user that the task has been completed
                Toast.makeText(getApplicationContext(), "Copied.", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        String phone = getIntent().getStringExtra(PHONE_PLACE_KEY);
        LinearLayout call_phone = findViewById(R.id.call_phone);

        if(!(phone.equals("0"))){
            TextView phonePlace = findViewById(R.id.phone_place);
            phonePlace.setText(phone);

            call_phone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //created intent to call number
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    // open app to call number
                    intent.setData(Uri.parse("tel:" + getIntent().getStringExtra(PHONE_PLACE_KEY)));
                    startActivity(intent);
                }
            });
        } else {
            //delete element is no find
            call_phone.setVisibility(View.GONE); }

        TextView locationPlace = findViewById(R.id.location_place);
        locationPlace.setText(getIntent().getStringExtra(ADDEESS_PLACE_KEY));

        ImageView placeImage = findViewById(R.id.place_image_large);
        placeImage.setImageResource(getIntent().getIntExtra(PHOTO_PLACE_KEY,-1));

        String location = getIntent().getStringExtra(lOCATION_PLACE_KEY);
        locationPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                // opne google map to show place
                intent.setData(Uri.parse(getMapsURI(location)));
                startActivity(intent);
            }
        });
    }
    // method to prepare URI
    private String getMapsURI(String locationId) {
        String[] latitudeAndLongitude = locationId.split(",");
        String latitude = latitudeAndLongitude[0];
        String longitude = latitudeAndLongitude[1];
        return "geo:" + latitude + "," + longitude
                + "?q=<" + latitude + ">,<" + longitude + ">,("
                + getIntent().getStringExtra(NAME_PLACE_KEY) + ")";
    }

}