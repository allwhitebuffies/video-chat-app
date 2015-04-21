package com.example.pants.testinggithub;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Jeremy Villa on 4/21/2015.
 */
public class ChatActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        setConferenceIdText();
    }

    private void setConferenceIdText() {
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            String conferenceId = extras.getString("conference_id");

            // set the TextView's text
            TextView tv = (TextView)findViewById(R.id.conferenceIdTextView);
            tv.setText(conferenceId);
        }
    }
}
