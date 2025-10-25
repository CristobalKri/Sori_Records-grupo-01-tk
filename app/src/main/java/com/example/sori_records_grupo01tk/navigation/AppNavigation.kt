package com.example.sori_records_grupo01tk.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sori_records_grupo01tk.ui.components.TopBar
import com.example.sori_records_grupo01tk.ui.screen.RegistroScreen
import com.example.sori_records_grupo01tk.ui.screen.ResumenScreen
import com.example.sori_records_grupo01tk.ui.screens.Catalogot
import com.example.sori_records_grupo01tk.ui.screens.HomeScreen
import com.example.sori_records_grupo01tk.ui.theme.PrimaryColor
import com.example.sori_records_grupo01tk.viewmodel.UsuarioViewModel
import kotlinx.coroutines.launch

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val usuarioViewModel: UsuarioViewModel = viewModel()

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()


    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(

            ) {

                DrawerContent(
                    onNavigateToRegistro = {
                        scope.launch {
                            navController.navigate("registro")
                            drawerState.close()
                        }
                    },
                    onNavigateToResumen = {
                        scope.launch {
                            navController.navigate("resumen")
                            drawerState.close()
                        }
                    },
                    onNavigateToHomeScreen = {
                        scope.launch {
                            navController.navigate("homescreen")
                            drawerState.close()
                        }
                    },
                    onNavigateToCatalagoV = {
                        scope.launch {
                            navController.navigate("vinilos")
                            drawerState.close()
                        }
                    },
                    onNavigateToCatalagoCD = {
                        scope.launch {
                            navController.navigate("cds")
                            drawerState.close()
                        }
                    },
                    onNavigateToCatalagoC = {
                        scope.launch {
                            navController.navigate("cassette")
                            drawerState.close()
                        }
                    }
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopBar(
                    title = "Sori Records" ,
                    onOpenDrawer = {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    }
                )
            }
        ) { padding ->
            NavHost(
                navController = navController,
                startDestination = "homescreen",
                modifier = Modifier.padding(padding)
            ) {
                composable("homescreen") {
                    HomeScreen(navController)
                }
                composable("registro") {
                    RegistroScreen(navController, usuarioViewModel)
                }
                composable("resumen") {
                    ResumenScreen(usuarioViewModel)
                }
                composable("vinilos") {
                    Catalogot("Vinilo")
                }
                composable("cds") {
                    Catalogot("CD")
                }
                composable("cassette") {
                    Catalogot("Cassette")
                }
            }
        }
    }
}

@Composable
fun DrawerContent(
    modifier: Modifier = Modifier,
    onNavigateToRegistro: () -> Unit,
    onNavigateToResumen: () -> Unit,
    onNavigateToHomeScreen: () -> Unit,
    onNavigateToCatalagoV: () -> Unit,
    onNavigateToCatalagoCD: () -> Unit,
    onNavigateToCatalagoC: () -> Unit
) {


    val topAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(
        containerColor = PrimaryColor, // Your primary color
        titleContentColor = MaterialTheme.colorScheme.onPrimary,
        navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
    )


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(topAppBarColors.containerColor)
            .padding(16.dp)
    ){
        Text(
            text = "Sori Records",
            modifier = Modifier.padding(16.dp),
            color = topAppBarColors.titleContentColor,

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
        onClick = { onNavigateToHomeScreen() }
    )

    NavigationDrawerItem(
        label = {
            Text(
                text = "Registro",
                modifier = Modifier.padding(16.dp)
            )
        },
        selected = false,
        onClick = { onNavigateToRegistro() }
    )

    Spacer(modifier = Modifier.height(4.dp))

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
}


