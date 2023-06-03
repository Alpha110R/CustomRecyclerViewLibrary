# CustomRecyclerView Library

[![](https://jitpack.io/v/Alpha110R/CustomRecyclerViewLibrary.svg)](https://jitpack.io/#Alpha110R/CustomRecyclerViewLibrary)

CustomRecyclerView is an Android library that simplifies the usage of RecyclerView and provides additional features to enhance the user experience.

## Features

- Easy and simplified initialization of RecyclerView with customizable options.
- Smooth item animations for seamless transitions.
- Drag-and-drop support for rearranging items in the RecyclerView.
- Swipe gestures for implementing item actions, such as swipe to delete.
- Support for custom layout managers to achieve unique RecyclerView layouts.
- Pagination support for loading more items as the user scrolls.

## Installation

To use CustomRecyclerView in your Android project, follow these steps:

### Step 1: Add the JitPack repository to your project-level build.gradle file

Add the following lines of code to the `allprojects` section of your project-level build.gradle file:

```
allprojects {
    repositories {
    ...
    maven { url 'https://jitpack.io' }
    }
}
```

### Step 2: Add the library dependency to your app-level build.gradle file

Add the following line of code to the `dependencies` section of your app-level build.gradle file:

```
dependencies {
    implementation 'com.github.Alpha110R:CustomRecyclerViewLibrary:1.00.02'
}
```

### Step 3: Sync your project with Gradle files

Click on the "Sync Now" button in Android Studio to sync your project with the updated Gradle files.

### Step 4: Start using CustomRecyclerView

You are now ready to use CustomRecyclerView in your Android project. Follow the documentation and examples provided in the library to leverage its features and simplify your RecyclerView implementation.

## Example Usage

Here's an example of how to use CustomRecyclerView in your MainActivity class:

```java
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

        customRecyclerView.setAdapterAndLayout(customAdapter);

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
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull                 RecyclerView.ViewHolder target) {
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
```
## What's new ?

1.00.02:

## License

Copyright 2023 Alon Ronder & Elad Sabag

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
