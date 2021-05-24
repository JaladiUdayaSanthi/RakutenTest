package com.app.demo

import android.content.Context
import com.app.demo.di.module.apimodule
import com.app.demo.di.module.appViewModule
import com.google.gson.Gson
import io.mockk.unmockkAll
import org.junit.After
import org.junit.Before
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations

abstract class BaseTest : KoinTest {

    val context = mock(Context::class.java)

    @Before
    open fun beforeEach() {
        MockitoAnnotations.initMocks(this)
        if (GlobalContext.getOrNull() == null) {
            startKoin {
                androidContext(context)
                modules(
                    listOf(
                        apimodule,
                        appViewModule
                    )
                )
            }
        }
    }

    fun <T> getTestMockResource(path: String, responseObj: Class<T>): T {
        return Gson().fromJson(this.javaClass.classLoader!!.getResource(path).readText(), responseObj)
    }


    @After
    open fun afterEach() {
        stopKoin()
        try {
            unmockkAll()
            Mockito.validateMockitoUsage()
        } catch (t: Throwable) {
            println("There could be no Mockito usage to validate")
        }
    }


}