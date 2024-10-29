package com.renamecompanyname.renameappname.ui.navigation.destinations.profile

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.renamecompanyname.renameappname.presentation.profile.EditProfileViewModel
import com.renamecompanyname.renameappname.ui.profile.EditProfileScreen
import kotlinx.serialization.Serializable

@Serializable
internal data class EditProfile(val id: String)

internal fun NavController.navigateToEditProfile(id: String) {
    navigate(route = EditProfile(id = id))
}

internal fun NavGraphBuilder.editProfileDestination(onNavigateToProfile: (id: String) -> Unit) {
    composable<EditProfile> { navBackStackEntry ->
        val editProfile: EditProfile = navBackStackEntry.toRoute() // get arguments from route

        val viewModel: EditProfileViewModel = hiltViewModel()

        EditProfileScreen(
            editProfileUiState = viewModel.uiState.value,
            onNavigateToProfile = { onNavigateToProfile(editProfile.id) },
        )
    }
}
