package com.ross.feehan.okhttpexample.OkhttpClasses;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by Ross Feehan on 30/11/2015.
 * Copyright Ross Feehan
 */
public class OkHttpCallingClass {

    public OkHttpCallingClass(){

    }

    public JSONArray callUrlUsingOkhttp(Request request) {
        OkHttpClient client = new OkHttpClient();
        JSONArray jsonArray = new JSONArray();

        try {
            //calling the url
            Response response = client.newCall(request).execute();

            //getting the json from the response
            Reader readerBody = response.body().charStream();
            //get the json object
            StringBuilder stringBuilder = new StringBuilder();
            int data = readerBody.read();
            while (data != -1) {
                stringBuilder.append((char) data);
                data = readerBody.read();
            }

            jsonArray = new JSONArray(stringBuilder.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonArray;
    }
}
