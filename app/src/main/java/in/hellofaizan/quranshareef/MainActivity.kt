package `in`.hellofaizan.quranshareef

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import `in`.hellofaizan.quranshareef.navigation.NavBarBody
import `in`.hellofaizan.quranshareef.navigation.NavBarHeader
import `in`.hellofaizan.quranshareef.navigation.NavItemList
import `in`.hellofaizan.quranshareef.navigation.SetUpNavGraph
import `in`.hellofaizan.quranshareef.ui.theme.QuranShareefTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuranShareefTheme {
                // top navigation bar
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                    val scope = rememberCoroutineScope()
                    val navController = rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentRoute = navBackStackEntry?.destination?.route
                    val context = LocalContext.current
                    ModalNavigationDrawer(
                        drawerContent = {
                            // drawer content
                            ModalDrawerSheet {
                                NavBarHeader()
                                Spacer(modifier = Modifier.padding(16.dp))
                                NavBarBody( items = NavItemList().items, currentRoute = currentRoute, onClick = {
                                    if (it.route == "share") {
                                        // share app intent
                                        Toast.makeText(context, "Share App", Toast.LENGTH_SHORT).show()
                                    } else {
                                        navController.navigate(it.route) {
                                            popUpTo(navController.graph.startDestinationId)
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    }

                                    scope.launch {
                                        drawerState.close()
                                    }
                                })
                                // NavBarFooter()
                            }
                        },
                        drawerState = drawerState,
                    ) {
                        // content
                        Scaffold(
                            topBar = {
                                    TopAppBar(
                                    title = {
                                        Text(text = "Quran Shareef")
                                            },
                                    navigationIcon = {
                                        IconButton(onClick = {
                                            scope.launch {
                                                drawerState.open()
                                            }
                                        }) {
                                            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                                        }
                                    }
                                )
                            }
                        ) {innerPadding ->
                            SetUpNavGraph(navController = navController, innerPadding = innerPadding)
                        }
                    }
                }
            }
        }
    }
}
