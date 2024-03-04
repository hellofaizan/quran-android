package `in`.hellofaizan.quranshareef.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import `in`.hellofaizan.quranshareef.screens.AboutActivity
import `in`.hellofaizan.quranshareef.screens.BookmarkActivity
import `in`.hellofaizan.quranshareef.screens.HomeActivity
import `in`.hellofaizan.quranshareef.screens.QuranActivity
import `in`.hellofaizan.quranshareef.screens.SettingActivity

@Composable
fun SetUpNavGraph(
    navController: NavHostController,
    innerPadding: PaddingValues
) {
    NavHost(navController = navController, startDestination = Screens.Home.route) {
        composable(Screens.Home.route) {
            HomeActivity(innerPadding = innerPadding)
        }
        composable(Screens.Quran.route) {
            QuranActivity(innerPadding = innerPadding)
        }
        composable(Screens.Bookmarks.route) {
            BookmarkActivity(innerPadding = innerPadding)
        }
        composable(Screens.Settings.route) {
            SettingActivity(innerPadding = innerPadding)
        }
        composable(Screens.About.route) {
            AboutActivity(innerPadding = innerPadding)
        }
    }
}