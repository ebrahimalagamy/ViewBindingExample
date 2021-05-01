package com.example.viewbindingexample;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewbindingexample.Adapter.ItemAdapter;
import com.example.viewbindingexample.Model.ItemModel;
import com.example.viewbindingexample.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ItemModel> itemModelArrayList;
    ActivityMainBinding binding;
    RecyclerView.LayoutManager layoutManager;

    private int layoutView = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);

        dataArray();

    }

    // to avoid memory leaks
    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    private void dataArray() {
        itemModelArrayList = new ArrayList<>();

        itemModelArrayList.add(new ItemModel("https://firebasestorage.googleapis.com/v0/b/engaz-admin.appspot.com/o/uploads%2F1617251387731.jpg?alt=media&token=dc01557c-160b-44e2-a2ee-9fc927f46f54"
                , "USA", "Description 1"));
        itemModelArrayList.add(new ItemModel("https://firebasestorage.googleapis.com/v0/b/engaz-admin.appspot.com/o/uploads%2F1617251516446.jpg?alt=media&token=a38d9089-552d-4bd0-ba1c-4d98d9fafe75"
                , "EGY", "Description 2"));
        itemModelArrayList.add(new ItemModel("https://firebasestorage.googleapis.com/v0/b/engaz-admin.appspot.com/o/uploads%2F1617296903139.jpg?alt=media&token=a5533bf6-b07d-4e34-8563-e24301fa04f6"
                , "AU", "Description 3"));
        itemModelArrayList.add(new ItemModel("https://firebasestorage.googleapis.com/v0/b/engaz-admin.appspot.com/o/uploads%2F1617333176460.jpg?alt=media&token=78cdac2a-6db5-4bcd-9f96-371d0fe48e0e"
                , "BR", "Description 4"));
        itemModelArrayList.add(new ItemModel("https://firebasestorage.googleapis.com/v0/b/engaz-admin.appspot.com/o/uploads%2F1617333133886.jpg?alt=media&token=189ccfec-afbb-40ef-b2bc-f6945d551da4"
                , "CA", "Description 5"));
        itemModelArrayList.add(new ItemModel("https://firebasestorage.googleapis.com/v0/b/engaz-admin.appspot.com/o/uploads%2F1617332929909.jpg?alt=media&token=fe0592be-aa62-46c6-9e46-60e11779dc59"
                , "CN", "Description 6"));

        ItemAdapter itemAdapter = new ItemAdapter(itemModelArrayList, MainActivity.this);
        binding.recyclerView.setAdapter(itemAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.change_style) {
            Toast.makeText(this, "Select", Toast.LENGTH_SHORT).show();

            if (layoutView == 0) {
                layoutManager = new GridLayoutManager(this, 2);
                binding.recyclerView.setLayoutManager(layoutManager);
                layoutView = 1;
            } else if (layoutView == 1) {
                layoutManager = new LinearLayoutManager(this);
                binding.recyclerView.setLayoutManager(layoutManager);
                layoutView = 0;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}