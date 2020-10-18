package com.seventhson.o2otest.ui.main

import com.seventhson.o2otest.data.network.APIService
import com.seventhson.o2otest.data.repository.RecipeRepositoryImpl
import com.seventhson.o2otest.data.repository.Repository
import com.seventhson.o2otest.domain.interactors.GetRecipesInteractor
import com.seventhson.o2otest.domain.model.Recipe
import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class GetRecipesInteractorTest {

    //System Under Test -> SUT
    private lateinit var sut: GetRecipesInteractor

    private val mainThread = newSingleThreadContext("UIThread")

    @Mock
    private lateinit var repository: RecipeRepositoryImpl

    @Mock
    private lateinit var presenter: MainPresenter

    @Before
    fun setUp() {
        sut = GetRecipesInteractor(repository)
        Dispatchers.setMain(mainThread)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThread.close()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getRecipes_onSuccess_verify() = runBlockingTest {
        sut.setParams("")
        sut.executeRepoCall()
    }


}