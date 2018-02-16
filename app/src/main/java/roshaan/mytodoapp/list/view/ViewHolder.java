package roshaan.mytodoapp.list.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import roshaan.mytodoapp.R;

/**
 * Created by Roshaan on 2/16/2018.
 */
public class ViewHolder extends RecyclerView.ViewHolder{

    TextView tv;
    ImageView iv;

    public ViewHolder(View itemView) {
        super(itemView);
        tv= (TextView) itemView.findViewById(R.id.textView);
        iv=(ImageView) itemView.findViewById(R.id.dustbin);
    }
}
