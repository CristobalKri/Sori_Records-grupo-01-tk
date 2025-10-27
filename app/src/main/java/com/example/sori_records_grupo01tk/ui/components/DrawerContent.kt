package com.example.sori_records_grupo01tk.ui.components

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sori_records_grupo01tk.viewmodel.EstadoViewModel
import com.example.sori_records_grupo01tk.viewmodel.LoginViewModel

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
    loginviewModel: LoginViewModel = viewModel()
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
            Text(
                text = "Home",
                modifier = Modifier.padding(16.dp)
            )
        },
        selected = false,
        onClick = {
            onNavigateToHomeScreen()

        }
    )

    Spacer(modifier = Modifier.height(4.dp))

    if (!isLoggedIn.value) {


        NavigationDrawerItem(
            label = {
                Text(
                    text = "Login",
                    modifier = Modifier.padding(16.dp)
                )
            },
            selected = false,
            onClick = { onNavigateToLoginScreen() }
        )

        Spacer(modifier = Modifier.height(4.dp))

    } else {

        NavigationDrawerItem(
            label = {
                Text(
                    text = "Perfil",
                    modifier = Modifier.padding(16.dp)
                )
            },
            selected = false,
            onClick = { onNavigateToPerfilScreen() }
        )

        Spacer(modifier = Modifier.height(4.dp))

    }




    NavigationDrawerItem(
        label = {
            Text(
                text = "Vinilos",
                modifier = Modifier.padding(16.dp)
            )
        },
        selected = false,
        onClick = { onNavigateToCatalagoV() }
    )

    Spacer(modifier = Modifier.height(4.dp))

    NavigationDrawerItem(
        label = {
            Text(
                text = "CDs",
                modifier = Modifier.padding(16.dp)
            )
        },
        selected = false,
        onClick = { onNavigateToCatalagoCD() }
    )

    Spacer(modifier = Modifier.height(4.dp))

    NavigationDrawerItem(
        label = {
            Text(
                text = "Casettes",
                modifier = Modifier.padding(16.dp)
            )
        },
        selected = false,
        onClick = { onNavigateToCatalagoC() }
    )

    Spacer(modifier = Modifier.height(4.dp))

    NavigationDrawerItem(
        label = {
            Text(
                text = "Carrito",
                modifier = Modifier.padding(16.dp)
            )
        },
        selected = false,
        onClick = { onNavigateToCarritoScreen() }
    )

    Spacer(modifier = Modifier.height(4.dp))

    if (isLoggedIn.value) {

        NavigationDrawerItem(
            label = {
                Text(
                    text = "Logout",
                    modifier = Modifier.padding(16.dp)
                )
            },
            selected = false,
            onClick = {
                loginviewModel.saveBoolean(!isLoggedIn.value)
                onNavigateToHomeScreen()
            }
        )
    }
}

