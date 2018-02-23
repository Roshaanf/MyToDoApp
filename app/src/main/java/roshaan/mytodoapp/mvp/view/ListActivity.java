package roshaan.mytodoapp.mvp.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import java.util.ArrayList;

import roshaan.mytodoapp.R;
import roshaan.mytodoapp.databinding.ActivityListBinding;
import roshaan.mytodoapp.mvp.ListContractor;
import roshaan.mytodoapp.mvp.ListPresenter;
import roshaan.mytodoapp.mvp.Task;

public class ListActivity extends AppCompatActivity implements ListContractor.ListViewInterface {

    ActivityListBinding binding;
    ListPresenter presenter;
    ArrayList<Task> data;
    ListPresenter.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_list);
        //it will type cast this activity context into ListViewInterface context
        presenter = new ListPresenter(this);

        data=new ArrayList<>();


        //setting adapter
        setAdapter();

    }

    public void setAdapter() {

        adapter = new ListPresenter.Adapter(data);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
//
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



    @Override
    public void notifyDataSetChange() {
        System.out.println("notify "+data);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void clearTaskField() {
        binding.newText.setText(" ");
    }
}
