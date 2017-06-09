package com.example.ashugupta.dijkstrasalgo;

import android.content.Context;
import android.graphics.Path;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.LinkedList;

import static android.content.ContentValues.TAG;

/**
 * Created by ashugupta on 08/06/17.
 */

public class RouteAdapter extends RecyclerView.Adapter<RouteAdapter.RouteViewHolder>{
    ArrayList<Route> routes;
    Context context;
    public RouteAdapter(ArrayList<Route> routes, Context context){
        this.routes = routes;
        this.context = context;
    }

    @Override
    public RouteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_turn_view,parent,false);
        return new RouteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RouteViewHolder holder, int position){
        Picasso.with(context).load(routes.get(position).getImage()).into(holder.image);
        Picasso.with(context).load(routes.get(position).getTurn_image()).into(holder.turn);
        holder.direction.setText(routes.get(position).getInstruction());
    }

    @Override
    public int getItemCount() {
        return routes.size();
    }




    public class RouteViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        ImageView turn;
        TextView direction;
        public RouteViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            turn = (ImageView) itemView.findViewById(R.id.turn);
            direction = (TextView) itemView.findViewById(R.id.instruction);
        }
    }


}
