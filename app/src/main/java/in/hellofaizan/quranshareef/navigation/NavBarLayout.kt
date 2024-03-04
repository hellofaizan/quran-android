package `in`.hellofaizan.quranshareef.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import `in`.hellofaizan.quranshareef.R
import kotlinx.coroutines.launch

@Composable
fun NavBarHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo Name ETc
        Image(painter = painterResource(R.drawable.islamic), contentDescription = null )
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = R.drawable.applogo_nobg), contentDescription = null, modifier = Modifier.size(40.dp))
            Text(text = "Quran Shareef", style = MaterialTheme.typography.titleSmall)

        }
    }
}

@Composable
fun NavBarBody(
    items: List<NavItems> = NavItemList().items,
    currentRoute: String?,
    onClick: (NavItems) -> Unit
) {
    val selectedItemIndex by remember { mutableIntStateOf(0) }
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    items.forEachIndexed { index, item ->
        NavigationDrawerItem(
            shape = MaterialTheme.shapes.medium,
            label = {
                Text(text = item.title)
            },
            selected = currentRoute == item.route,
            onClick = {
                onClick(item)
            },
            icon = {
                Icon(
                    imageVector = if (index == selectedItemIndex) item.selectedIcon else item.unselectedIcon,
                    contentDescription = item.title
                )
            },
            badge = item.badgeCount?.let { badgeCount ->
                {
                    Text(text = badgeCount.toString())
                }
            },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )
    }
}

@Composable
fun NavBarFooter() {

}