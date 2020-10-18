package com.seventhson.o2otest.ui.main

import com.seventhson.o2otest.domain.interactors.GetRecipesInteractor
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainPresenterTest {

    private lateinit var sut: MainPresenter

    @Mock
    private lateinit var interactor: GetRecipesInteractor<Any?>

    @Mock
    private lateinit var view: MainView


    @Before
    fun setUp() {
        sut = MainPresenter(interactor)
        sut.attachView(view)
    }

    @Test
    fun onGetRecipesList_Test() {
        sut.onGetRecipeList("")

        verify(interactor).executeRepoCall()
    }

}