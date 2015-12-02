package com.ross.feehan.okhttpexample.OkhttpClasses;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ross.feehan.okhttpexample.Objects.TubeLine;
import com.ross.feehan.okhttpexample.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Ross Feehan on 02/12/2015.
 * Copyright Ross Feehan
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.TubeStatusViewHolder>{

    private List<TubeLine> tubeStatus;

    //CONSTRUCTOR
    public RecyclerViewAdapter(List<TubeLine> tubeStatus){
        this.tubeStatus = tubeStatus;
    }

    @Override
    public TubeStatusViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tube_status_layout, parent, false);
        TubeStatusViewHolder tubeViewHolder = new TubeStatusViewHolder(view);
        return tubeViewHolder;
    }

    @Override
    public void onBindViewHolder(TubeStatusViewHolder holder, int position) {
        holder.tubeLineNameTV.setText(tubeStatus.get(position).getTubeName());
        holder.tubeLineStatusTV.setText(tubeStatus.get(position).getTubeStatus());
    }

    @Override
    public int getItemCount() {
        return tubeStatus.size();
    }

    /*Private class that holds the layout for the tube status
        *Uses the view holder pattern
        */
    public static class TubeStatusViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.tubeName) protected TextView tubeLineNameTV;
        @Bind(R.id.tubeStatus) protected TextView tubeLineStatusTV;

        public TubeStatusViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
