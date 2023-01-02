package ru.toxyxd.feature.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable
import ru.toxyxd.feature.core.Destinations
import ru.toxyxd.feature.core.NavigationEntry
import ru.toxyxd.feature.home.ui.HomeScreen
import ru.toxyxd.feature.home.ui.HomeSecondScreen
import javax.inject.Inject

class HomeFeatureImpl @Inject constructor() : HomeFeature() {
    override val bottomNavigationEntry =
        NavigationEntry(
            route = Routes.NavGraph,
            name = R.string.home,
            icon = { Icons.Rounded.Home }
        )

    @OptIn(ExperimentalAnimationApi::class)
    override fun NavGraphBuilder.buildGraph(
        navController: NavHostController,
        destinations: Destinations
    ) {
        composable(Routes.MainScreen.url) {
            HomeScreen(
                onSecondClicked = {
                    navController.navigate(
                        Routes.MainSecondScreen.url
                    )
                }
            )
        }

        composable(Routes.MainSecondScreen.url) {
            HomeSecondScreen()
        }
    }
}