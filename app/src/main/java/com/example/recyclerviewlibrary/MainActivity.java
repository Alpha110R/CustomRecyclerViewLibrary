package com.example.recyclerviewlibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.example.customrecyclerviewlibrary.RecyclerViewUtils;
import com.example.recyclerviewlibrary.databinding.ActivityMainBinding;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ActivityMainBinding binding;
    private CustomAdapter customAdapter;
    private List<String> dataList;
    private int i;
    private int page = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dataList = new ArrayList<>();

        for (i = 0; i < 10; i++) {
            dataList.add("Item " + i);
        }

        customAdapter = new CustomAdapter(dataList);

        // 1. Change layout according to needs
        binding.customRecyclerView.addLinearLayoutManager(true);
        // 2. Change duration of fade in/out
        binding.customRecyclerView.addItemAnimation(1000L);
        // 3. Add dividers between each item
        binding.customRecyclerView.addDividerItemDecoration(true);
        // 4. Support pagination logic
        binding.customRecyclerView.addPaginationSupport(new RecyclerViewUtils.PaginationListener() {
            @Override
            public void loadMoreItems() {
                Log.d(TAG, "load 10 more items");

                page++; // increase the page number

                // load the new page THEORETICALLY

                // add the new page to the recycler view
                ArrayList<String> pageList = new ArrayList<>();
                for (int j = 0; j < 10; j++) {
                    pageList.add("New Item " + i++);
                }
                customAdapter.updateList(pageList);
            }

            @Override
            public boolean isLoading() {
                // Return loading state here
                return false;
            }

            @Override
            public boolean isLastPage() {
                // Return last page state here
                return false;
            }
        });
        // 5. Add swipe gesture(support right & left)
        binding.customRecyclerView.addSwipeGestures(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                // Implement onMove gestures
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                // Implement onSwiped gestures
                customAdapter.removeItem(viewHolder.getAdapterPosition());
            }
        });
        binding.mainBTNAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customAdapter.addItem("Item " + i++);
                binding.customRecyclerView.smoothScrollToPosition(customAdapter.getItemCount() - 1);
            }
        });
        binding.customRecyclerView.setAdapter(customAdapter);
    }
}

