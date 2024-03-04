package `in`.hellofaizan.quranshareef.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class NavItems(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val route: String,
    val badgeCount: Int? = null
)
