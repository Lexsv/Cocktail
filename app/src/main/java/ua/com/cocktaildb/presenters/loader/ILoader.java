package ua.com.cocktaildb.presenters.loader;

import androidx.lifecycle.LifecycleOwner;

public interface ILoader {
    interface ILoaderView {
        LifecycleOwner getLifecycleOwner();
        void getListView();
    }

    interface ILoaderPresenter {
        void onStart();

    }
}
