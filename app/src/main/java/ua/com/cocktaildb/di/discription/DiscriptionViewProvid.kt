package ua.com.cocktaildb.di.discription

import dagger.Module
import ua.com.cocktaildb.presenters.discription.IDiscription

@Module
class DiscriptionViewProvid (var view : IDiscription.IDiscriptionView){
}