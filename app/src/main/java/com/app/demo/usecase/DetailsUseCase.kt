package com.app.demo.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.demo.data.ResponseList
import com.app.demo.model.Response
import com.app.demo.model.ResultWithData
import com.app.demo.repository.DetailsRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class DetailsUseCase(private val userDetailsRepository: DetailsRepository):
        UseCase<LiveData<ResultWithData<ResponseList>>>, Cancellable, CoroutineScope {

    private var job: Job? = null
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO


    override fun execute(): MutableLiveData<ResultWithData<ResponseList>> {
        val result = MutableLiveData<ResultWithData<ResponseList>>()
        launch(Dispatchers.IO) {
            val toPost = when (val res = userDetailsRepository.getListDetails()) {
                is Response.Success -> {
                    ResultWithData.Success(res.data)
                }
                is Response.Failure -> {
                    ResultWithData.Failure(res.failure)
                }
                is Response.Error -> {
                    ResultWithData.Error(res.exception)
                }
            }
            result.postValue(toPost)
        }
        return result
    }

    override fun cancel() {
        if(coroutineContext.isActive)
            job?.cancel()
    }
}
