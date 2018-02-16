package roshaan.mytodoapp.list;

import java.util.ArrayList;

/**
 * Created by Roshaan on 2/15/2018.
 */

public interface ListContractor {

    interface ListViewInterface {

        void sendAddTaskEvent();
        String getNewTask();
        void setTask(Task task);

    }

    interface ListModelInterface {
        ArrayList<Task> getTasks();
        void addTask(Task task);
        void deleteTask(Task task);
        void initializeTasks();
    }

    interface ListPresenterInterface {

        void addTask();
        void notifyDataSetChanged();
        void setAdapter();
        void populateData(ArrayList<Task> data);

    }
}
