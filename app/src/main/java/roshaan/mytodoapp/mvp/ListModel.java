package roshaan.mytodoapp.mvp;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by Roshaan on 2/15/2018.
 */

public class ListModel implements ListContractor.ListModelInterface {

    ArrayList<Task> tasks;
    DatabaseReference mRef;
    ListContractor.ListPresenterInterface presenterInterface;

    ListModel(ListContractor.ListPresenterInterface presenterInterface) {
        this.presenterInterface = presenterInterface;
    }


    DatabaseReference getTasksReference() {
        if (mRef == null) {
            mRef = FirebaseDatabase.getInstance().getReference("Tasks");
        }
        return mRef;
    }

    public void initializeTasks(final ArrayList<Task> data) {

        this.tasks = data;

        getTasksReference().addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

//                String string=dataSnapshot.getValue(String.class);
                Task task = dataSnapshot.getValue(Task.class);
                tasks.add(task);
                notifyPresenter();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

                Task task=dataSnapshot.getValue(Task.class);

                for(int i=0;i<data.size();i++){
                    if (task.id.equals(data.get(i).getId())){
                        data.remove(i);
                        break;
                    }
                }
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

    public void notifyPresenter() {
        presenterInterface.notifyUpdateList();
    }

    @Override
    public void addTask(Task task) {

        String push=getTasksReference().push().getKey();

        task.setId(push);
        getTasksReference().child(push).setValue(task);

    }

    @Override
    public void deleteTask(Task task) {
        getTasksReference().child(task.getId()).removeValue();

    }
}
