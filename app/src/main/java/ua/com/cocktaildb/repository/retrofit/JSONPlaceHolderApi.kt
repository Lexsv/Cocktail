package ua.com.cocktaildb.repository.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ua.com.cocktaildb.repository.retrofit.entity.ListCategories
import ua.com.cocktaildb.repository.retrofit.entity.ListDescription
import ua.com.cocktaildb.repository.retrofit.entity.ListDrinks

interface JSONPlaceHolderApi {
    @GET("list.php?c=list")
    fun gelCategories(): Call<ListCategories>

    @GET("filter.php?")
    fun getDrinksOfCategorie(@Query("c") call : String): Call<ListDrinks>

    @GET("lookup.php?")
    fun getFullDetails(@Query("i") id : String): Call<ListDescription>
}