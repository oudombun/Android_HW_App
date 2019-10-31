package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import es.dmoral.toasty.Toasty;

public class NoteInputActivity extends AppCompatActivity {

    EditText title,desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_input);
        title = findViewById(R.id.editText1);
        desc = findViewById(R.id.editText2);

        Button button = findViewById(R.id.noteInput_add);
        Button button2 = findViewById(R.id.noteInput_cancel);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t =title.getText().toString().trim();
                String d =desc.getText().toString().trim();
                if(!t.isEmpty()&&!d.isEmpty()){
                    Intent intent=new Intent();
                    intent.putExtra("note_title",t);
                    intent.putExtra("note_desc",d);
                    setResult(2,intent);
                    finish();//finishing activity
                }else{
                    Toasty.info(getApplicationContext(),"Please verify all input",Toasty.LENGTH_LONG).show();
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(NoteInputActivity.this,NoteActivity.class);
                startActivity(intent);
                finish();//finishing activity
            }
        });
    }
}
