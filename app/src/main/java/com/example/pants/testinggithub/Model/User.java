package com.example.pants.testinggithub.Model;

import org.json.JSONException;


/**
 * Created by Josh on 4/18/2015.
 */
public class User extends AbstractJSONObject {
    //Names in DB
    private static final String FACEBOOK_ID_ARG = "facebook_id";
    private static final String NAME_ARG = "name";
    private static final String FIRST_NAME_ARG = "first_name";
    private static final String LAST_NAME_ARG = "last_name";
    private static final String GENDER_ARG = "gender";
    private static final String EMAIL_ARG = "email";
    private static final String LOCALE_ARG = "locale";
    private static final String TIMEZONE_ARG = "timezone";

    public String getFacebookID() {
        try {
            return mData.getString(FACEBOOK_ID_ARG);
        } catch (JSONException e) {
        }
        return null;
    }

    public void setFacebookID(String facebookID) {
        try {
             mPushData.put(FACEBOOK_ID_ARG, facebookID);
        } catch (JSONException e) {
        }
    }

    public String getName(String name) {
        try {
            mData.put(NAME_ARG, name);
        } catch (JSONException e) {
        }
        return null;
    }

    public void setName(String name) {
        try {
            mPushData.put(NAME_ARG, name);
        } catch (JSONException e) {
        }
    }

    public String getFirstName(String name) {
        try {
            mData.put(FIRST_NAME_ARG, name);
        } catch (JSONException e) {
        }
        return null;
    }

    public void setFirstName(String name) {
        try {
            mPushData.put(FIRST_NAME_ARG, name);
        } catch (JSONException e) {
        }
    }

    public String getLastName() {
        try {
            return mData.getString(LAST_NAME_ARG);
        } catch (JSONException e) {
        }
        return null;
    }

    public void setLastName(String name) {
        try {
            mPushData.put(LAST_NAME_ARG, name);
        } catch (JSONException e) {
        }
    }

    public String getEmail() {
        try {
            mData.getString(EMAIL_ARG);
        } catch (JSONException e) {

        }
        return null;
    }

    public void setEmail(String email) {
        try {
            mPushData.put(EMAIL_ARG, email);
        } catch (JSONException e) {
        }
    }

    public String getGender() {
        try {
            return mData.getString(GENDER_ARG);
        } catch (JSONException e) {
        }
        return  null;
    }

    public void setGender(String gender) {
        try {
            mPushData.put(GENDER_ARG, gender);
        } catch (JSONException e) {
        }
    }

    public String getLocale() {
        try {
            return mData.getString(LOCALE_ARG);
        } catch (JSONException e) {
        }
        return null;
    }

    public void setLocale(String locale) {
        try {
            mPushData.put(LOCALE_ARG, locale);
        } catch (JSONException e) {
        }
    }

    public void setTimezone(String timezone) {
        try {
            mPushData.put(TIMEZONE_ARG, timezone);
        } catch (JSONException e) {
        }
    }

    public String getTimezone() {
        try {
            return mData.getString(TIMEZONE_ARG);
        } catch (JSONException e) {
        }
    }

    public User (String facebookID, String name, String firstName, String lastName, String gender, String email, String locale, String timezone) {
        super();
        mBaseUrl = "http://ec2-52-0-168-55.compute-1.amazonaws.com/users.json";
        setFacebookID(facebookID);
        setName(name);
        setFirstName(firstName);
        setLastName(lastName);
        setGender(gender);
        setEmail(email);
        setLocale(locale);
        setTimezone(timezone);
    }

}
