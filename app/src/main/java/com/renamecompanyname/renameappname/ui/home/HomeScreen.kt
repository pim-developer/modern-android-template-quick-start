package com.renamecompanyname.renameappname.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.renamecompanyname.renameappname.R
import com.renamecompanyname.renameappname.presentation.home.HomeViewModel
import com.renamecompanyname.renameappname.ui.common.Greeting
import com.renamecompanyname.renameappname.ui.theme.RenameTheme

@Composable
fun HomeScreen(
    homeUiState: HomeViewModel.HomeUiState,
    onNavigateToProfile: (profileId: String) -> Unit,
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(top = 16.dp, start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Greeting(
            name = stringResource(
                id = R.string.replace_me_greeting_text,
                homeUiState.helloWorld
            )
        )
    }
}

@Composable
fun HomeScreenFABButton(onClick: (() -> Unit)?): @Composable() (() -> Unit)? {
    TODO("Not yet implemented")
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
                HomeScreen(homeUiState = HomeViewModel.HomeUiState(), onNavigateToProfile = {})
            }
        }
    }
}
