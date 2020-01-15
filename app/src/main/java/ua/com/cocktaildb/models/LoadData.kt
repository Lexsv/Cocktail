package ua.com.cocktaildb.models

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ua.com.cocktaildb.repository.local.Store
import ua.com.cocktaildb.repository.retrofit.ServiceApi
import ua.com.cocktaildb.repository.retrofit.entity.*
import java.lang.reflect.Array
import java.util.*
import kotlin.collections.ArrayList


class LoadData : ILoadData {

    val quary = ServiceApi.getJSONApi()

    override fun startLoaderData() {

        quary.gelCategories()
            .enqueue(object : Callback<ListCategories> {

                override fun onResponse(
                    call: Call<ListCategories>,
                    response: Response<ListCategories>
                ) {
                    Store.getListCategories().value = response.body()!!.drinks
                    loadDrinks(response.body()!!.drinks[0].strCategory)
                }

                override fun onFailure(call: Call<ListCategories>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
    }

    override fun formDataForView() {
        val listCategory = Store.getListCategories().value
        val map = Store.getlistDrinks().value

        val listFromMap = map?.get(listCategory!![0].strCategory)
        Store.listItemView = listFromMap as List<RowType>
        val temp = Store.listItemView.toMutableList()
        temp[0]= listCategory!![0]
        Store.listItemView = temp

    }


    fun loadDrinks(strCategory: String) {
        quary.getDrinksOfCategorie(strCategory)
            .enqueue(object : Callback<ListDrinks> {
                override fun onResponse(call: Call<ListDrinks>, response: Response<ListDrinks>) {
                    Store.getlistDrinks().postValue(mapOf(strCategory to response.body()!!.drinks))
                }

                override fun onFailure(call: Call<ListDrinks>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            })
    }

    override fun loadItem(item: TitleDrink) {
        quary.getFullDetails(item.idDrink)
            .enqueue(object : Callback<ListDescription> {
                override fun onResponse(
                    call: Call<ListDescription>,
                    response: Response<ListDescription>
                ) {
                    Store.getDescription().postValue(response.body()!!.drinks[0])
                }

                override fun onFailure(call: Call<ListDescription>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
    }
}




