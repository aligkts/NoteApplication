package com.aligkts.noteapp.data.local.note

import androidx.test.filters.MediumTest
import com.aligkts.noteapp.utils.BaseTestCase
import com.aligkts.noteapp.utils.noteItemEntity
import com.aligkts.noteapp.utils.noteItemEntity2
import com.google.common.truth.Truth.assertThat
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import java.util.concurrent.CountDownLatch
import javax.inject.Inject

/**
 * Created by Ali Göktaş on 05,December,2021
 */

@OptIn(ExperimentalCoroutinesApi::class)
@HiltAndroidTest
@MediumTest
class FavoritesDaoTest : BaseTestCase() {

    @Inject
    lateinit var noteDao: NoteDao

    @Before
    override fun setUp() = super.setUp()

    @Test
    fun insertDeleteAndRetrieveTest() = runBlocking {
        noteDao.insert(noteItemEntity)
        noteDao.insert(noteItemEntity2)
        val noteList = mutableListOf<NoteEntity?>()
        val job = launch {
            noteDao.getNote(noteItemEntity.id).collect {
                noteList.add(it)
                assertThat(noteList).isEqualTo(listOf(noteItemEntity))
                noteDao.delete(noteItemEntity.id)
                assertThat(noteList).isEqualTo(listOf(noteItemEntity, null))
            }
        }


        job.cancel()
    }

    @Test
    fun insertAndGetAllNotes() = runBlocking {
        noteDao.insert(noteItemEntity)
        noteDao.insert(noteItemEntity2)
        val noteList = mutableListOf<NoteEntity?>()
        val latch = CountDownLatch(1)
        val job = launch {
            noteDao.getAllNotes().collect {
                noteList.addAll(it)
                assertThat(noteList).isEqualTo(listOf(noteItemEntity, noteItemEntity2))
                latch.countDown()
            }
        }

        job.cancel()
    }

    @Test
    fun updateNote() = runBlocking {
        noteDao.insert(noteItemEntity)
        val noteList = mutableListOf<NoteEntity?>()
        noteDao.update(noteItemEntity2)
        val job = launch {
            noteDao.getAllNotes().collect {
                noteList.addAll(it)
                assertThat(noteList).isEqualTo(listOf(noteItemEntity2))
            }
        }
        job.cancel()
    }
}