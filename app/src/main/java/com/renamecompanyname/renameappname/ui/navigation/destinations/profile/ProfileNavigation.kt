package com.renamecompanyname.renameappname.ui.navigation.destinations.profile

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.renamecompanyname.renameappname.presentation.profile.EditProfileViewModel
import com.renamecompanyname.renameappname.presentation.profile.ProfileViewModel
import com.renamecompanyname.renameappname.ui.profile.EditProfileScreen
import com.renamecompanyname.renameappname.ui.profile.ProfileScreen
import kotlinx.serialization.Serializable

// Encapsulation 👍
// - Keeps screens logic seperate from Navhost
// - Define extension functions, here, for navigating to the destination, and defining the route (NavGraphBuilder)
// - More good reasons...
// https://developer.android.com/guide/navigation/design/encapsulate


// Route with arguments: use data class, and arguments as parameters with the correct type
// TODO: show example with optional arguments
@Serializable
data class Profile(val id: String)

@Serializable
data class EditProfile(val id: String)

fun NavController.navigateToProfile(id: String) {
    navigate(route = Profile(id = id))
}

fun NavController.navigateToEditProfile(id: String) {
    navigate(route = EditProfile(id = id))
}

fun NavGraphBuilder.profileDestination(
    onNavigateToHome: () -> Unit,
    setProfileScreenFABButtonOnClick: (() -> Unit) -> Unit
) {
    composable<Profile> {
        // The ViewModel as a screen level state holder produces the screen
        // UI state and handles business logic for the HomeScreen
        val viewModel: ProfileViewModel = hiltViewModel()

        // EXAMPLE: vibration haptic feedback onclick
        val haptic = LocalHapticFeedback.current

        // EXAMPLE: setting the onClick of a FAB passed down from the root composable
        LaunchedEffect(Unit) {
            setProfileScreenFABButtonOnClick {
                // EXAMPLE: vibration haptic feedback onclick
                haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)

                // add onclick here...
            }
        }

        ProfileScreen(
            profileUiState = viewModel.uiState.value,
            onNavigateToHome = onNavigateToHome,
        )
    }
}

fun NavGraphBuilder.EditProfileDestination(
    onNavigateToProfile: () -> Unit,
) {
    composable<EditProfile> { navBackStackEntry ->

        val viewModel: EditProfileViewModel = hiltViewModel()

        EditProfileScreen(
            // TODO: fixme
        )
    }
}
