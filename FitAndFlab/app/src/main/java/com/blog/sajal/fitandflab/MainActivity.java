package com.blog.sajal.fitandflab;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    RelativeLayout weightLayout,yogaLayout,heartLayout;

    public static final String weightTitle="Weight Lifting";
    public static final String yogaTitle="Yoga";
    public static final String heartTitle="Heart";
public static String Extream_Title="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightLayout=(RelativeLayout)findViewById(R.id.weightLayout);
        yogaLayout=(RelativeLayout)findViewById(R.id.YougaLayout);
        heartLayout=(RelativeLayout)findViewById(R.id.heartLayout);

        weightLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                loadActivity(MainActivity.weightTitle);

            }
        });

        yogaLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                loadActivity(MainActivity.yogaTitle);
            }
        });

        heartLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                loadActivity(MainActivity.heartTitle);
            }
        });

    }
    public void loadActivity(String title){
        Intent intent=new Intent(MainActivity.this,DetailsActivity.class);
        intent.putExtra(MainActivity.Extream_Title,title);
        startActivity(intent);
    }
}
