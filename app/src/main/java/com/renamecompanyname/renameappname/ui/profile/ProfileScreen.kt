package com.renamecompanyname.renameappname.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
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
    onFetchSomeDataClick: () -> Unit,
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

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .verticalScroll(rememberScrollState()),
        ) {
            Text(
                modifier = Modifier,
                text = uiState.fetchedData,
                style = MaterialTheme.typography.bodySmall,
            )
        }

        Spacer(modifier = Modifier.size(16.dp))

        CustomButton(text = "Create User", onClick = onCreateUserClick)

        Spacer(modifier = Modifier.size(16.dp))

        CustomButton(text = "Get All Users", onClick = onGetAllUsersClick)

        Spacer(modifier = Modifier.size(16.dp))

        CustomButton(text = "Delete All Users", onClick = onDeleteAllUsersClick)

        Spacer(modifier = Modifier.size(16.dp))

        CustomButton(text = "Fetch some data", onClick = onFetchSomeDataClick)

        Spacer(modifier = Modifier.size(56.dp))

        CustomButton(
            text = stringResource(id = R.string.navigate_to_edit_profile_btn_text),
            onClick = onNavigateToEditProfile,
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
            contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
        )
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
                    onFetchSomeDataClick = {},
                )
            }
        }
    }
}
