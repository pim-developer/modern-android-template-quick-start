package com.renamecompanyname.renameappname.presentation.profile

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EditProfileViewModel @Inject constructor(

) : ViewModel() {


    fun onEvent(event: EditProfileEvent) {
        when (event) {

            else -> {

            }
        }
    }

    sealed class EditProfileEvent {

    }

    data class EditProfileState(
        val submissionLoading: Boolean? = false,
    ) {
        fun hasErrors(): Boolean {
            return (submissionLoading != null && submissionLoading)
        }
    }
}