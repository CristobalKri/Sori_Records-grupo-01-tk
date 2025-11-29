package com.example.sori_records_grupo01tk.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sori_records_grupo01tk.viewmodel.BillboardViewModel
import com.example.sori_records_grupo01tk.viewmodel.EstadoViewModel
import com.example.sori_records_grupo01tk.viewmodel.LoginViewModel
import kotlinx.coroutines.Job

@Composable
fun DrawerContent(
    modifier: Modifier = Modifier,
    onNavigateToRegistro: () -> Unit,
    onNavigateToResumen: () -> Unit,
    onNavigateToHomeScreen: () -> Unit,
    onNavigateToCatalagoV: () -> Unit,
    onNavigateToCatalagoCD: () -> Unit,
    onNavigateToCatalagoC: () -> Unit,
    onNavigateToCarritoScreen: () -> Unit,
    onNavigateToLoginScreen: () -> Unit,
    onNavigateToPerfilScreen: () -> Unit,
    loginviewModel: LoginViewModel = viewModel(),
    onNavigateToAdminScreen: () -> Unit,
    onNavigateToLogoutScreen: () -> Unit,
    onNavigateToBillboardScreen: () -> Unit,
    billboardViewModel: BillboardViewModel? = null
) {

    val estadoViewModel: EstadoViewModel = viewModel()
    val isLoggedIn = loginviewModel.booleanValue.collectAsState()

    val state = estadoViewModel.activo.collectAsState()



    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ){
        Text(
            text = "Sori Records",
            modifier = Modifier.padding(16.dp),

            )
    }

    HorizontalDivider()

    NavigationDrawerItem(

        label = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Home, contentDescription = "Home",
                    modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text("Home")
            }
        },
        selected = false,
        onClick = {
            onNavigateToHomeScreen()

        }
    )

    Spacer(modifier = Modifier.height(8.dp))

    if (!isLoggedIn.value) {


        NavigationDrawerItem(
            label = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Person, contentDescription = "Login",
                        modifier = Modifier.size(20.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Login")
                }
            },
            selected = false,
            onClick = { onNavigateToLoginScreen() }
        )

        Spacer(modifier = Modifier.height(8.dp))

    } else {

        NavigationDrawerItem(
            label = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.AccountCircle, contentDescription = "Perfil",
                        modifier = Modifier.size(20.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Perfil")
                }
            },
            selected = false,
            onClick = { onNavigateToPerfilScreen() }
        )

        Spacer(modifier = Modifier.height(8.dp))

    }

    NavigationDrawerItem(
        label = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.ShoppingCart, contentDescription = "Carrito",
                    modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text("Carrito")
            }
        },
        selected = false,
        onClick = { onNavigateToCarritoScreen() }
    )

    NavigationDrawerItem(
        label = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.MailOutline, contentDescription = "Billboard")
                Spacer(modifier = Modifier.width(8.dp))
                Text("Billboard")
            }
        },
        selected = false,
        onClick = { onNavigateToBillboardScreen() }
    )

    NavigationDrawerItem(
        label = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Star, contentDescription = "Vinilos",
                    modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text("Vinilos")
            }
        },
        selected = false,
        onClick = { onNavigateToCatalagoV() }
    )

    Spacer(modifier = Modifier.height(8.dp))

    NavigationDrawerItem(
        label = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Star, contentDescription = "CDs",
                    modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text("CDs")
            }
        },
        selected = false,
        onClick = { onNavigateToCatalagoCD() }
    )

    Spacer(modifier = Modifier.height(8.dp))

    NavigationDrawerItem(
        label = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Star, contentDescription = "Cassettes",
                    modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text("Cassettes")
            }
        },
        selected = false,
        onClick = { onNavigateToCatalagoC() }
    )

    Spacer(modifier = Modifier.height(8.dp))

    NavigationDrawerItem(
        label = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Settings, contentDescription = "Acciones Admin",
                    modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text("Acciones Admin")
            }
        },
        selected = false,
        onClick = { onNavigateToAdminScreen() }
    )

    Spacer(modifier = Modifier.height(8.dp))

    if (isLoggedIn.value) {

        NavigationDrawerItem(
            label = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.ExitToApp, contentDescription = "Logout",
                        modifier = Modifier.size(20.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Logout")
                }
            },
            selected = false,
            onClick = {
                loginviewModel.saveBoolean(false)
                onNavigateToLogoutScreen()
            }
        )
    }
}

