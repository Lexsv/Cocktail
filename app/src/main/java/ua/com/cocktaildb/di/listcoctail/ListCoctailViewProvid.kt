package ua.com.cocktaildb.di.listcoctail

import dagger.Module
import ua.com.cocktaildb.presenters.listcoctail.IListCoctail

@Module
class ListCoctailViewProvid (var listCoctail: IListCoctail.IListCoctailView){
}