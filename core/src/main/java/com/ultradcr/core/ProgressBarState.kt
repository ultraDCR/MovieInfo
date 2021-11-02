package com.ultradcr.core

sealed class ProgressBarState{
    object  Loading: ProgressBarState()
    object  Idle: ProgressBarState()
}
