package com.renamecompanyname.renameappname.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.renamecompanyname.renameappname.R
import com.renamecompanyname.renameappname.presentation.home.HomeViewModel
import com.renamecompanyname.renameappname.ui.common.ScreenGreeting
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
        ScreenGreeting(
            screenName = homeUiState.screenName
        )
    }
}

@Composable
fun HomeScreenFABButton(onClick: () -> Unit) {
    ExtendedFloatingActionButton(
        contentColor = MaterialTheme.colorScheme.background,
        containerColor = MaterialTheme.colorScheme.onBackground,
        onClick = onClick
    ) {
        Text(text = stringResource(id = R.string.fab_text_navigate_to_profile))
    }
}

//@PreviewScreenSizes
@Preview
@Composable
private fun PreviewHomeScreen() {
    RenameTheme {
        Surface {
            Scaffold(
                modifier = Modifier
                    .fillMaxSize(),
                floatingActionButton = {
                    HomeScreenFABButton {

                    }
                }
            ) { innerPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    HomeScreen(homeUiState = HomeViewModel.HomeUiState(), onNavigateToProfile = {})
                }
            }
        }
    }
}
