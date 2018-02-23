package roshaan.mytodoapp.mvp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import roshaan.mytodoapp.R;
import roshaan.mytodoapp.mvp.view.ViewHolder;

/**
 * Created by Roshaan on 2/15/2018.
 */

public class ListPresenter implements ListContractor.ListPresenterInterface {

    ListContractor.ListViewInterface mView;
    static ListContractor.ListModelInterface mModel;


    public ListPresenter(ListContractor.ListViewInterface view) {
        this.mView = view;
        mModel = new ListModel(this);
    }


    @Override
    public void addTask() {


        // get new task will be called in view
        Task task = new Task();
        task.setTask(mView.getNewTask());

        mView.clearTaskField();

        //this method will be called in model
        mModel.addTask(task);


    }


    @Override
    public void populateData(ArrayList<Task> data) {
        mModel.initializeTasks(data);
    }


    @Override
    public void notifyUpdateList() {
        mView.notifyDataSetChange();
    }



    public static class Adapter extends RecyclerView.Adapter<ViewHolder> {
        List<Task> list;

        public Adapter(List<Task> list) {

            this.list = list;

        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row, parent, false);
//            View v = context.getLayoutInflater().inflate(R.layout.single_row, parent, false);

            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {

            holder.tv.setText(list.get(position).getTask());
            holder.iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    mModel.deleteTask(list.get(position));
                }
            });
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

    }

}
