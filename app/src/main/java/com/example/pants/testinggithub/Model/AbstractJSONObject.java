package com.example.pants.testinggithub.Model;

import org.json.JSONObject;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;


/**
 * Created by Josh on 4/19/2015.
 */
public abstract class AbstractJSONObject {
    protected JSONObject mData;
    protected JSONObject mPushData = new JSONObject();

    protected String mBaseUrl = "http://ec2-52-0-168-55.compute-1.amazonaws.com/";
    public String mObjUrl;

    protected static final String URL_ARG = "url";

    public AbstractJSONObject() {
    }

    public AbstractJSONObject(JSONObject jsonObject) {
        mData = jsonObject;
    }

    public String getUrl() {
        return mObjUrl;
    }

    /**
     * Call getRequest to get a request to get a JsonObject backing this object.
     * Use response to construct this object.
     * @param url
     * @param responseListener
     * @param errorListener
     * @return
     */
    public static JsonObjectRequest getRequest(String url, Response.Listener<JSONObject> responseListener, Response.ErrorListener errorListener) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, responseListener, errorListener);

        return request;
    }

    /**
     * Creates a request to edit this profile.
     * @param responseListener
     * @param errorListener
     * @return
     */
    public JsonObjectRequest editRequest(Response.Listener<JSONObject> responseListener, Response.ErrorListener errorListener) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.PUT, mObjUrl, mPushData, responseListener, errorListener);

        return  request;
    }

    /**
     * Creates a request to create a profile.
     * @param responseListener
     * @param errorListener
     * @return
     */
    public JsonObjectRequest createRequest(Response.Listener<JSONObject> responseListener, Response.ErrorListener errorListener) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, mBaseUrl, mPushData, responseListener, errorListener);

        return request;
    }

    public JsonObjectRequest deleteRequest(Response.Listener<JSONObject> responseListener, Response.ErrorListener errorListener, String url) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.DELETE, url, null, responseListener, errorListener);
        return request;
    }
}
