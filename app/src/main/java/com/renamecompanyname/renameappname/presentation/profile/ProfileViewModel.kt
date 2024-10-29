package com.renamecompanyname.renameappname.presentation.profile

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel
@Inject
constructor() : ViewModel() {
    // EXAMPLE
    var uiState =
        mutableStateOf(
            ProfileUiState(),
        )
        private set

    fun onEvent(event: ProfileEvent) {
        when (event) {
            else -> {
            }
        }
    }

    sealed class ProfileEvent

    data class ProfileUiState(
        var screenName: String = "Profile Screen",
    )
}
