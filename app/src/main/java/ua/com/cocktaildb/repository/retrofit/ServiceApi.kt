package ua.com.cocktaildb.repository.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceApi {
    companion object{
        private val BASE_URL = "https://www.thecocktaildb.com/api/json/v1/1/"
        private var retrofit: Retrofit? = null



        fun getJSONApi(): JSONPlaceHolderApi{
            if (retrofit == null){
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!.create(JSONPlaceHolderApi::class.java)
        }
    }

}