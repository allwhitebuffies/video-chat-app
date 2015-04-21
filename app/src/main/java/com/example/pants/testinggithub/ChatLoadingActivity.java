package com.example.pants.testinggithub;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Jeremy Villa on 4/20/2015.
 */
public class ChatLoadingActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_loading);

        findConference();
    }

    private void findConference() {
        GetConferenceId task = new GetConferenceId();
        task.execute();
    }

    private class GetConferenceId extends AsyncTask<Void, Void, String> {
        protected String doInBackground(Void... params) {
            String BASE_URL = "http://ec2-52-6-4-195.compute-1.amazonaws.com:3000/chats.json";
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;

            // will contain the raw JSON response as a string
            String jsonStr = null;

            try {
                URL url = new URL(BASE_URL);

                // create the request and open the connection
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                // read the input stream into a String
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    // nothing to do.
                    return null;
                }

                reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) {
                    // stream was empty. no point in parsing
                    return null;
                } // TODO: handle better

                jsonStr = buffer.toString();

            } catch (IOException e) {
                // TODO maybe do something if the URL is malformed?
            }

            // get the conferenceId from the jsonStr
            String conferenceId = null;
            try {
                JSONObject obj = new JSONObject(jsonStr);

                conferenceId = obj.getString("con_id");
            } catch (JSONException e) {
                // TODO handle maybe?
            }

            return conferenceId;
        }

        @Override
        protected void onPostExecute(String conferenceId) {
            // TODO pass the jsonStr to the next Activity
            Intent intent = new Intent(getApplicationContext(), ChatActivity.class);
            intent.putExtra("conference_id", conferenceId);
            startActivity(intent);
        }
    }
}
