package ru.toxyxd.feature.home.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.toxyxd.template.uikit.page.PageLayout
import ru.toxyxd.template.uikit.vm.PageViewModel
import java.util.*
import javax.inject.Inject

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun HomeScreen(
    onSecondClicked: () -> Unit,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Home") },
            )
        }
    ) { innerPadding ->
        PageLayout(
            state = viewModel.state,
            onReload = viewModel::reload,
        ) { number ->
            Box(Modifier.padding(innerPadding)) {
                Button(onClick = onSecondClicked) {
                    Text("Go to second screen ($number)")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun HomeSecondScreen(
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Home") },
            )
        }, contentWindowInsets = WindowInsets(0)
    ) { innerPadding ->
        PageLayout(
            state = viewModel.state,
            onReload = viewModel::reload,
        ) { number ->
            Box(Modifier.padding(innerPadding)) {
                Text("You are on second screen ($number)")
            }
        }
    }
}


@HiltViewModel
class HomeScreenViewModel @Inject constructor() : PageViewModel<Int>() {
    init {
        reload()
    }

    override suspend fun load(): Int {
        return Random().nextInt()
    }
}