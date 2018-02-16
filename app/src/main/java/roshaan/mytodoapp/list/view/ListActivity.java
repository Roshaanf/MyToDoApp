package roshaan.mytodoapp.list.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import java.util.ArrayList;

import roshaan.mytodoapp.R;
import roshaan.mytodoapp.databinding.ActivityListBinding;
import roshaan.mytodoapp.list.Adapter;
import roshaan.mytodoapp.list.ListContractor;
import roshaan.mytodoapp.list.ListPresenter;
import roshaan.mytodoapp.list.Task;

public class ListActivity extends AppCompatActivity implements ListContractor.ListViewInterface {

    ActivityListBinding binding;
    ListPresenter presenter;
    ArrayList<Task> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_list);
        //it will type cast this activity context into ListViewInterface context
        presenter = new ListPresenter(this);


        //setting adapter
        setAdapter();

    }

    public void setAdapter() {
        Adapter adapter = new Adapter(data);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);

        presenter.populateData(data);
    }

    public void addData(View v) {
        sendAddTaskEvent();
    }

    @Override
    public void sendAddTaskEvent() {
        //this method will be called in presenter
        presenter.addTask();
    }

    @Override
    public String getNewTask() {
        return String.valueOf(binding.newText.getText());
    }

    //will be called by presenter
    @Override
    public void setTask(Task task) {
        //binding.textView.setText(task.getTask());
    }
}
