package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileDetailActvity extends AppCompatActivity {

    TextView d_name,d_gender,d_bd,d_lang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_detail_actvity);
        d_name=findViewById(R.id.Name_detail_user);
        d_gender=findViewById(R.id.gender_detail_user);
        d_bd=findViewById(R.id.bd_detail_user);
        d_lang=findViewById(R.id.lang_detail_user);

        Intent intent= getIntent();
        String name = intent.getStringExtra("P_NAMES");
        String gender = intent.getStringExtra("P_GENDER");
        String bd = intent.getStringExtra("P_BD");
        String lang = intent.getStringExtra("P_LANG");
        d_name.setText(name);
        d_gender.setText(gender);
        d_bd.setText(bd);
        d_lang.setText(lang);

    }
}
