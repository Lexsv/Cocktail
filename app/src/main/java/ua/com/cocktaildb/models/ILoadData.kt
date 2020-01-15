package ua.com.cocktaildb.models

import ua.com.cocktaildb.repository.retrofit.entity.TitleDrink

interface ILoadData {
    fun startLoaderData()
    fun formDataForView()
    fun loadItem(item: TitleDrink)
}