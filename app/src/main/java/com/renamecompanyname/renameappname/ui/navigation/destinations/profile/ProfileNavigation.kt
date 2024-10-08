package com.renamecompanyname.renameappname.ui.navigation.destinations.profile

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.renamecompanyname.renameappname.presentation.profile.ProfileViewModel
import com.renamecompanyname.renameappname.ui.profile.ProfileScreen
import kotlinx.serialization.Serializable

// Encapsulation 👍
// - Keeps screens logic separate from NavHost
// - Define extension functions, here, for navigating to the destination, and defining the route (NavGraphBuilder)
// - More good reasons...
// https://developer.android.com/guide/navigation/design/encapsulate

// Route with arguments: use data class, and arguments as parameters with the correct type
@Serializable
internal data class Profile(val id: String)

internal fun NavController.navigateToProfile(id: String) {
    navigate(route = Profile(id = id))
}

internal fun NavGraphBuilder.profileDestination(
    onNavigateToHome: () -> Unit,
    onNavigateToEditProfile: (id: String) -> Unit,
    setProfileScreenFABOnClick: (() -> Unit) -> Unit
) {
    composable<Profile> { navBackStackEntry ->
        val profileId = navBackStackEntry.toRoute<Profile>().id

        // The ViewModel as a screen level state holder produces the screen
        // UI state and handles business logic for the HomeScreen
        val viewModel: ProfileViewModel = hiltViewModel()

        // EXAMPLE: vibration haptic feedback onclick
        val haptic = LocalHapticFeedback.current


        // EXAMPLE: setting the onClick of a FAB passed down from the root composable
        LaunchedEffect(Unit) {
            setProfileScreenFABOnClick {
                // EXAMPLE: vibration haptic feedback onclick
                haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)

                // add onclick here...
                onNavigateToHome()
            }
        }

        ProfileScreen(
            profileUiState = viewModel.uiState.value,
            onNavigateToEditProfile = { onNavigateToEditProfile(profileId) }
        )
    }
}