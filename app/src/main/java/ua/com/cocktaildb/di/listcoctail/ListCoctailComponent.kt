package ua.com.cocktaildb.di.listcoctail

import dagger.Component
import ua.com.cocktaildb.presenters.listcoctail.ListCoctail

@Component(modules = arrayOf(ListCoctailPresetModul::class,ListCoctailViewProvid::class))
interface ListCoctailComponent {
    fun inject( listCoctail: ListCoctail)
}