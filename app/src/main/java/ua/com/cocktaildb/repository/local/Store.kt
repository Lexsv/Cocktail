package ua.com.cocktaildb.repository.local

import android.app.LauncherActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ua.com.cocktaildb.repository.retrofit.entity.*

class Store : ViewModel() {
    companion object {
        private val listCategories: MutableLiveData<List<CategoryName>> = MutableLiveData()
        fun getListCategories() = listCategories


        private val listDrinks: MutableLiveData<Map<String,List<TitleDrink>>> = MutableLiveData()
        fun getlistDrinks() = listDrinks

        private var discription: MutableLiveData<DescriptionCoctail> = MutableLiveData()
        fun getDescription() = discription

        var listItemView: List<RowType>  = ArrayList()

    }
}