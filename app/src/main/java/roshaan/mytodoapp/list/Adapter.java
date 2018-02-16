package roshaan.mytodoapp.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import roshaan.mytodoapp.R;
import roshaan.mytodoapp.list.view.ViewHolder;

/**
 * Created by Roshaan on 2/16/2018.
 */

public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    List<Task> list;

    public Adapter() {

    }

    public Adapter(List<Task> list) {

        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row, parent);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}


