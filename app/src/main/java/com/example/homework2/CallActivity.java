package com.example.homework2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.santalu.maskedittext.MaskEditText;

import es.dmoral.toasty.Toasty;

public class CallActivity extends AppCompatActivity {

    MaskEditText editText;
    Button button;
    private static final int REQUEST_CALL= 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        editText= findViewById(R.id.call_phonenumber);
        button =findViewById(R.id.call_btnCall);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });

    }
    private void makePhoneCall() {
        String phonenumber= editText.getRawText();
        if(!phonenumber.isEmpty()){
            if(ContextCompat.checkSelfPermission(CallActivity.this,
                    Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(CallActivity.this,
                        new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
            }else{
                String dial = "tel:"+phonenumber;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }else{
            Toasty.warning(CallActivity.this,"Please Input PhoneNumber Correctly",Toasty.LENGTH_LONG).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CALL){
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                makePhoneCall();
            }else{
                Toasty.warning(CallActivity.this,"Please Allow Permission",Toasty.LENGTH_LONG).show();
            }
        }
    }
}
