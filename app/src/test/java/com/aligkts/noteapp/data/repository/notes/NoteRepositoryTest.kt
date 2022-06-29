package com.aligkts.noteapp.data.repository.notes

import com.aligkts.noteapp.BaseTestCaseJ4
import com.aligkts.noteapp.domain.model.Note
import com.aligkts.noteapp.noteItemEntity
import com.google.common.truth.Truth.assertThat
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test


@OptIn(ExperimentalCoroutinesApi::class)
class MovieResponseRepositoryTest : BaseTestCaseJ4() {

    private val local: NotesLocalDataSource = mockk(relaxUnitFun = true)
    private val noteRepository = NoteRepository(local)

    @Before
    override fun setUp() {
        super.setUp()
    }

    @After
    override fun tearDown() {
        confirmVerified(local)
        super.tearDown()
    }

    @Test
    fun `test get note when exists in db`() = runBlocking {
        every {
            local.getNote(noteItemEntity.id)
        } returns listOf(noteItemEntity).asFlow()

        noteRepository.getNote(noteItemEntity.id)
            .toList()
            .also { assertThat(it).isEqualTo(listOf(noteItemEntity.toNote())) }

        coVerifySequence {
            local.getNote(noteItemEntity.id)
        }
    }

    @Test
    fun `test get note when not exists in db`() = runBlocking {
        val stateFlow = MutableStateFlow(noteItemEntity)
        every { local.getNote(noteItemEntity.id) } returns stateFlow
        val result = mutableListOf<Note?>()

        testScope.launch {
            noteRepository.getNote(noteItemEntity.id)
                .collect { result.add(it) }
        }

        assertThat(result).isEqualTo(listOf(noteItemEntity.toNote()))

        coVerifySequence {
            local.getNote(noteItemEntity.id)
        }
    }
}