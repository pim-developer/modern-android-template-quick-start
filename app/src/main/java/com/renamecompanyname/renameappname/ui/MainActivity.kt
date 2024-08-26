package com.renamecompanyname.renameappname.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.renamecompanyname.renameappname.ui.home.HomeScreenFABButton
import com.renamecompanyname.renameappname.ui.navigation.NavigationHost
import com.renamecompanyname.renameappname.ui.navigation.destinations.home.Home
import com.renamecompanyname.renameappname.ui.navigation.destinations.profile.Profile
import com.renamecompanyname.renameappname.ui.profile.ProfileScreenFABButton
import com.renamecompanyname.renameappname.ui.theme.RenameTheme
import dagger.hilt.android.AndroidEntryPoint

// The only Activity in this App (if using Single-Activity Architecture)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Style the status bar here.
        // This by default expands the app's colors to the bottom and top status bar
        // for a full-screen effect.
        enableEdgeToEdge()

        setContent {

            // An example of how to set a FAB onClick, in a Single Activity App Architecture
            // pass down the setHomeScreenFABButtonOnClick to the necessary screen.
            val (homeScreenFABButtonOnClick, setHomeScreenFABButtonOnClick) = remember {
                mutableStateOf<(() -> Unit)?>(
                    null
                )
            }

            val (profileScreenFABButtonOnClick, setProfileScreenFABButtonOnClick) = remember {
                mutableStateOf<(() -> Unit)?>(
                    null
                )
            }

            val navController = rememberNavController()

            RootComposable(
                floatingActionButton = FloatingActionButtonHandler(
                    currentDestination = navController.currentDestination,
                    homeScreenFABButtonOnClick = homeScreenFABButtonOnClick,
                    profileScreenFABButtonOnClick = profileScreenFABButtonOnClick
                ),
            ) { scaffoldInnerPadding ->
                NavigationHost(
                    modifier = Modifier.padding(scaffoldInnerPadding),
                    navController = navController,
                    setHomeScreenFABButtonOnClick = setHomeScreenFABButtonOnClick,
                    setProfileScreenFABButtonOnClick = setProfileScreenFABButtonOnClick
                )
            }
        }
    }
}

@Composable
private fun RootComposable(
    modifier: Modifier = Modifier,
    floatingActionButton: @Composable (() -> Unit)?,
    rootContent: @Composable (scaffoldInnerPadding: PaddingValues) -> Unit
) {
    RenameTheme {
        Scaffold(
            modifier = modifier.fillMaxSize(),
            floatingActionButton = {
                floatingActionButton?.invoke()
            }
        ) { innerPadding ->
            rootContent(innerPadding)
        }
    }
}

@Composable
private fun FloatingActionButtonHandler(
    currentDestination: Any?,
    homeScreenFABButtonOnClick: (() -> Unit)?,
    profileScreenFABButtonOnClick: (() -> Unit)?,
): @Composable (() -> Unit)? {
    // fixme: add FAB

    return when (currentDestination) {
        is Home -> {
            HomeScreenFABButton(onClick = homeScreenFABButtonOnClick)
        }

        is Profile -> {
            ProfileScreenFABButton(onClick = profileScreenFABButtonOnClick)
        }

        else -> null
    }
}

// TODO: add a Preview for the Scaffold / Root composable 
