package roshaan.mytodoapp.list;

import java.util.ArrayList;

/**
 * Created by Roshaan on 2/15/2018.
 */

public class ListPresenter implements ListContractor.ListPresenterInterface {

    ListContractor.ListViewInterface mView;
    ListContractor.ListModelInterface mModel;

    public ListPresenter(ListContractor.ListViewInterface view) {
        this.mView = view;
        mModel = new ListModel(this);
    }


    @Override
    public void addTask() {
        // get new task will be called in view
        Task task = new Task(mView.getNewTask());

        //this method will be called in model
         mModel.addTask(task);


    }

    @Override
    public void notifyDataSetChanged() {

    }

    @Override
    public void setAdapter() {

    }

    @Override
    public void populateData(ArrayList<Task> data) {

    }

}
