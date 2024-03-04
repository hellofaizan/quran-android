package `in`.hellofaizan.quranshareef.navigation

sealed class Screens(val route: String) {
    data object Home : Screens("home")
    data object Quran : Screens("quran")
    data object Bookmarks : Screens("bookmarks")
    data object Settings : Screens("settings")
    data object About : Screens("about")
    data object Share : Screens("share")
}