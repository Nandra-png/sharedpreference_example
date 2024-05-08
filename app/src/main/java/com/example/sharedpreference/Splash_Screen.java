package com.example.sharedpreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Splash_Screen extends AppCompatActivity {

    private static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);


                String username = settings.getString("renren", "");

                if ("renren".equals(username)) {

                    Intent intent = new Intent(Splash_Screen.this, homeui.class);
                    startActivity(intent);
                } else {
                    // Pengguna belum pernah login dengan username "renren", arahkan ke MainActivity
                    Intent intent = new Intent(Splash_Screen.this, MainActivity.class);
                    startActivity(intent);
                }
                finish(); // Selesai dengan activity Splash_Screen
            }
        }, 500);
    }
}




