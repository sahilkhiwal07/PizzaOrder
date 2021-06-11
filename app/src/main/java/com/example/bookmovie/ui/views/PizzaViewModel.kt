package com.example.bookmovie.ui.views

import androidx.lifecycle.*
import com.example.bookmovie.data.Model.PizzaItem
import com.example.bookmovie.data.network.PizzaService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PizzaViewModel : ViewModel() {

    private val pizzaLiveData: MutableLiveData<List<PizzaItem>> = MutableLiveData()

    fun getPizzaOrder(): LiveData<List<PizzaItem>> {
        return pizzaLiveData
    }

    fun makeApiCall() {
        viewModelScope.launch(Dispatchers.IO) {
            val order = PizzaService.instance.getOrder().body()
            if (order != null) {
                this@PizzaViewModel.pizzaLiveData.postValue(order)
            }
        }
    }

}