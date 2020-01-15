package ua.com.cocktaildb.di.discription

import dagger.Component
import ua.com.cocktaildb.presenters.discription.Discription

@Component(modules = arrayOf(DiscriptionPresenterModul::class,DiscriptionViewProvid::class))
interface DiscriptionComponent {
    fun inject(mDiscription : Discription)
}