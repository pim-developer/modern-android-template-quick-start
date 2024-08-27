package com.renamecompanyname.renameappname.presentation.profile

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.renamecompanyname.renameappname.presentation.profile.ProfileViewModel.ProfileUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EditProfileViewModel @Inject constructor(

) : ViewModel() {

    // EXAMPLE
    var uiState = mutableStateOf(
        EditProfileState(),
    )
        private set


    fun onEvent(event: EditProfileEvent) {
        when (event) {

            else -> {

            }
        }
    }

    sealed class EditProfileEvent {

    }

    data class EditProfileState(
        var screenName: String = "Edit Profile Screen",
    ) {

    }
}