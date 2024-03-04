package `in`.hellofaizan.quranshareef.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*

class NavItemList {
    val items = listOf(
        NavItems(
            title = "Home",
            route = Screens.Home.route,
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
        ),
        NavItems(
            title = "English Quran",
            route = Screens.Quran.route,
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
        ),
        NavItems(
            title = "Bookmarks",
            route = Screens.Bookmarks.route,
            selectedIcon = Icons.Filled.Favorite,
            unselectedIcon = Icons.Outlined.FavoriteBorder,
            badgeCount = 5
        ),
        NavItems(
            title = "Settings",
            route = Screens.Settings.route,
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
        ),
        NavItems(
            title = "About Us",
            route = Screens.About.route,
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person,
        ),
        NavItems(
            title = "Share",
            route = "share",
            selectedIcon = Icons.Filled.Share,
            unselectedIcon = Icons.Outlined.Share,
        ),

    )
}