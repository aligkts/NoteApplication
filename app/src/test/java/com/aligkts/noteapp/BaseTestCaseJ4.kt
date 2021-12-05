package com.aligkts.noteapp

import io.mockk.unmockkAll
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.Ignore

@OptIn(ExperimentalCoroutinesApi::class)
@Ignore("This is base class")
open class BaseTestCaseJ4 {

    protected val testDispatcher = TestCoroutineDispatcher()
    protected val testScope = TestCoroutineScope(testDispatcher)

    open fun setUp() {
        Dispatchers.setMain(testDispatcher)
    }

    open fun tearDown() {
        testScope.uncaughtExceptions.firstOrNull()?.let { throw it }
        unmockkAll()
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
        testScope.cleanupTestCoroutines()
    }
}