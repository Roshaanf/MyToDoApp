package roshaan.mytodoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter adapter;
    ArrayList<String> data=new ArrayList<String>();
    EditText addText;
    Button addButton;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        addText=(EditText) findViewById(R.id.newTask);
        addButton=(Button) findViewById(R.id.addButton);


        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        adapter=new MyAdapter(this,data);
        recyclerView.setAdapter(adapter);
        System.out.println(data);
        //setting layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        ref=FirebaseDatabase.getInstance().getReference("tasks");
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                String value=dataSnapshot.getKey();
                data.add(value);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                System.out.println("theek he");
                //data snapshot contains the last item that is removed
                //here value contains the key means wo key jo meny database me rkhi hogi is item ki jo remove hua
                String value=dataSnapshot.getValue(String.class);

                //ab m apny array sy direct wo wali key ka element remove krdunga
                data.remove(value);

                //that item have same name
               // data.remove(value);



                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    public void addData(View v){
        System.out.println("hello");
        //checking textview should not be null
        if(!addText.getText().toString().equals("")) {
            System.out.println("hello");
            ref = FirebaseDatabase.getInstance().getReference("tasks");
            ref.child(addText.getText().toString()).setValue(addText.getText().toString());
            addText.setText("");
        }

        //if edit text is empty
        else{

            Toast t= Toast.makeText(this,"Add your task first",Toast.LENGTH_LONG);
            t.show();
        }
    }
}
