package ua.com.cocktaildb.presenters.loader;

import android.util.Log;

import javax.inject.Inject;

import ua.com.cocktaildb.models.ILoadData;
import ua.com.cocktaildb.models.LoadData;
import ua.com.cocktaildb.repository.local.Store;

public class LoaderPresenter implements ILoader.ILoaderPresenter {

    private ILoader.ILoaderView view;
    private ILoadData mModel;


    @Inject
    public LoaderPresenter(ILoader.ILoaderView view) {
        this.mModel = new LoadData();
        this.view = view;
    }

    @Override
    public void onStart() {
        mModel.startLoaderData();
        Store.Companion.getlistDrinks().observe(view.getLifecycleOwner(), listMap -> {
                mModel.formDataForView();
                view.getListView();
        });

    }
}
