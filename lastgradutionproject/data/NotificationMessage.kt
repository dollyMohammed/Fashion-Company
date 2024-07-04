package com.example.lastgradutionproject.data

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.lastgradutionproject.FbviewModel

@Composable
fun NotificationMessage(va:FbviewModel){
    val notifyState = va.popNotification.value
    val notifymessage = notifyState?.getContentOrNull()
    if (notifymessage != null)
        Toast.makeText(LocalContext.current,notifymessage,Toast.LENGTH_SHORT).show()

}