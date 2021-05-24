package com.app.demo.viewmodel

import androidx.lifecycle.*
import com.app.demo.data.ResponseList
import com.app.demo.data.Value
import com.app.demo.model.ResultWithData
import com.app.demo.model.SimpleError
import com.app.demo.usecase.DetailsUseCase


class MainViewModel(private val detailsUseCase: DetailsUseCase): ViewModel() {
    private val _response: MutableLiveData<ResponseList> = MutableLiveData()
    val response: LiveData<ResponseList>
        get() = _response

    private lateinit var repositoryData:Value

    init {
        getDetails()
    }

    private fun getDetails() {
        val data = detailsUseCase.execute()
        data.observeForever {
            when (it) {
                is ResultWithData.Success -> {
                    _response.postValue(it.data)
                }
                is ResultWithData.Error -> {
                    SimpleError("------ Error -----","------- Error in json -------")
                }
                else -> {

                }
            }
        }
    }

    fun updateItemData(data:Value){
        repositoryData = data
    }

    fun getItemData() = repositoryData

}


