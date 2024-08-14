package com.renamecompanyname.renameappname.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.renamecompanyname.renameappname.R
import com.renamecompanyname.renameappname.presentation.home.HomeViewModel
import com.renamecompanyname.renameappname.ui.theme.RenameTheme

@Composable
fun HomeScreenRoute(setHomeScreenFABButtonOnClick: (() -> Unit) -> Unit) {
    val viewModel: HomeViewModel = hiltViewModel()

    // EXAMPLE: vibration haptic feedback onclick
    val haptic = LocalHapticFeedback.current

    // EXAMPLE: setting the onClick of a FAB passed down from the root composable
    LaunchedEffect(Unit) {
        setHomeScreenFABButtonOnClick {

            // EXAMPLE: vibration haptic feedback onclick
            haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove)
        }
    }

    HomeScreen(greetingName = "Android")
}

@Composable
private fun HomeScreen(
    greetingName: String
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(top = 16.dp, start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Greeting(name = stringResource(id = R.string.replace_me_greeting_text, greetingName))
    }
}

@Composable
private fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        modifier = modifier,
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.onBackground
    )
}


//@PreviewScreenSizes
@Preview
@Composable
private fun PreviewNewEventDialog() {
    RenameTheme {
        Surface {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                HomeScreen(greetingName = "Android")
            }
        }
    }
}
