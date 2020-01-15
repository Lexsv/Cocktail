package ua.com.cocktaildb.presenters.discription

import androidx.lifecycle.LifecycleOwner
import ua.com.cocktaildb.repository.retrofit.entity.DescriptionCoctail
import ua.com.cocktaildb.repository.retrofit.entity.TitleDrink

interface IDiscription {
    interface IDiscriptionView{
        fun getLifecycleOwner(): LifecycleOwner
        fun viewDescription(item : DescriptionCoctail)
    }
    interface IDiscriptionPresenter{
       fun onStart(item : TitleDrink)
    }
}