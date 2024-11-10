package com.renamecompanyname.renameappname.presentation.profile

import androidx.lifecycle.viewModelScope
import com.renamecompanyname.renameappname.domain.model.SomeFetchedData
import com.renamecompanyname.renameappname.domain.model.User
import com.renamecompanyname.renameappname.domain.usecase.CreateUserUseCase
import com.renamecompanyname.renameappname.domain.usecase.DeleteUserUseCase
import com.renamecompanyname.renameappname.domain.usecase.FetchSomeDataUseCase
import com.renamecompanyname.renameappname.domain.usecase.GetAllUsersUseCase
import com.renamecompanyname.renameappname.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class ProfileViewModel
@Inject
constructor(
    private val createUserUseCase: CreateUserUseCase,
    private val getAllUsersUseCase: GetAllUsersUseCase,
    private val deleteUserUseCase: DeleteUserUseCase,
    private val fetchSomeDataUseCase: FetchSomeDataUseCase,
) : BaseViewModel<ProfileViewModel.UiState, ProfileViewModel.UiEvent>() {

    override fun initialState(): UiState = UiState.Success()

    init {
        loadUserList()
        fetchSomeData(isPullToRefresh = false)
    }

    private fun loadUserList() {
        viewModelScope.launch {
            (uiState.value as? UiState.Success)?.let { currentState ->
                mutableUiState.value = currentState.copy(isLoadingUsers = true)
                getAllUsersUseCase().fold(
                    onSuccess = { users ->
                        mutableUiState.value =
                            currentState.copy(users = users, isLoadingUsers = false)
                    },
                    onFailure = { _ ->
                        mutableUiState.value = UiState.Failure
                    },
                )
            }
        }
    }

    private fun fetchSomeData(isPullToRefresh: Boolean) {
        viewModelScope.launch {
            (uiState.value as? UiState.Success)?.let { currentState ->
                mutableUiState.value = currentState.copy(
                    isFetchingData = true,
                    isFetchingDataWithPullToRefresh = isPullToRefresh,
                )
                delay(1000)
                fetchSomeDataUseCase().fold(
                    onSuccess = { data ->
                        mutableUiState.value = currentState.copy(
                            fetchedData = data,
                            isFetchingData = false,
                            isFetchingDataWithPullToRefresh = false,
                        )
                    },
                    onFailure = { _ ->
                        mutableUiState.value = UiState.Failure
                    },
                )
            }
        }
    }

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
                        mutableUiState.value = currentState.copy(isCreatingUser = true)
                        createUserUseCase(newUser).fold(
                            onSuccess = { createdUser ->
                                mutableUiState.value = currentState.copy(
                                    users = currentState.users + createdUser,
                                    isCreatingUser = false,
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
                        mutableUiState.value = currentState.copy(isDeletingUsers = true)
                        currentState.users.forEach { user ->
                            deleteUserUseCase(user)
                        }
                        mutableUiState.value = currentState.copy(isDeletingUsers = false)
                        loadUserList()
                    }
                }

                UiEvent.FetchSomeDataClick -> fetchSomeData(isPullToRefresh = false)
                UiEvent.FetchSomeDataPullToRefresh -> fetchSomeData(isPullToRefresh = true)
            }
        }
    }

    sealed class UiEvent : BaseUiEvent {
        data object CreateUserClick : UiEvent()
        data object GetAllUsersClick : UiEvent()
        data object DeleteAllUsersClick : UiEvent()
        data object FetchSomeDataClick : UiEvent()
        data object FetchSomeDataPullToRefresh : UiEvent()
    }

    sealed class UiState : BaseUiState {
        data object Loading : UiState()
        data object Failure : UiState()
        data class Success(
            val users: List<User> = emptyList(),
            val fetchedData: List<SomeFetchedData> = emptyList(),
            val isCreatingUser: Boolean = false,
            val isLoadingUsers: Boolean = false,
            val isDeletingUsers: Boolean = false,
            val isFetchingData: Boolean = false,
            val isFetchingDataWithPullToRefresh: Boolean = false,
        ) :
            UiState()
    }
}
