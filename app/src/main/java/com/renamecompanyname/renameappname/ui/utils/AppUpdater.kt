package com.renamecompanyname.renameappname.ui.utils

import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.appupdate.AppUpdateOptions
import com.google.android.play.core.install.InstallStateUpdatedListener
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.InstallStatus
import com.google.android.play.core.install.model.UpdateAvailability


/**
 * For more information, visit:
 * [In-App Updates Documentation](https://developer.android.com/guide/playcore/in-app-updates/kotlin-java)
 *
 * Example usage in MainActivity.kt:
 *
 * Before the setContent method, you can set up the app update manager like this:
 *
 * ```kotlin
 * val appUpdateManager = AppUpdateManagerFactory.create(applicationContext)
 * checkAndInitiateFlexibleAppUpdate(
 *     appUpdateManager = appUpdateManager,
 *     launcher = registerForActivityResult(
 *         contract = ActivityResultContracts.StartIntentSenderForResult(),
 *         callback = { /* no-op - cancellation */ }
 *     ),
 *     onShowAppUpdater = { isAppUpdaterVisible = true }
 * )
 * ```
 *
 * Call to complete:
 * ```kotlin
 * appUpdateManager.completeUpdate()
 * ```
 */
fun checkAndInitiateFlexibleAppUpdate(
    appUpdateManager: AppUpdateManager,
    launcher: ActivityResultLauncher<IntentSenderRequest>,
    onShowAppUpdater: () -> Unit
) {
    // Returns an intent object that you use to check for an update.
    val appUpdateInfoTask = appUpdateManager.appUpdateInfo

//    val launcher =
//        registerForActivityResult(
//            contract = ActivityResultContracts.StartIntentSenderForResult(),
//            callback = {
//                if (it.resultCode != RESULT_OK) {
//                    // user cancelled or error
//                    // no-op either way
//                }
//            },
//        )

    // Checks that the platform will allow the specified type of update.
    appUpdateInfoTask.addOnSuccessListener { appUpdateInfo ->
        if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE &&
            appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.FLEXIBLE)
        ) {
            // Create a listener to track request state updates.
            val listener =
                InstallStateUpdatedListener { state ->
                    // (Optional) Provide a download progress bar.
//                        if (state.installStatus() == InstallStatus.DOWNLOADING) {
//                            val bytesDownloaded = state.bytesDownloaded()
//                            val totalBytesToDownload = state.totalBytesToDownload()
//                            // Show update progress bar.
//                        }
                    // Log state or install the update.
                    if (state.installStatus() == InstallStatus.DOWNLOADED) {
                        // After the update is downloaded, show a notification
                        // and request user confirmation to restart the app.
                        onShowAppUpdater()
                    }
                }

            // Before starting an update, register a listener for updates.
            appUpdateManager.registerListener(listener)

            // Start an update.
            appUpdateManager.startUpdateFlowForResult(
                // Pass the intent that is returned by 'getAppUpdateInfo()'.
                appUpdateInfo,
                // an activity result launcher registered via registerForActivityResult
                launcher,
                AppUpdateOptions.newBuilder(AppUpdateType.FLEXIBLE).build(),
            )

            // When status updates are no longer needed, unregister the listener.
//                    appUpdateManager.unregisterListener(listener)

            // If the update is downloaded but not installed,
            // notify the user to complete the update.
            // For when user downloads and restarts app without allowing update
        } else if (appUpdateInfo.installStatus() == InstallStatus.DOWNLOADED) {
            onShowAppUpdater()
        }

        // If the update is downloaded but not installed,
        // notify the user to complete the update.
        if (appUpdateInfo.installStatus() == InstallStatus.DOWNLOADED) {
            onShowAppUpdater()
        }
    }
}