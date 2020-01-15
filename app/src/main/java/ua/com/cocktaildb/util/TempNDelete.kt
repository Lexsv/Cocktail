package ua.com.cocktaildb.util

//import android.util.Log
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//import ua.com.cocktaildb.repository.retrofit.ServiceApi.Companion.getJSONApi
//import ua.com.cocktaildb.repository.retrofit.entity.ListCategories
//
//private void loaddata() {
//    val json = getJSONApi()
//    val callCategor: Call<ListCategories?> = json.gelCategories()
//    callCategor.enqueue (){
//        override fun onResponse(
//            call: Call<ListCategories>,
//            response: Response<ListCategories>
//        ) {
//            Log.e("eee", response.body().toString())
//        }
//
//        override fun onFailure(
//            call: Call<ListCategories>,
//            t: Throwable
//        ) {
//        }
//    }

//        Call<ListDrinks> drinksCall = json.getDrinksOfCategorie("Cocktail");
//        drinksCall.enqueue(new Callback<ListDrinks>() {
//            @Override
//            public void onResponse(Call<ListDrinks> call, Response<ListDrinks> response) {
//                Log.e("********", response.body().toString());
//            }
//
//            @Override
//            public void onFailure(Call<ListDrinks> call, Throwable t) {
//                Log.e("------------------", t.getMessage());
//            }
//        });

//        Call<ListDescription> descriptionCall = json.getFullDetails("16134");
//        descriptionCall.enqueue(new Callback<ListDescription>() {
//            @Override
//            public void onResponse(Call<ListDescription> call, Response<ListDescription> response) {
//                Log.e("********", response.body().toString());
//            }
//
//            @Override
//            public void onFailure(Call<ListDescription> call, Throwable t) {
//
//            }
//        });