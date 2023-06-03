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

allprojects {
repositories {
...
maven { url 'https://jitpack.io' }
}
}


### Step 2: Add the library dependency to your app-level build.gradle file

Add the following line of code to the `dependencies` section of your app-level build.gradle file:

dependencies {
implementation 'com.github.Alpha110R:CustomRecyclerViewLibrary:1.00.02'
}

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the CustomRecyclerView
        customRecyclerView = findViewById(R.id.customRecyclerView);

        // Create and set the CustomAdapter
        customAdapter = new CustomAdapter();
        customRecyclerView.setAdapterAndLayout(customAdapter);

        // Add pagination support
        customRecyclerView.addPaginationSupport(new CustomRecyclerView.PaginationListener() {
            @Override
            public void loadMoreItems() {
                // Load more items logic
            }

            @Override
            public boolean isLoading() {
                // Return the loading state
                return false;
            }

            @Override
            public boolean isLastPage() {
                // Return whether it is the last page
                return false;
            }
        });

        // Add item divider
        customRecyclerView.addItemDivider(R.drawable.item_divider);

        // Add item click listener
        customRecyclerView.setOnItemClickListener(new CustomRecyclerView.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // Handle item click
            }
        });
    }
}
```
## What's new ?

1.00.02:

## License

Copyright 2023 Alon Ronder

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
