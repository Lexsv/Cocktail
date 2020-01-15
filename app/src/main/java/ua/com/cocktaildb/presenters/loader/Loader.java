package ua.com.cocktaildb.presenters.loader;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.com.cocktaildb.R;
import ua.com.cocktaildb.di.loader.DaggerLoaderComponent;
import ua.com.cocktaildb.di.loader.LoaderPresenterModul;
import ua.com.cocktaildb.di.loader.LoaderViewProvid;
import ua.com.cocktaildb.repository.retrofit.JSONPlaceHolderApi;
import ua.com.cocktaildb.repository.retrofit.ServiceApi;
import ua.com.cocktaildb.repository.retrofit.entity.ListCategories;


public class Loader extends Fragment implements ILoader.ILoaderView{

    @Inject
    public ILoader.ILoaderPresenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.loader,container,false);
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addDaggerDepandance();
        mPresenter.onStart();
    }

    private void addDaggerDepandance() {
        DaggerLoaderComponent.builder()
                .loaderViewProvid(new LoaderViewProvid(this))
                .loaderPresenterModul(new LoaderPresenterModul())
                .build()
                .inject(this);

    }


    @Override
    public LifecycleOwner getLifecycleOwner() {return this;}

    @Override
    public void getListView() {NavHostFragment.findNavController(this).navigate(R.id.listcoctail);}
}
