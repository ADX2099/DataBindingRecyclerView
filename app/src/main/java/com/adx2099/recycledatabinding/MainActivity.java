package com.adx2099.recycledatabinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.adx2099.recycledatabinding.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private RecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mBinding.recyclerView.setHasFixedSize(true);

        adapter = new RecyclerAdapter(this,prepareUser());
        mBinding.recyclerView.setAdapter(adapter);
    }

    private List<User> prepareUser(){
        List<String> names = Arrays.asList(getResources().getStringArray(R.array.names));
        List<String> emails = Arrays.asList(getResources().getStringArray(R.array.emails));
        int[] imageId = {
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3,
                R.drawable.img4,
                R.drawable.img5
        };

        List<User> Names = new ArrayList<>();
        int count = 0;
        for(String name : names){
            Names.add(new User(name, emails.get(count), imageId[count]));
            count++;
        }
        return Names;
    }
}
