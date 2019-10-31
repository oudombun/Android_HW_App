package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity{

    Intent intent;
    FrameLayout btn1,btn2,btn3,btn4,btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.main_btn_gal);
        btn2 = findViewById(R.id.main_btn_con);
        btn3 = findViewById(R.id.main_btn_note);
        btn4 = findViewById(R.id.main_btn_call);
        btn5 = findViewById(R.id.main_btn_pro);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoGallery();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoContact();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoNoteBook();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoCall();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoProfile();
            }
        });
    }
     void gotoGallery() {
        intent= new Intent(getApplicationContext(),GalleryActivity.class);
        startActivity(intent);
    }
    private void gotoContact() {
        intent= new Intent(getApplicationContext(),ContactActivity.class);
        startActivity(intent);
    }
    private void gotoNoteBook() {
        intent= new Intent(getApplicationContext(),NoteActivity.class);
        startActivity(intent);
    }
    private void gotoCall() {
        intent= new Intent(getApplicationContext(),CallActivity.class);
        startActivity(intent);
    }
    private void gotoProfile() {
        intent= new Intent(getApplicationContext(),ProfileActivity.class);
        startActivity(intent);
    }


}
