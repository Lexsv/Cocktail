package ua.com.cocktaildb.presenters.discription

import androidx.lifecycle.Observer
import ua.com.cocktaildb.models.ILoadData
import ua.com.cocktaildb.models.LoadData
import ua.com.cocktaildb.repository.local.Store
import ua.com.cocktaildb.repository.retrofit.entity.TitleDrink
import javax.inject.Inject

class DiscriptionPresenter @Inject constructor(var view: IDiscription.IDiscriptionView): IDiscription.IDiscriptionPresenter {

    var  mModel : ILoadData
    init {
        mModel = LoadData()
    }

    override fun onStart(item: TitleDrink) {
        mModel.loadItem(item)
        Store.getDescription().observe(view.getLifecycleOwner(), Observer {
            view.viewDescription(it)
        })


    }

}