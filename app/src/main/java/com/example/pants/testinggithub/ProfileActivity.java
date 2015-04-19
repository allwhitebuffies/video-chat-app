package com.example.pants.testinggithub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class ProfileActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_about:
                Intent intent2 = new Intent(ProfileActivity.this, AboutActivity.class);
                startActivity(intent2);
                break;
            case R.id.action_settings:
                Intent intent3 = new Intent(ProfileActivity.this, SettingsActivity.class);
                startActivity(intent3);
                break;
            case R.id.action_main:
                Intent intent4 = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(intent4);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
