package com.example.distinctuntilchanged

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    private val _value: MutableLiveData<Int> = MutableLiveData()
    val value: LiveData<Int> = Transformations.distinctUntilChanged(_value)

    fun setValue(value: Int) {
        _value.postValue(value)
    }
}