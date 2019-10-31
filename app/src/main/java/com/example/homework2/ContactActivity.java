package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        initializeContactList();
    }

    private void initializeContactList() {
        LinearLayout ll = new LinearLayout(this);
        LinearLayout.LayoutParams dimension = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        dimension.setMargins(15,15,15,15);
        ll.setLayoutParams(dimension);
        ll.setOrientation(LinearLayout.VERTICAL);

        TextView text1 = new TextView(this);
        TextView text2 = new TextView(this);

    }

}
