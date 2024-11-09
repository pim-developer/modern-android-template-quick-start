package com.renamecompanyname.renameappname.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.renamecompanyname.renameappname.R
import com.renamecompanyname.renameappname.presentation.profile.EditProfileViewModel
import com.renamecompanyname.renameappname.ui.common.CustomButton
import com.renamecompanyname.renameappname.ui.common.ScreenGreeting
import com.renamecompanyname.renameappname.ui.theme.RenameTheme

@Composable
fun EditProfileScreen(
    editProfileUiState: EditProfileViewModel.EditProfileState,
    onNavigateToProfile: () -> Unit,
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(top = 16.dp, start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ScreenGreeting(screenName = editProfileUiState.screenName)

        Spacer(modifier = Modifier.size(16.dp))

        CustomButton(
            text = stringResource(id = R.string.navigate_to_profile_btn_text),
            onClick = onNavigateToProfile,
        )
    }
}

@Preview
@Composable
fun PreviewEditProfileScreen() {
    RenameTheme {
        Surface {
            Column(
                modifier =
                Modifier
                    .background(color = MaterialTheme.colorScheme.background)
                    .fillMaxSize(),
            ) {
                EditProfileScreen(editProfileUiState = EditProfileViewModel.EditProfileState()) {
                }
            }
        }
    }
}
