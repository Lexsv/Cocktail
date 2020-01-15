package ua.com.cocktaildb.di.discription

import dagger.Module
import dagger.Provides
import ua.com.cocktaildb.presenters.discription.DiscriptionPresenter
import ua.com.cocktaildb.presenters.discription.IDiscription

@Module
class DiscriptionPresenterModul (var view: IDiscription.IDiscriptionView){
    @Provides
    fun getIDiscriptionPresenter(): IDiscription.IDiscriptionPresenter = DiscriptionPresenter(view)
}