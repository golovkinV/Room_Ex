package com.example.room_ex.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.models.SomethingDB
import com.example.data.repositories.SomethingRepository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    fun observeAllSomething() = SomethingRepository.instance.getAllSomethingData()

    fun addStaticSomethingModel() {
        viewModelScope.launch {
            val model = SomethingDB(
                title = "Title 1",
                subtitle = "Subtitle 1"
            )
            SomethingRepository.instance.addSomething(model)
        }
    }

    fun deleteSomethingModel(model: SomethingDB) {
        viewModelScope.launch {
            SomethingRepository.instance.deleteSomething(model)
        }
    }

    fun updateSomethingModel(model: SomethingDB) {
        viewModelScope.launch {
            model.title = "Title Update"
            SomethingRepository.instance.updateSomething(model)
        }
    }
}