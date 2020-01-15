package ua.com.cocktaildb.presenters.listcoctail

import ua.com.cocktaildb.repository.retrofit.entity.RowType

interface IListCoctail {
    interface IListCoctailView{
        fun showRecyclerList(list: List<RowType>)
    }
    interface IListCoctailPresenter{
        fun  onStart()

    }
}