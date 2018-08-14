package com.blog.sajal.herome.activities;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.blog.sajal.herome.R;
import com.blog.sajal.herome.fragment.BlankFragment;

public class MainActivity extends AppCompatActivity implements BlankFragment.MainFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();

        Fragment fragment = manager.findFragmentById(R.id.fragment_container);

        if (fragment == null)
        {
                fragment= new BlankFragment();
            manager.beginTransaction().add(R.id.fragment_container,fragment).commit();
        }
    }

    @Override
    public void onMainFragmentInteraction(Uri uri) {

    }
}
