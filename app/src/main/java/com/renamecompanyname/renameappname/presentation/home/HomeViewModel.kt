package com.renamecompanyname.renameappname.presentation.home


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.renamecompanyname.renameappname.domain.ExampleModelObject
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
//     EXAMPLE repository dependency injection
//    private val repository: Repository
) : ViewModel() {

//     EXAMPLE reading and sorting a list from repository
//    val eventsFeedState: StateFlow<List<ModelObject>> =
//        repository.readSomeEvents()
//            .map { events ->
//                events.sortedBy { it.dateEpochSecondsUTC } // Sort by oldest to newest (ascending order)
//            }
//            .stateIn(
//                scope = viewModelScope,
//                started = SharingStarted.WhileSubscribed(5_000),
//                initialValue = emptyList()
//            )

    // EXAMPLE
    var exampleViewModelState = mutableStateOf(
        ExampleViewModelState(),
    )
        private set

    fun onEvent(event: HomeViewModelEvent) {
        when (event) {

            // EXAMPLE
            is HomeViewModelEvent.ExampleEventNewName -> {
                exampleViewModelState.value =
                    exampleViewModelState.value.copy(exampleModelObject = ExampleModelObject(event.newName))
            }

            // EXAMPLE
            is HomeViewModelEvent.ExampleEventSaveChanges -> {

            }
        }
    }

    sealed class HomeViewModelEvent {
        // EXAMPLE
        data class ExampleEventNewName(val newName: String) : HomeViewModelEvent()

        // EXAMPLE
        data object ExampleEventSaveChanges : HomeViewModelEvent()
    }

    data class ExampleViewModelState(
        var exampleModelObject: ExampleModelObject? = null
    )
}