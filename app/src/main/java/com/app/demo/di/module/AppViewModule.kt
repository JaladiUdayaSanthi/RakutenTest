package com.app.demo.di.module

import com.app.demo.repository.ServiceAPI
import com.app.demo.repository.DetailsRepository
import com.app.demo.usecase.DetailsUseCase
import com.app.demo.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val appViewModule = module{
        factory { DetailsRepository(provideServiceApi(get())) }
        factory { DetailsUseCase(get()) }
        viewModel { MainViewModel(get()) }
}


fun provideServiceApi(retrofit: Retrofit): ServiceAPI = retrofit.create(ServiceAPI::class.java)

