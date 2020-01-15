package ua.com.cocktaildb.di.loader;

import dagger.Module;
import dagger.Provides;
import ua.com.cocktaildb.presenters.loader.ILoader;

@Module
public class LoaderViewProvid {
    private ILoader.ILoaderView view;

    public LoaderViewProvid(ILoader.ILoaderView view) {
        this.view = view;
    }

    @Provides
    public ILoader.ILoaderView getILoaderView (){return view;}
}
