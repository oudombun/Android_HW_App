package com.example.homework2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class NoteActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    GridLayout myLayout;
    private static final String TAG = "NoteActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        imageView =findViewById(R.id.note_btnadd);
        myLayout = findViewById(R.id.note_gridLayout);
        imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(NoteActivity.this,NoteInputActivity.class);
        startActivityForResult(intent, 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 2){
            LinearLayout layout = new LinearLayout(NoteActivity.this);
            layout.setOrientation(LinearLayout.VERTICAL);
            layout.setPadding(dpToPx(10),dpToPx(10),dpToPx(10),dpToPx(10));
            layout.setBackgroundColor(Color.WHITE);
            /*when set attribute that belong to other layout*/
            GridLayout.LayoutParams param =new GridLayout.LayoutParams();

            param.height = dpToPx(150);
            param.width = dpToPx(0);
            param.columnSpec = GridLayout.spec(GridLayout.UNDEFINED,1f);
            /*finally set layout param to layout/view */
            layout.setLayoutParams(param);

            /*get data from user*/
            TextView dataTitle = new TextView(NoteActivity.this);
            TextView dataDesc = new TextView(NoteActivity.this);
            LinearLayout.LayoutParams textParam= new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            dataTitle.setText(data.getStringExtra("note_title"));
            dataTitle.setTextSize(27);
            dataTitle.setTextColor(Color.BLACK);
            dataTitle.setMaxLines(1);
            dataTitle.setTypeface(Typeface.DEFAULT_BOLD);
            dataTitle.setEllipsize(TextUtils.TruncateAt.END);

            dataDesc.setText(data.getStringExtra("note_desc"));
            dataDesc.setTextSize(20);
            dataDesc.setTextColor(Color.BLACK);
            dataDesc.setMaxLines(2);
            dataDesc.setEllipsize(TextUtils.TruncateAt.END);
            /*add to linear layout*/
            layout.addView(dataTitle);
            layout.addView(dataDesc);

            /*add to grid layout*/
            myLayout.addView(layout);
        }
    }
    public int dpToPx(int dp) {
        float density = getApplicationContext().getResources()
                .getDisplayMetrics()
                .density;
        return Math.round((float) dp * density);
    }
}
