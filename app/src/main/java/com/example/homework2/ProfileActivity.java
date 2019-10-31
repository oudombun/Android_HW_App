package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ProfileActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, AdapterView.OnItemSelectedListener {
    private static final String TAG = "ProfileActivity";
    Button btnSave,btnDateSelect;
    TextView textBd;
    Spinner spinnerBd;
    String p_gender,p_name,p_bd,p_lang;
    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        btnDateSelect = findViewById(R.id.profile_selectdate);
        radioGroup = findViewById(R.id.profile_gender_group);
        final EditText n = findViewById(R.id.infoName);
        textBd = findViewById(R.id.profile_textDate);
        spinnerBd = findViewById(R.id.profile_lang);
        p_lang =spinnerBd.getItemAtPosition(0).toString();
        btnDateSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerFragment datePickerFragment= new DatePickerFragment();
                datePickerFragment.show(getSupportFragmentManager(),"date picker");
            }
        });

        btnSave = findViewById(R.id.profile_btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ProfileDetailActvity.class);
                intent.putExtra("P_NAMES",n.getText().toString());
                intent.putExtra("P_GENDER",p_gender);
                intent.putExtra("P_BD",p_bd);
                intent.putExtra("P_LANG",p_lang);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);

        String pattern = "dd-MM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.US);

        String today = simpleDateFormat.format(c.getTime());
        TextView textView = findViewById(R.id.profile_textDate);
        textView.setText(today);
        p_bd=today;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        p_lang =text;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void checkButton(View v){
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton= findViewById(radioId);
        p_gender = radioButton.getText().toString();
    }
}
