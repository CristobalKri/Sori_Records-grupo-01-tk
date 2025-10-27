package com.example.sori_records_grupo01tk.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sori_records_grupo01tk.datos.AlbumsList
import com.example.sori_records_grupo01tk.ui.components.Buscador
import com.example.sori_records_grupo01tk.ui.components.TopBar
import com.example.sori_records_grupo01tk.ui.screen.RegistroScreen
import com.example.sori_records_grupo01tk.ui.screen.ResumenScreen
import com.example.sori_records_grupo01tk.ui.screens.CarritoScreen
import com.example.sori_records_grupo01tk.ui.screens.Catalogot
import com.example.sori_records_grupo01tk.ui.screens.HomeScreen
import com.example.sori_records_grupo01tk.ui.screens.LoadingScreen
import com.example.sori_records_grupo01tk.ui.screens.LoginScreen
import com.example.sori_records_grupo01tk.ui.screens.PagoCompletado
import com.example.sori_records_grupo01tk.ui.screens.PerfilScreen
import com.example.sori_records_grupo01tk.ui.screens.ProductoScreen
import com.example.sori_records_grupo01tk.ui.theme.PrimaryColor
import com.example.sori_records_grupo01tk.viewmodel.UsuarioViewModel
import com.example.sori_records_grupo01tk.viewmodel.TitleViewModel
import kotlinx.coroutines.launch

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {

    val navController = rememberNavController()
    val usuarioViewModel: UsuarioViewModel = viewModel()
    val titleViewModel: TitleViewModel = viewModel()

    val title = titleViewModel.currentScreenTitle.value

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
                    },
                    onNavigateToCarritoScreen = {
                        scope.launch {
                            navController.navigate("carrito")
                            drawerState.close()
                        }
                    },
                    onNavigateToLoginScreen = {
                        scope.launch {
                            navController.navigate("login")
                            drawerState.close()
                        }
                    },
                    onNavigateToPerfilScreen = {
                        scope.launch {
                            navController.navigate("perfil")
                            drawerState.close()
                        }
                    }
                )
            }
        }
    ) {
        Scaffold(

            topBar = {

                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination?.route
                val title = when (currentDestination) {
                    "homescreen" -> "Sori Records"
                    "registro" -> "Registro"
                    "vinilos" -> "Vinilos"
                    "cds" -> "CDs"
                    "casette" -> "Casettes"
                    "carrito" -> "Carrito"
                    "login" -> "Login"
                    else -> "Error Title"
                }

                TopBar(
                    title = title,
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
                    Catalogot("Vinilo",navController )
                }
                composable("cds") {
                    Catalogot("CD", navController)
                }
                composable("cassette") {
                    Catalogot("Cassette", navController)
                }
                composable("producto/{albumId}") { backStackEntry ->
                    val albumId = backStackEntry.arguments?.getString("albumId")?.toIntOrNull()
                    val album = albumId?.let { AlbumsList.albums.find { it.id == albumId } }
                    album?.let {
                        ProductoScreen(navController = navController, album = it)
                    }
                }
                composable("carrito") {
                    CarritoScreen(navController)
                }
                composable("loading") {
                    LoadingScreen(navController)
                }
                composable("pagoC") {
                    PagoCompletado()
                }
                composable("buscador") {
                    Buscador(albums = AlbumsList.albums, navController = navController)
                }
                composable("login") {
                    LoginScreen(navController, usuarioViewModel)
                }
                composable("perfil") {
                    PerfilScreen(navController)
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
    onNavigateToCatalagoC: () -> Unit,
    onNavigateToCarritoScreen: () -> Unit,
    onNavigateToLoginScreen: () -> Unit,
    onNavigateToPerfilScreen: () -> Unit
) {




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
}


