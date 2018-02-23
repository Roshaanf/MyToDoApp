package roshaan.mytodoapp.mvp;

import java.util.ArrayList;

/**
 * Created by Roshaan on 2/15/2018.
 */

public interface ListContractor {

    interface ListViewInterface {

        void sendAddTaskEvent();
        String getNewTask();
        void notifyDataSetChange();
        void clearTaskField();

    }

    interface ListModelInterface {
        void addTask(Task task);
        void deleteTask(Task task);
        void initializeTasks(ArrayList<Task> data);
    }

    interface ListPresenterInterface {

        void addTask();
        void populateData(ArrayList<Task> data);
        void notifyUpdateList();

    }
}
