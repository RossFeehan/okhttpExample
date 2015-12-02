package com.ross.feehan.okhttpexample.OkhttpClasses;


import org.json.JSONArray;

/**
 * Created by Ross Feehan on 30/11/2015.
 * Copyright Ross Feehan
 */
public interface GetTubeServicesInterface {

    void receiveTubeServices(JSONArray responseJson);

    void somethingWentWrong();
}
