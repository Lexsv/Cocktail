package ua.com.cocktaildb.di.loader;

import dagger.Module;
import dagger.Provides;
import ua.com.cocktaildb.presenters.loader.ILoader;
import ua.com.cocktaildb.presenters.loader.LoaderPresenter;

@Module
public class LoaderPresenterModul {
    @Provides
    public ILoader.ILoaderPresenter getILoaderPresenter(ILoader.ILoaderView view){
        return new LoaderPresenter(view);
    }
}
