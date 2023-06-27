package com.example.btl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.btl.model.Order;

public class CoursePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_page);
        ConstraintLayout courseBg = findViewById(R.id.coursePageBg);
        ImageView courseImage = findViewById(R.id.coursePageImage);
        TextView courseTitle = findViewById(R.id.coursePageTitle);
        TextView courseDate = findViewById(R.id.coursePageDate);
        TextView courseLevel = findViewById(R.id.coursePageLevel);
        TextView courseText = findViewById(R.id.coursePageText);

        courseBg.setBackgroundColor(getIntent().getIntExtra("courseBg",0));
        courseImage.setImageResource(getIntent().getIntExtra("courseImage",0));
        courseTitle.setText(getIntent().getStringExtra("courseTitle"));
        courseDate.setText(getIntent().getStringExtra("courseDate"));
        courseLevel.setText(getIntent().getStringExtra("courseLevel"));
        courseText.setText(getIntent().getStringExtra("courseText"));
    }
    public void fromCoursePagetoCall(View view){
        Intent intent = new Intent(this, CallPage.class);
        startActivity(intent);
    }
    public void fromCoursePagetoFavourite(View view){
        Intent intent = new Intent(this, favourite.class);
        startActivity(intent);
    }
    public void fromCoursePagetoMain(View view){
        Intent intent = new Intent(this, Home.class);
        Home.courseList.clear();
        Home.fullcoursesList.clear();
        startActivity(intent);
    }

    public void addToCart(View view){
        int item_id =getIntent().getIntExtra("courseId",0);
        if(Order.items_id.contains(item_id))
            Toast.makeText(this, "Đã có trong favorite", Toast.LENGTH_LONG).show();
        else {
            Order.items_id.add(item_id);
            Toast.makeText(this, "Đã thêm vào favorite", Toast.LENGTH_LONG).show();
        }
    }
}
