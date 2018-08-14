package com.blog.sajal.fitandflab;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DetailsActivity extends Activity {
    ImageView img;
    TextView title;
    RelativeLayout BGLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        img=(ImageView)findViewById(R.id.imgVIew);
        title=(TextView)findViewById(R.id.txtTitle);
        BGLayout=(RelativeLayout)findViewById(R.id.BDRelativeLayout);

        String Detailstitle=getIntent().getStringExtra(MainActivity.Extream_Title);
        title.setText(Detailstitle);

        if(Detailstitle.equalsIgnoreCase(MainActivity.weightTitle))
        {
            img.setImageDrawable(getResources().getDrawable(R.drawable.weight,getApplicationContext().getTheme()));
            BGLayout.setBackgroundResource(R.drawable.bd_weight);
        }else if(Detailstitle.equalsIgnoreCase(MainActivity.yogaTitle)){
            img.setImageDrawable(getResources().getDrawable(R.drawable.lotus,getApplicationContext().getTheme()));
            BGLayout.setBackgroundResource(R.drawable.bg_yugo);
        }else if(Detailstitle.equalsIgnoreCase(MainActivity.heartTitle)){
            img.setImageDrawable(getResources().getDrawable(R.drawable.heart,getApplicationContext().getTheme()));
            BGLayout.setBackgroundResource(R.drawable.bg_heart);

        }
    }
}
