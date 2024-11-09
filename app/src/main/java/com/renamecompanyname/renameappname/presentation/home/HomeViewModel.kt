package com.renamecompanyname.renameappname.presentation.home

import com.renamecompanyname.renameappname.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject
constructor() : BaseViewModel<HomeViewModel.UiState, HomeViewModel.UiEvent>() {

    override fun initialState(): UiState.Success = UiState.Success

    override fun onEvent(event: UiEvent) {
        /* no-op */
    }

    sealed class UiEvent : BaseUiEvent

    sealed class UiState : BaseUiState {
        data object Success : UiState()
    }
}
