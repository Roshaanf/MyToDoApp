package roshaan.mytodoapp.mvp;

/**
 * Created by Roshaan on 2/15/2018.
 */

public class Task  {
    String id;
    String task;

    public Task(){}
    public Task(String task, String id) {
        this.task = task;
        this.id=id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public  String getId() {
        return id;
    }

    public void setId( String id) {
        this.id = id;
    }
}
