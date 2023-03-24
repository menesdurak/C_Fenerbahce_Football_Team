package com.menesdurak.fenerbahce_football_team.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Player(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    val age: Int,
    @StringRes val position: Int
)
