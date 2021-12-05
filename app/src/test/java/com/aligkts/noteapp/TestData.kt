package com.aligkts.noteapp

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