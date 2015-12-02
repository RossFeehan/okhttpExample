package com.ross.feehan.okhttpexample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.ross.feehan.okhttpexample.Objects.TubeLine;
import com.ross.feehan.okhttpexample.OkhttpClasses.GetTubeServices;
import com.ross.feehan.okhttpexample.OkhttpClasses.GetTubeServicesInterface;

import org.json.JSONArray;

import java.util.List;

public class MainActivity extends Activity implements GetTubeServicesInterface {

    private Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.ctx = this;
        GetTubeServices getTubeServices = new GetTubeServices(ctx, this);
        getTubeServices.getTubeServices();
    }

    //INTERFACE METHODS
    //GetTubeServicesInterface METHODS
    @Override
    public void noInternetConnection() {
        Toast.makeText(ctx, "Sorry, no internet connection at the moment", Toast.LENGTH_LONG).show();
    }

    @Override
    public void receiveTubeServices(JSONArray responseJson) {
        //Parse the tubeline jsonarray into a List of TubeLine
        List<TubeLine> tubeLineStates = ParseJsonArray.parseTubeStatesArray(responseJson);

        //Display the list of tube lines here
    }

    @Override
    public void somethingWentWrong() {
        Toast.makeText(ctx, "Sorry, something went wrong", Toast.LENGTH_LONG).show();
    }
}
