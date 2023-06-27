package com.example.btl;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CallPage extends AppCompatActivity {
    Button button1;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        button1=(Button)findViewById(R.id.button1);
        button1.setOnClickListener(arg0 -> {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:"+ "0969764614"));
            startActivity(callIntent);
        });
    }

    public void fromMaintoCall(View view){
        Intent intent = new Intent(this, CallPage.class);
        startActivity(intent);
    }
    public void fromtoHome(View view){
        Intent intent = new Intent(this, Home.class);
        Home.courseList.clear();
        Home.fullcoursesList.clear();
        startActivity(intent);
    }
    public void fromMaintoFavorrite(View view){
        Intent intent = new Intent(this, favourite.class);
        startActivity(intent);
    }
}
