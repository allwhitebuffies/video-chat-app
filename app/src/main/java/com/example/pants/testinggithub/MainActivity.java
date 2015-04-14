package com.example.pants.testinggithub;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.facebook.FacebookSdk;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FacebookSdk.sdkInitialize(getApplicationContext());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_about:
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.action_profile:
                Intent intent2 = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent2);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void clickShuffle(View view){
        findViewById(R.id.shuffleButton).setVisibility(View.INVISIBLE);
        findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
    }
}
