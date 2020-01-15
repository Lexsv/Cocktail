package ua.com.cocktaildb.di.listcoctail

import dagger.Module
import dagger.Provides
import ua.com.cocktaildb.presenters.listcoctail.IListCoctail
import ua.com.cocktaildb.presenters.listcoctail.ListCoctailPresenter


@Module
class ListCoctailPresetModul(var listCoctail: IListCoctail.IListCoctailView) {
    @Provides
    fun getIListCoctailPesenter(): IListCoctail.IListCoctailPresenter = ListCoctailPresenter(listCoctail)
}