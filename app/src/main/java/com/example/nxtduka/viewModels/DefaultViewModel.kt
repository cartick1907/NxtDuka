package com.example.nxtduka.viewModels

import android.os.CountDownTimer
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class DefaultViewModel() :ViewModel() {

    var showConfirmation by mutableStateOf(false)
    var showVerification by mutableStateOf(false)
    var showPassword by mutableStateOf(false)




}