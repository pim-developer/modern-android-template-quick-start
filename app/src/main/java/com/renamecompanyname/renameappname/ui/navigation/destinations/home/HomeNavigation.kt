package com.renamecompanyname.renameappname.ui.navigation.destinations.home

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.renamecompanyname.renameappname.presentation.home.HomeViewModel
import com.renamecompanyname.renameappname.ui.home.HomeScreen
import kotlinx.serialization.Serializable

// Encapsulation 👍
// - Keeps screens logic separate from NavHost
// - Define extension functions, here, for navigating to the destination, and defining the route (NavGraphBuilder)
// - More good reasons...
// https://developer.android.com/guide/navigation/design/encapsulate

// Route without arguments: use object
@Serializable
object Home

fun NavController.navigateToHome() {
    navigate(route = Home)
}

fun NavGraphBuilder.homeDestination(
    onNavigateToProfile: (profileId: String) -> Unit,
    setHomeScreenFABOnClick: (() -> Unit) -> Unit,
) {
    composable<Home> {
        // The ViewModel as a screen level state holder produces the screen
        // UI state and handles business logic for the HomeScreen
        val viewModel: HomeViewModel = hiltViewModel()

        // EXAMPLE: vibration haptic feedback onclick
        val haptic = LocalHapticFeedback.current

        // EXAMPLE: setting the onClick of a FAB passed down from the root composable
        LaunchedEffect(Unit) {
            setHomeScreenFABOnClick {
                // EXAMPLE: vibration haptic feedback onclick
                haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)

                // add onclick here...
                onNavigateToProfile("id")
            }
        }

        val uiState = viewModel.uiState.collectAsState()

        when (val state = uiState.value) {
            HomeViewModel.UiState.Success -> HomeScreen(
                uiState = state,
                onNavigateToProfile = onNavigateToProfile,
            )
        }
    }
}
