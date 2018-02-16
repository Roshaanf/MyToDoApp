package roshaan.mytodoapp.list;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import roshaan.mytodoapp.MyAdapter;

/**
 * Created by Roshaan on 2/15/2018.
 */

public class ListModel implements ListContractor.ListModelInterface {

    ArrayList<Task> tasks;
    DatabaseReference mRef;
    ListContractor.ListPresenterInterface presenterInterface;

    ListModel(ListContractor.ListPresenterInterface presenterInterface){
        tasks=new ArrayList<>();
        this.presenterInterface=presenterInterface;
    }

    @Override
    public ArrayList<Task> getTasks() {

        tasks.add(new Task("Task 1"));
        tasks.add(new Task("Task 2"));
        tasks.add(new Task("Task 3"));
        tasks.add(new Task("Task 4"));
        tasks.add(new Task("Task 5"));
        tasks.add(new Task("Task 6"));
        tasks.add(new Task("Task 7"));
        return tasks;
    }

    DatabaseReference getTasksReference(){
        if(mRef==null){
            mRef=FirebaseDatabase.getInstance().getReference("tasks");
        }
        return mRef;
    }

    public void initializeTasks(){

        getTasksReference().addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                Task task=dataSnapshot.getValue(Task.class);
                tasks.add(task);
                notifyPresenter();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

                tasks.remove(dataSnapshot.getValue(Task.class));
                notifyPresenter();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void notifyPresenter(){

    }

    @Override
    public void addTask(Task task) {
            getTasksReference().child(String.valueOf(task)).setValue(task);
            notifyPresenter();
    }

    @Override
    public void deleteTask(Task task) {
        getTasksReference().child(String.valueOf(task)).removeValue();
        notifyPresenter();
    }
}
