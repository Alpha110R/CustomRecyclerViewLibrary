package com.example.customrecyclerviewlibrary;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CustomRecyclerView extends RecyclerView {
    public CustomRecyclerView(Context context) {
        super(context);
        initializeRecyclerView();
    }

    public CustomRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initializeRecyclerView();
    }

    public CustomRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initializeRecyclerView();
    }

    private void initializeRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        setLayoutManager(layoutManager);

        addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        addItemAnimation();
    }

    public void setAdapterAndLayout(RecyclerView.Adapter adapter) {
        setAdapter(adapter);
    }

    public void addPaginationSupport(final RecyclerViewUtils.PaginationListener paginationListener) {
        RecyclerViewUtils.addPaginationSupport(this, paginationListener);
    }

    public void addItemAnimation() {
        RecyclerViewUtils.addItemAnimation(this);
    }

    public void addDragAndDropSupport(ItemTouchHelper.Callback callback) {
        RecyclerViewUtils.addDragAndDropSupport(this, callback);
    }

    public void addSwipeGestures(ItemTouchHelper.SimpleCallback simpleCallback) {
        RecyclerViewUtils.addSwipeGestures(this, simpleCallback);
    }

    public void addCustomLayoutManager(RecyclerView.LayoutManager layoutManager) {
        RecyclerViewUtils.addCustomLayoutManager(this, layoutManager);
    }
}

