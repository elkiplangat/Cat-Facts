package com.elkiplangat.catfacts

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel(){
    private var _response = MutableLiveData<CatFact>()
    val data:String

    val response: LiveData<CatFact>
        get() = _response

    init {
        data = "data"
        getCatFacts()
    }
    private fun getCatFacts(){
        CatsApiService.CatsApi.retrofitService.getCatFacts().enqueue(object :Callback<CatFact>{
            override fun onFailure(call: Call<CatFact>, t: Throwable) {
                //_response.value = "Failure"+t.message
            }

            override fun onResponse(call: Call<CatFact>, response: Response<CatFact>) {
                _response.value = response.body()
            }
        })
    }
}