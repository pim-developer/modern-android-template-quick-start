package com.renamecompanyname.renameappname.ui.profile

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.renamecompanyname.renameappname.presentation.profile.ProfileViewModel
import com.renamecompanyname.renameappname.ui.common.Greeting
import com.renamecompanyname.renameappname.ui.theme.RenameTheme

@Composable
fun ProfileScreen(
    profileUiState: ProfileViewModel.ProfileUiState,
    onNavigateToHome: () -> Unit,
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(top = 16.dp, start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Greeting(name = profileUiState.placeHolder)
    }
}

@Composable
fun profileScreenFABButton(onClick: (() -> Unit)?): @Composable() (() -> Unit)? {
    TODO("Not yet implemented")
}


@Preview
@Composable
fun PreviewProfileScreen() {
    RenameTheme {
        Surface {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {


            }
        }
    }
}
