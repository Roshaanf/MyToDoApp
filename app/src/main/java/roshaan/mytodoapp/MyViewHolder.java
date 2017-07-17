package roshaan.mytodoapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by Roshaann 2.7 gpa on 09/07/2017.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {

    DatabaseReference ref;
    TextView name;
    ImageButton delete;
    public  ArrayList<String> data;
    //This will be called inside onCreateViewHolder
    //parameter interView contains the inflated single row view
    //here we will find resource ids
    public MyViewHolder(View itemView,ArrayList<String> data) {
        super(itemView);
        name=(TextView) itemView.findViewById(R.id.textView);
        delete=(ImageButton) itemView.findViewById(R.id.dustbin);
        this.data=data;

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.out.println(MyViewHolder.this.data.get(getAdapterPosition()));

                                ref= FirebaseDatabase.getInstance().getReference("tasks");
               ref.child(MyViewHolder.this.data.get(getAdapterPosition())).removeValue();
            }
        });
    }


}
