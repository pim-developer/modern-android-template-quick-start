package com.renamecompanyname.renameappname.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.renamecompanyname.renameappname.R
import com.renamecompanyname.renameappname.presentation.profile.ProfileViewModel
import com.renamecompanyname.renameappname.ui.common.CustomButton
import com.renamecompanyname.renameappname.ui.theme.RenameTheme

@Composable
fun ProfileScreen(
    uiState: ProfileViewModel.UiState.Success,
    onCreateUserClick: () -> Unit,
    onGetAllUsersClick: () -> Unit,
    onDeleteAllUsersClick: () -> Unit,
    onNavigateToEditProfile: () -> Unit,
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(top = 16.dp, start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        uiState.users.forEach {
            Text(
                modifier = Modifier,
                text = "name: ${it.name}, id: ${it.id}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onBackground,
            )
        }

        Spacer(modifier = Modifier.size(16.dp))

        CustomButton(text = "Create User") {
            onCreateUserClick()
        }

        Spacer(modifier = Modifier.size(16.dp))

        CustomButton(text = "Get All Users") {
            onGetAllUsersClick()
        }

        Spacer(modifier = Modifier.size(16.dp))

        CustomButton(text = "Delete All Users") {
            onDeleteAllUsersClick()
        }

        Spacer(modifier = Modifier.size(48.dp))

        CustomButton(text = stringResource(id = R.string.navigate_to_edit_profile_btn_text)) {
            onNavigateToEditProfile()
        }
    }
}

@Composable
fun ProfileScreenFABButton(onClick: () -> Unit) {
    ExtendedFloatingActionButton(
        contentColor = MaterialTheme.colorScheme.background,
        containerColor = MaterialTheme.colorScheme.onBackground,
        onClick = onClick,
    ) {
        Text(text = stringResource(id = R.string.fab_text_navigate_to_home))
    }
}

@Preview
@Composable
fun PreviewProfileScreen() {
    RenameTheme {
        Surface {
            Column(
                modifier =
                Modifier
                    .fillMaxSize(),
            ) {
                ProfileScreen(
                    uiState = ProfileViewModel.UiState.Success(users = emptyList()),
                    onCreateUserClick = { },
                    onGetAllUsersClick = { },
                    onDeleteAllUsersClick = { },
                    onNavigateToEditProfile = {},
                )
            }
        }
    }
}
