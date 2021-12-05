# Note App
A note android app, provides user to add, edit, delete notes. You need to swipe left to delete your note.

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
