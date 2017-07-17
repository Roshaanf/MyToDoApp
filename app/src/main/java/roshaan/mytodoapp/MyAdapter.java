package roshaan.mytodoapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Roshaann 2.7 gpa on 09/07/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>
{
    LayoutInflater lf;
    Context context;
    ArrayList<String> data;

    public MyAdapter(Context context,ArrayList<String> data){


        this.context=context;
        this.data=data;
        lf=LayoutInflater.from(context);
    }
    //inflation will take place here
    //this method will be called if new viewHolder rewuired otherwise recycling will do the job
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        System.out.println("hi");

        View v=lf.inflate(R.layout.single_row,parent,false);
        //sending inflatd view to ViewHolder so that it can find resource ids
        //extra parameter of data myny apni asani ke liye dala he takay click p data le skun
        MyViewHolder holder=new MyViewHolder(v,data);

        //returning holder , holder now contains the ids of the layout
        //values will be assigned to these ids in onBindViewHolder
        return holder;
    }

    //Responsible to fill UI
    //The holder parameter here is from onCreateHolder's return statement so it contains ids
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        //also capitalizi
    holder.name.setText(data.get(position).toString().substring(0,1).toUpperCase()+ data.get(position).toString().substring(1));

    }

    @Override
    public int getItemCount() {
        System.out.println(data.size());
        return data.size();
    }
}


