package com.quickblox.q_municate.ui.activities.main;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


import com.quickblox.q_municate.R;
import com.quickblox.q_municate.ui.activities.base.BaseLoggableActivity;
import com.quickblox.q_municate.ui.activities.call.CallActivity;

public class MTIhome extends BaseLoggableActivity {


    private static final String TAG =MTIhome.class.getSimpleName();

    public static void start(Context context) {
        Intent intent = new Intent(context, MTIhome.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }

    @Override
    protected int getContentResId() {
        return R.layout.activity_mtihome;
    }
    private LinearLayout university, phone, scrap, news, chat, events;

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            Intent i = new Intent(MTIhome.this, MTIhome.class);
            startActivity(i);
        } else {
            Intent i = new Intent(MTIhome.this, MTIhome.class);
            startActivity(i);
        }
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart()");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mtihome);
        university = findViewById(R.id.university);
        phone = findViewById(R.id.call);
        scrap = findViewById(R.id.scrap);
        news = findViewById(R.id.news);
        chat = findViewById(R.id.chat);
        events = findViewById(R.id.events);

        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MTIhome.this, NewsActivity.class));
            }
        });


        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MTIhome.this, Events.class));
            }
        });


        scrap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MTIhome.this, Scrap.class));
            }
        });


        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MTIhome.this, CallActivity.class));
            }
        });



        university.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MTIhome.this, University.class));
            }
        });



        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MTIhome.this, MainActivity.class));
            }
        });




    }

}

