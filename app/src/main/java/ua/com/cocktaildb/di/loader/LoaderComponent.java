package ua.com.cocktaildb.di.loader;

import dagger.Component;
import ua.com.cocktaildb.presenters.loader.Loader;

@Component(modules = {LoaderPresenterModul.class,LoaderViewProvid.class})
public interface LoaderComponent {
    void  inject(Loader loader);
}
