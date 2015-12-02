package com.ross.feehan.okhttpexample.Objects;

import java.util.List;

/**
 * Created by Ross Feehan on 30/11/2015.
 * Copyright Ross Feehan
 */
public class TubeLine {

    private String tubeName;
    private String tubeStatus;

    //CONSTRUCTOR
    public TubeLine(String tubeName, String status){
        setTubeName(tubeName);
        setTubeStatus(status);
    }

    //SETTERS
    public void setTubeName(String tubeName) {
        this.tubeName = tubeName;
    }

    public void setTubeStatus(String tubeStatus) {
        this.tubeStatus = tubeStatus;
    }

    //GETTERS
    public String getTubeName() {
        return tubeName;
    }

    public String getTubeStatus() {
        return tubeStatus;
    }
}
