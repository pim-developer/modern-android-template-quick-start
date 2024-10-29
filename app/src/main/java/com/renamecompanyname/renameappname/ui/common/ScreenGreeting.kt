package com.renamecompanyname.renameappname.ui.common

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import com.renamecompanyname.renameappname.R

@Composable
fun ScreenGreeting(screenName: String, modifier: Modifier = Modifier) {
    val annotatedString =
        buildAnnotatedString {
            append(stringResource(id = R.string.screen_greeting_text, ""))
            val startIndex = length // Remember where the screenName will be inserted
            append(screenName)
            val endIndex = length // Ending position of the screenName
            addStyle(
                style = SpanStyle(color = Color.Yellow),
                start = startIndex,
                end = endIndex,
            )
        }

    Text(
        text = annotatedString,
        modifier = modifier,
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.onBackground,
    )
}
