package com.android.tourguide.Fragmet;


import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.android.tourguide.R;

public class CairoFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_cairo, container, false);
        // Define elements xml from CairoFragment
        TextView about1 = root.findViewById(R.id.about_cairo_1);
        TextView about2 = root.findViewById(R.id.about_cairo_2);
        // Text copy feature mode

        about1.setOnLongClickListener(new View.OnLongClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public boolean onLongClick(View v) {
                //Define Vibrator to call
                Vibrator vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                // SDK Check for Android Phones
                if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB) {
                    // Definition of Clipboard Manager old version of SDK
                    android.text.ClipboardManager clipboard = (android.text.ClipboardManager)
                            getContext().getSystemService(getContext().CLIPBOARD_SERVICE);
                    clipboard.setText(getString(R.string.about_cairo_one));
                    // Definition of vibratorr old version of SDK
                   vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    // Definition of Clipboard Manager new version of SDK
                    android.content.ClipboardManager clipboard = (android.content.ClipboardManager)
                            getContext().getSystemService(getContext().CLIPBOARD_SERVICE);
                    android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", getString(R.string.about_cairo_one));
                    clipboard.setPrimaryClip(clip);
                    // Definition of vibratorr new version of SDK
                    vibrator.vibrate(100);
                }
                // make Toast To alert the user that the task has been completed
                Toast.makeText(getContext(), "Copied.", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Text copy feature mode
        about2.setOnLongClickListener(new View.OnLongClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public boolean onLongClick(View v) {
                //Define Vibrator to call
                Vibrator vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                // SDK Check for Android Phones
                if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.HONEYCOMB) {
                    // Definition of Clipboard Manager old version of SDK
                    android.text.ClipboardManager clipboard = (android.text.ClipboardManager)
                            getContext().getSystemService(getContext().CLIPBOARD_SERVICE);
                    clipboard.setText(getString(R.string.about_cairo_one));
                    // Definition of vibratorr old version of SDK
                    vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    // Definition of Clipboard Manager new version of SDK
                    android.content.ClipboardManager clipboard = (android.content.ClipboardManager)
                            getContext().getSystemService(getContext().CLIPBOARD_SERVICE);
                    android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", getString(R.string.about_cairo_one));
                    clipboard.setPrimaryClip(clip);
                    // Definition of vibratorr new version of SDK
                    vibrator.vibrate(100);
                }
                // make Toast To alert the user that the task has been completed
                Toast.makeText(getContext(), "Copied.", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        return root;
    }
}
