package com.renamecompanyname.renameappname.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.renamecompanyname.renameappname.R
import com.renamecompanyname.renameappname.ui.home.HomeScreenRoute
import com.renamecompanyname.renameappname.ui.theme.RenameTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // style status bar here
        enableEdgeToEdge()
        setContent {

            // An example of how to set a FAB onClick, in a Single Activity App Architecture
            // pass down the setHomeScreenFABButtonOnClick to the necessary screen
            val (homeScreenFABButtonOnClick, setHomeScreenFABButtonOnClick) = remember {
                mutableStateOf<(() -> Unit)?>(
                    null
                )
            }

            Root(homeScreenFabOnClick = homeScreenFABButtonOnClick) {
                HomeScreenRoute(setHomeScreenFABButtonOnClick = setHomeScreenFABButtonOnClick)
            }
        }
    }
}

@Composable
private fun Root(
    modifier: Modifier = Modifier,
    homeScreenFabOnClick: (() -> Unit)?,
    rootContent: @Composable () -> Unit
) {
    RenameTheme {
        Scaffold(
            modifier = modifier.fillMaxSize(),
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    onClick = {
                        homeScreenFabOnClick?.invoke()
                    },
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                ) {
                    Text(
                        text = stringResource(id = R.string.replace_me_text_example),
                        style = MaterialTheme.typography.titleSmall
                    )
                }
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                rootContent()
            }
        }
    }
}


// TODO: add a Preview for the Scaffold / Root composable 
