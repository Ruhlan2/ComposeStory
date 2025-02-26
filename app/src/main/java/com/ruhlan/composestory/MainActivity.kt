package com.ruhlan.composestory

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ruhlan.composestory.model.snapList
import com.ruhlan.composestory.story.AppNavHost
import com.ruhlan.composestory.story.StoryItem
import com.ruhlan.composestory.ui.theme.ComposeStoryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeStoryTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        val navController = rememberNavController()
        Log.d("TAG", "MainScreen() called with: innerPadding = $innerPadding")
        AppNavHost(
            modifier = modifier
                .fillMaxSize(),
            navController = navController
        )
    }
}

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Scaffold {
        LazyRow(
            modifier = Modifier.padding(it)
        ) {
            items(items = snapList) { model ->
                StoryItem(
                    modifier = modifier,
                    imageUrl = model.thumbnail,
                    onClick = {
                        navController.navigate("story")
                    }
                )
            }
        }
    }
}