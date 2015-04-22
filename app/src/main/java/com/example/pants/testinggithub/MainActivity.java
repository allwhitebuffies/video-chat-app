package com.example.pants.testinggithub;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MainActivity extends ActionBarActivity {

    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_main);

        /**This is used to find your devices hash key. It must be added to the android key hash list
         * on developers.facebook.com. In order to get this to work, you must create a textview in the
         * MainActivity layout and name it "textstring". Also move the intent filter from the LoginActivity
         * to the MainActivity in the AndroidManifest file.
        try {
            PackageInfo info =     getPackageManager().getPackageInfo("com.example.pants.testinggithub",     PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String sign= Base64.encodeToString(md.digest(), Base64.DEFAULT);
                Log.e("MY KEY HASH:", sign);
                TextView textView = (TextView)findViewById(R.id.textstring);
                textView.setText(sign);
                Toast.makeText(getApplicationContext(), sign, Toast.LENGTH_LONG).show();
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.d("nope","nope");
        } catch (NoSuchAlgorithmException e) {
        }*/
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
            case R.id.action_settings:
                Intent intent3 = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent3);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void clickShuffle(View view){
        //findViewById(R.id.shuffleButton).setVisibility(View.INVISIBLE);
        //findViewById(R.id.progressBar).setVisibility(View.VISIBLE);
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost request = new HttpPost(BASE_URL);

        try {
            StringEntity params = new StringEntity("details={\"con_id\":\"1\"} ");
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);

            // handle response here...
        }catch (Exception ex) {
            // handle exception here
        } finally {
            httpClient.getConnectionManager().shutdown();
        }

        Intent intent = new Intent(MainActivity.this, ChatLoadingActivity.class);
        startActivity(intent);
    }
}
