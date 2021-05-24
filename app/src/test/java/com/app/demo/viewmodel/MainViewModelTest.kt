package com.app.demo.viewmodel

import com.app.demo.BaseTest
import com.app.demo.data.ResponseList
import com.app.demo.repository.DetailsRepository
import com.app.demo.repository.ServiceAPI
import com.app.demo.usecase.DetailsUseCase
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.doAnswer
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import retrofit2.Call
import retrofit2.Callback

class AccountsServiceRepositoryTest : BaseTest() {

    private lateinit var detailsRepo: DetailsRepository
    private lateinit var useCase: DetailsUseCase
    private lateinit var viewModel: MainViewModel

    private val serviceAPI = mockk<ServiceAPI>()

    private val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        detailsRepo = DetailsRepository(serviceAPI)
        useCase = DetailsUseCase(detailsRepo)
        viewModel = MainViewModel(useCase)
        Dispatchers.setMain(testDispatcher)
    }

    @Before
    fun finally() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `success response from getDetails`() = testDispatcher.runBlockingTest {
        val successResponse = retrofit2.Response.
        success(getTestMockResource("mocks/repositoryData.json", ResponseList::class.java))
        val mockAccountSummaryResponse = mockk<Call<ResponseList>>()

        doAnswer {
            val callback = it.getArgument(0) as Callback<ResponseList>
            callback.onResponse(mockAccountSummaryResponse, successResponse)
        }.`when`(mockAccountSummaryResponse).enqueue(any())
        Mockito.`when`(serviceAPI.getServiceUrl())
            .thenReturn(mockAccountSummaryResponse)

        val successCallback: (ResponseList?) -> Unit = {}
        val successCallbackSpy = spy(successCallback)

        val result = viewModel.response.value
        Assert.assertEquals(result,successCallbackSpy)

    }

}