package ua.com.cocktaildb.presenters.listcoctail

import ua.com.cocktaildb.repository.local.Store
import javax.inject.Inject

class ListCoctailPresenter @Inject constructor(var view: IListCoctail.IListCoctailView): IListCoctail.IListCoctailPresenter {

    override fun onStart() {
        view.showRecyclerList(Store.listItemView)
    }

}