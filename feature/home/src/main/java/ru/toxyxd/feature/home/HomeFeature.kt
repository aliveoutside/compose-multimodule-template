package ru.toxyxd.feature.home

import ru.toxyxd.feature.core.BottomNavigationCapable
import ru.toxyxd.feature.core.DestNode
import ru.toxyxd.feature.core.NestedFeatureEntry

abstract class HomeFeature : NestedFeatureEntry, BottomNavigationCapable {
    override val startDestination = Routes.MainScreen.url

    override val graphRoute = Routes.NavGraph

    internal object Routes {
        const val NavGraph = "@home"

        val MainScreen = DestNode("home")
        val MainSecondScreen = DestNode("home/second")
    }
}