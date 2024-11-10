package com.renamecompanyname.renameappname.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navigation
import com.renamecompanyname.renameappname.ui.navigation.NestedGraphs.ProfileGraph
import com.renamecompanyname.renameappname.ui.navigation.destinations.home.homeDestination
import com.renamecompanyname.renameappname.ui.navigation.destinations.home.navigateToHome
import com.renamecompanyname.renameappname.ui.navigation.destinations.profile.Profile
import com.renamecompanyname.renameappname.ui.navigation.destinations.profile.editProfileDestination
import com.renamecompanyname.renameappname.ui.navigation.destinations.profile.navigateToEditProfile
import com.renamecompanyname.renameappname.ui.navigation.destinations.profile.navigateToProfile
import com.renamecompanyname.renameappname.ui.navigation.destinations.profile.profileDestination
import kotlinx.serialization.Serializable

// In this file we define the navigation graph for the app.
// We also organise nested navigation classes in this file, see NestedGraphs.
//
// https://developer.android.com/develop/ui/compose/navigation
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
        startDestination = ProfileGraph(""),
    ) {
        homeDestination(
            onNavigateToProfile = { profileId ->
                navController.navigateToProfileGraph(profileId)
            },
            setHomeScreenFABOnClick = setHomeScreenFABButtonOnClick,
        )

        navigation<ProfileGraph>(startDestination = Profile(id = "this_will_be_ignored")) {
            profileDestination(
                onNavigateToHome = {
                    navController.navigateToHome()
                },
                onNavigateToEditProfile = {
                    navController.navigateToEditProfile(it)
                },
                setProfileScreenFABOnClick = setProfileScreenFABButtonOnClick,
            )

            editProfileDestination(
                onNavigateToProfile = {
                    navController.navigateToProfile(it)
                },
            )
        }
    }
}

internal sealed class NestedGraphs {
    @Serializable
    internal data class ProfileGraph(val id: String = "")
}

internal fun NavController.navigateToProfileGraph(id: String) {
    navigate(route = ProfileGraph(id = id))
}
