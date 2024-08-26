package com.renamecompanyname.renameappname.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.renamecompanyname.renameappname.ui.navigation.destinations.home.Home
import com.renamecompanyname.renameappname.ui.navigation.destinations.home.homeDestination
import com.renamecompanyname.renameappname.ui.navigation.destinations.home.navigateToHome
import com.renamecompanyname.renameappname.ui.navigation.destinations.profile.navigateToProfile
import com.renamecompanyname.renameappname.ui.navigation.destinations.profile.profileDestination


@Composable
fun NavigationHost(
    modifier: Modifier,
    navController: NavHostController,
    setHomeScreenFABButtonOnClick: (() -> Unit) -> Unit,
    setProfileScreenFABButtonOnClick: (() -> Unit) -> Unit,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Home
    ) {
        homeDestination(
            onNavigateToProfile = { profileId ->
                navController.navigateToProfile(profileId)
            },
            setHomeScreenFABButtonOnClick = setHomeScreenFABButtonOnClick
        )

        profileDestination(
            onNavigateToHome = {
                navController.navigateToHome()
            },
            setProfileScreenFABButtonOnClick = setProfileScreenFABButtonOnClick
        )
    }
}