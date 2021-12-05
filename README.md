# Note App
A note android app, provides user to add, edit, delete notes.

# Demo
<span><img src="https://github.com/aligkts/NoteApplication/tree/develop/app/src/main/demo/add-note.gif" width="170" height="320"></span>
<span><img src="https://github.com/aligkts/NoteApplication/tree/develop/app/src/main/demo/delete-note.gif" width="170" height="320"></span>
<span><img src="https://github.com/aligkts/NoteApplication/tree/develop/app/src/main/demo/edit-note.gif" width="170" height="320"></span>

# Technologies

- Kotlin Coroutines, Flow, StateFlow
- Hilt
- Navigation Component
- LiveData
- ViewModel
- Room
- Glide
- jUnit
- Mockk
- Coroutine Test

# Architecture
A custom architecture inspired by the [Google MVVM](https://developer.android.com/jetpack/guide) and the [Clean architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html).

This architecture allows app to be offline. It gets data from the local database and persists it. Local database is the single source of truth of the app and after its data changes, it notifies other layers using coroutine flows.
