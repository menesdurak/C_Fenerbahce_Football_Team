package com.menesdurak.fenerbahce_football_team

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.menesdurak.fenerbahce_football_team.data.Player
import com.menesdurak.fenerbahce_football_team.data.players
import com.menesdurak.fenerbahce_football_team.ui.theme.Fenerbahce_Football_TeamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Fenerbahce_Football_TeamTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    FenerbahceApp()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FenerbahceApp() {
    Scaffold(
        topBar = {
            FenerbahceTopAppBar()
        }
    ) {
        LazyColumn(modifier = Modifier.background(MaterialTheme.colors.background)) {
            items(players) {
                PlayerItem(player = it)
            }
        }
    }
}

@Composable
fun FenerbahceTopAppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.secondary),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = modifier
                .size(64.dp)
                .padding(8.dp),
            painter = painterResource(id = R.drawable.fenerbahce),
            contentDescription = "FenerbahceLogo"
        )
        Text(
            text = "Fenerbahce Football Team",
            style = MaterialTheme.typography.h6
        )
    }
}

@Composable
fun PlayerItem(modifier: Modifier = Modifier, player: Player) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        elevation = 4.dp,
        modifier = modifier.padding(8.dp)
    ) {
        Column(
            modifier = Modifier.animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                PlayerImage(playerImage = player.imageResourceId)
                PlayerName(playerName = player.name)
                Spacer(modifier = Modifier.weight(1f))
                PlayerItemButton(expanded = expanded, onClick = { expanded = !expanded })
            }
            if (expanded) {
                PlayerInfo(playerAge = player.age, playerPosition = player.position)
            }
        }
    }
}

@Composable
fun PlayerImage(@DrawableRes playerImage: Int, modifier: Modifier = Modifier) {
    Image(
        modifier = modifier
            .size(128.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(50)),
        painter = painterResource(id = playerImage),
        contentDescription = "Player Image"
    )
}

@Composable
fun PlayerName(@StringRes playerName: Int, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = stringResource(id = playerName),
            style = MaterialTheme.typography.h5,
            modifier = modifier.padding(8.dp).wrapContentSize(align = Alignment.Center)
        )
    }
}

@Composable
fun PlayerInfo(
    playerAge: Int,
    @StringRes playerPosition: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp, 8.dp, 16.dp, 16.dp)) {
        Text(
            text = stringResource(id = playerPosition),
            style = MaterialTheme.typography.h6
        )
        Text(
            text = playerAge.toString(),
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
private fun PlayerItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            tint = MaterialTheme.colors.secondary,
            contentDescription = "Show more info"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Fenerbahce_Football_TeamTheme {
        FenerbahceApp()
    }
}