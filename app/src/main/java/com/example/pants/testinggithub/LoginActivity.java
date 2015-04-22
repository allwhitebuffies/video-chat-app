package com.example.pants.testinggithub;

import android.app.Activity;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.pants.testinggithub.Model.User;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.ProfileTracker;
import org.json.JSONObject;

import java.util.Arrays;

public class LoginActivity extends Activity {
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        setContentView(R.layout.activity_login);
        final LoginButton loginButton = (LoginButton) this.findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList("public_profile","email"));
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                GraphRequest request = GraphRequest.newMeRequest(
                        loginResult.getAccessToken(),
                        new GraphRequest.GraphJSONObjectCallback() {
                            @Override
                            public void onCompleted(
                                    JSONObject object,
                                    GraphResponse response) {
                                // Application code
                                Log.v("LoginActivity", response.toString());
                            }
                        });
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,name,firstName,lastName,gender,email,locale,timezone");
                request.setParameters(parameters);
                request.executeAsync();
                setContentView(R.layout.activity_main);
/**
                Profile profile = Profile.getCurrentProfile();
                profile.fetchProfileForCurrentAccessToken();

                String facebookID = profile.getId();
                String name = profile.getName();
                String firstName = profile.getFirstName();
                String lastName = profile.getLastName();
                String gender = null;
                String email = null;
                String locale = null;
                String timezone = null;

                final User toAddUser = new User(facebookID, name, firstName, lastName, gender, email, locale, timezone);

                JsonObjectRequest createUserRequest = toAddUser.createRequest(new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //TODO: do something if sucess

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                    }
                });*/

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
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
                Intent intent = new Intent(LoginActivity.this, AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.action_profile:
                Intent intent2 = new Intent(LoginActivity.this, ProfileActivity.class);
                startActivity(intent2);
                break;
            case R.id.action_settings:
                Intent intent3 = new Intent(LoginActivity.this, SettingsActivity.class);
                startActivity(intent3);
                break;
            case R.id.action_main:
                Intent intent4 = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent4);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
