package com.ross.feehan.okhttpexample.OkhttpClasses;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.okhttp.Request;

import org.json.JSONArray;

/**
 * Created by Ross Feehan on 30/11/2015.
 * Copyright Ross Feehan
 */
public class GetTubeServices {

    private Context ctx;
    private GetTubeServicesAsync getTubeServices;
    private GetTubeServicesInterface listenerClass;

    public GetTubeServices(Context ctx, GetTubeServicesInterface listenerClass){
        this.ctx = ctx;
        this.listenerClass = listenerClass;
    }

    public void getTubeServices(){
        //TODO if there is internet connection
        getTubeServices = new GetTubeServicesAsync();
        getTubeServices.execute();

        listenerClass.noInternetConnection();
    }

    private class GetTubeServicesAsync extends AsyncTask<Void, Void, Void> {

        JSONArray responseJson;

        @Override
        protected Void doInBackground(Void... params) {

            //Create the Url for the OkHTTP call
            Request request = new Request.Builder()
                    .url("https://api.tfl.gov.uk/line/mode/tube/status")
                    .build();

            OkHttpCallingClass okHttpCallingClass = new OkHttpCallingClass();
            responseJson = okHttpCallingClass.callUrlUsingOkhttp(request);

            return null;
        }

        @Override
        protected void onPostExecute(Void args){
            if(responseJson.length() == 0){
                listenerClass.somethingWentWrong();
            }
            else{
                listenerClass.receiveTubeServices(responseJson);
            }
        }
    }
}
