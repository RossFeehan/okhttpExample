package com.ross.feehan.okhttpexample;

import com.ross.feehan.okhttpexample.Objects.TubeLine;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ross Feehan on 02/12/2015.
 * Copyright Ross Feehan
 */
public class ParseJsonArray {

    public static List<TubeLine> parseTubeStatesArray(JSONArray tubeLineStatesJsonArray){

        List<TubeLine> tubeLineStates = new ArrayList<TubeLine>();

        //loop through the json array and get each JsonObject that represents a tube line
        try{
            for(int i = 0; i < tubeLineStatesJsonArray.length(); i++){
                JSONObject tubeLineObject= (JSONObject)tubeLineStatesJsonArray.get(i);
                JSONArray tubeLineStateArray = tubeLineObject.getJSONArray("lineStatuses");
                JSONObject tubeLineState  = (JSONObject) tubeLineStateArray.get(0);

                //Create the tubeline object and add it to the List to be returned to the calling class
                TubeLine tubeLine = new TubeLine(tubeLineObject.getString("name"), tubeLineState.getString("statusSeverityDescription"));
                tubeLineStates.add(tubeLine);
            }
        }catch(JSONException e){
            e.printStackTrace();
        }


        return tubeLineStates;
    }
}
