package com.example.recyclerviewlibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import com.example.customrecyclerviewlibrary.CustomRecyclerView;
import com.example.customrecyclerviewlibrary.RecyclerViewUtils;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CustomRecyclerView customRecyclerView;
    private CustomAdapter customAdapter;
    private List<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customRecyclerView = findViewById(R.id.customRecyclerView);


        dataList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            dataList.add("Item " + (i + 1));
        }

        customAdapter = new CustomAdapter(dataList);

        customRecyclerView.addLinearLayoutManager(true);
        customRecyclerView.addItemAnimation();
        customRecyclerView.addDividerItemDecoration(true);
        customRecyclerView.setAdapter(customAdapter);

        customRecyclerView.addPaginationSupport(new RecyclerViewUtils.PaginationListener() {
            @Override
            public void loadMoreItems() {
                // Load more items here
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
        customRecyclerView.addDragAndDropSupport(new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
                // Implement getMovementFlags
                return 0;
            }

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                // Implement onMove gestures
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                // Implement onSwipe gestures
            }
        });
        customRecyclerView.addSwipeGestures(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                // Implement onMove gestures
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                // Implement onSwiped gestures
            }
        });
    }
}

