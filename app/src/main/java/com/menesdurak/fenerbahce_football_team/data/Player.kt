package com.menesdurak.fenerbahce_football_team.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.menesdurak.fenerbahce_football_team.R

data class Player(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    val age: Int,
    @StringRes val position: Int
)

val players = listOf(
    Player(R.drawable.altay_bayindir, R.string.altay_bayindir, 24, R.string.goalkeeper),
    Player(R.drawable.lincoln_henrique, R.string.lincoln_henrique, 24, R.string.defence),
    Player(R.drawable.attila_szalai, R.string.attila_szalai, 25, R.string.defence),
    Player(R.drawable.samet_akaydin, R.string.samet_akaydin, 29, R.string.defence),
    Player(R.drawable.osayi_samuel, R.string.brigh_osayi_samuel, 25, R.string.defence),
    Player(R.drawable.arao, R.string.willian_arao, 31, R.string.midfielder),
    Player(R.drawable.ismail_y_ksek, R.string.ismail_yuksek, 24, R.string.midfielder),
    Player(R.drawable.arda_guler, R.string.arda_guler, 18, R.string.midfielder),
    Player(R.drawable.diego_rossi, R.string.diego_rossi, 25, R.string.forward),
    Player(R.drawable.emre_mor, R.string.emre_mor, 25, R.string.forward),
    Player(R.drawable.enner_valencia, R.string.enner_valencia, 33, R.string.forward)
)


