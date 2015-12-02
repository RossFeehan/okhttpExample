package com.ross.feehan.okhttpexample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ross.feehan.okhttpexample.Objects.TubeLine;
import com.ross.feehan.okhttpexample.OkhttpClasses.GetTubeServices;
import com.ross.feehan.okhttpexample.OkhttpClasses.GetTubeServicesInterface;
import com.ross.feehan.okhttpexample.OkhttpClasses.RecyclerViewAdapter;

import org.json.JSONArray;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity implements GetTubeServicesInterface {

    private Context ctx;
    @Bind(R.id.tubeRV) RecyclerView tubeLinesRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        this.ctx = this;
        GetTubeServices getTubeServices = new GetTubeServices(ctx, this);
        getTubeServices.getTubeServices();
    }

    //INTERFACE METHODS
    //GetTubeServicesInterface METHODs
    @Override
    public void receiveTubeServices(JSONArray responseJson) {
        //Parse the tubeline jsonarray into a List of TubeLine
        List<TubeLine> tubeLineStates = ParseJsonArray.parseTubeStatesArray(responseJson);

        //Display the list of tube lines here
        //Creating the layout of the recycler view (linearlayout creates a list view)
        LinearLayoutManager recyclerViewLayoutManager = new LinearLayoutManager(this);
        tubeLinesRV.setLayoutManager(recyclerViewLayoutManager);

        //Creating the adapter for the recycler view, loaded with the tube lines
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(tubeLineStates);
        tubeLinesRV.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void somethingWentWrong() {
        Toast.makeText(ctx, "Sorry, something went wrong, please check your internet connection", Toast.LENGTH_LONG).show();
    }
}
