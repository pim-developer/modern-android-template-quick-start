package com.renamecompanyname.renameappname.presentation.profile

import androidx.lifecycle.viewModelScope
import com.renamecompanyname.renameappname.domain.model.User
import com.renamecompanyname.renameappname.domain.usecase.CreateUserUseCase
import com.renamecompanyname.renameappname.domain.usecase.DeleteUserUseCase
import com.renamecompanyname.renameappname.domain.usecase.GetAllUsersUseCase
import com.renamecompanyname.renameappname.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class ProfileViewModel
@Inject
constructor(
    private val createUserUseCase: CreateUserUseCase,
    private val getAllUsersUseCase: GetAllUsersUseCase,
    private val deleteUserUseCase: DeleteUserUseCase,
) : BaseViewModel<ProfileViewModel.UiState, ProfileViewModel.UiEvent>() {

    init {
        loadUserList()
    }

    private fun loadUserList() {
        viewModelScope.launch {
            mutableUiState.value = UiState.Loading
            getAllUsersUseCase().fold(
                onSuccess = { users ->
                    mutableUiState.value = UiState.Success(users = users)
                },
                onFailure = { _ ->
                    mutableUiState.value = UiState.Failure
                },
            )
        }
    }

    override fun initialState(): UiState = UiState.Success(
        users = emptyList(),
    )

    override fun onEvent(event: UiEvent) {
        (uiState.value as? UiState.Success)?.let { currentState ->
            when (event) {
                UiEvent.CreateUserClick -> {
                    val randomNames = listOf(
                        "Alice", "Bob", "Charlie", "David", "Emma",
                        "Frank", "Grace", "Henry", "Isabel", "Jack",
                        "Kate", "Liam", "Mia", "Noah", "Olivia",
                        "Peter", "Quinn", "Rachel", "Sam", "Tara",
                    )
                    val randomName = randomNames.random()
                    val newUser = User(name = randomName)
                    viewModelScope.launch {
                        mutableUiState.value = UiState.Loading
                        createUserUseCase(newUser).fold(
                            onSuccess = { createdUser ->
                                mutableUiState.value = currentState.copy(
                                    users = currentState.users + createdUser,
                                )
                            },
                            onFailure = { _ ->
                                mutableUiState.value = UiState.Failure
                            },
                        )
                    }
                }

                UiEvent.GetAllUsersClick -> loadUserList()
                UiEvent.DeleteAllUsersClick -> {
                    viewModelScope.launch {
                        mutableUiState.value = UiState.Loading
                        currentState.users.forEach { user ->
                            deleteUserUseCase(user)
                        }
                        loadUserList()
                    }
                }
            }
        }
    }

    sealed class UiEvent : BaseUiEvent {
        data object CreateUserClick : UiEvent()
        data object GetAllUsersClick : UiEvent()
        data object DeleteAllUsersClick : UiEvent()
    }

    sealed class UiState : BaseUiState {
        data object Loading : UiState()
        data object Failure : UiState()
        data class Success(val users: List<User>) : UiState()
    }
}
