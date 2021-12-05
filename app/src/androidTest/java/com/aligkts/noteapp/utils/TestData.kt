package com.aligkts.noteapp.utils

import com.aligkts.noteapp.data.local.note.NoteEntity
import kotlin.random.Random

/**
 * Created by Ali Göktaş on 05,December,2021
 */

val noteItemEntity = NoteEntity(
    id = Random.nextLong(),
    "Title",
    "Detail",
    "05/12/2021",
    null,
    edited = false
)
val noteItemEntity2 = NoteEntity(
    id = Random.nextLong(),
    "Title2",
    "Detail2",
    "05/12/2021",
    null,
    edited = true
)