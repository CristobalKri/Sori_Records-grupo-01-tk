package com.example.sori_records_grupo01tk.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sori_records_grupo01tk.datos.AlbumsList
import com.example.sori_records_grupo01tk.datos.BillboardRepository
import com.example.sori_records_grupo01tk.datos.RetrofitInstance
//import com.example.sori_records_grupo01tk.datos.AlbumsList
import com.example.sori_records_grupo01tk.ui.components.Buscador
import com.example.sori_records_grupo01tk.ui.components.TopBar
import com.example.sori_records_grupo01tk.ui.screen.RegistroScreen
import com.example.sori_records_grupo01tk.ui.screens.CarritoScreen
import com.example.sori_records_grupo01tk.ui.screens.Catalogot
import com.example.sori_records_grupo01tk.ui.screens.HomeScreen
import com.example.sori_records_grupo01tk.ui.screens.LoadingScreen
import com.example.sori_records_grupo01tk.ui.screens.LoginScreen
import com.example.sori_records_grupo01tk.ui.screens.PagoCompletado
import com.example.sori_records_grupo01tk.ui.screens.PerfilScreen
import com.example.sori_records_grupo01tk.ui.screens.ProductoScreen
import com.example.sori_records_grupo01tk.viewmodel.UsuarioViewModel
import com.example.sori_records_grupo01tk.ui.components.DrawerContent
import com.example.sori_records_grupo01tk.viewmodel.CartViewModel
import com.example.sori_records_grupo01tk.ui.screens.AddAlbum
import com.example.sori_records_grupo01tk.ui.screens.AdminScreen
import com.example.sori_records_grupo01tk.ui.screens.BillboardScreen
import com.example.sori_records_grupo01tk.ui.screens.LogoutScreen
import com.example.sori_records_grupo01tk.ui.screens.PagoScreen
import com.example.sori_records_grupo01tk.viewmodel.BillboardViewModel
import com.example.sori_records_grupo01tk.viewmodel.BillboardViewModelFactory
import com.example.sori_records_grupo01tk.viewmodel.AlbumViewModel
import kotlinx.coroutines.launch

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
) {

    val navController = rememberNavController()
    val usuarioViewModel: UsuarioViewModel = viewModel()
    val cartViewModel: CartViewModel = viewModel()
    val albumViewModel: AlbumViewModel = viewModel()

    val albumList = albumViewModel.albumList.collectAsState().value

    val repository = BillboardRepository(RetrofitInstance.api)
    val factory = BillboardViewModelFactory(repository)
    val billboardViewModel: BillboardViewModel = viewModel(factory = factory)

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
                    },
                    onNavigateToAdminScreen = {
                        scope.launch {
                            navController.navigate("Acciones admin")
                            drawerState.close()
                        }
                    },
                    onNavigateToLogoutScreen = {
                        scope.launch {
                            navController.navigate("logout")
                            drawerState.close()
                        }
                    },
                    onNavigateToBillboardScreen = {
                        scope.launch {
                            navController.navigate("billboard")
                            drawerState.close()
                        }
                    },
                    billboardViewModel = billboardViewModel
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
                    "cassette" -> "Cassettes"
                    "carrito" -> "Carrito"
                    "login" -> "Login"
                    "perfil" -> "Perfil"
                    "buscador" -> "Buscador"
                    "producto/{albumId}" -> "Producto"
                    else -> "Sori Records"
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
                    HomeScreen(navController, cartViewModel)
                }
                composable("registro") {
                    RegistroScreen(navController, usuarioViewModel)
                }
                composable("vinilos") {
                    Catalogot("Vinilo",navController, cartViewModel )
                }
                composable("cds") {
                    Catalogot("CD", navController, cartViewModel)
                }
                composable("cassette") {
                    Catalogot("Cassette", navController, cartViewModel)
                }
                composable("producto/{albumId}") { backStackEntry ->
                    val albumId = backStackEntry.arguments?.getString("albumId")?.toIntOrNull()
                    val album = albumId?.let { albumList.find { it.id == albumId } }
                    album?.let {
                        ProductoScreen(navController = navController, album = it, cartViewModel)
                    }
                }
                composable("carrito") {
                    CarritoScreen(navController, cartViewModel)
                }
                composable("pago") {
                    PagoScreen(navController, usuarioViewModel, cartViewModel)
                }
                composable("loading") {
                    LoadingScreen(navController)
                }
                composable("pagoC") {
                    PagoCompletado()
                }
                composable("buscador") {
                    Buscador(albums = albumList, navController = navController)
                }
                composable("login") {
                    LoginScreen(navController, usuarioViewModel)
                }
                composable("perfil") {
                    PerfilScreen(navController)
                }
                composable("logout") {
                    LogoutScreen(navController)
                }
                composable("Acciones admin") {
                    AdminScreen(navController)
                }
                composable("addAlbum/{tipo}") { backStackEntry ->
                    val tipo = backStackEntry.arguments?.getString("tipo") ?: "vinilo"
                    AddAlbum(tipoPre = tipo, onSave = { newAlbum ->
                        /*TODO*/
                    }, navController)
                }
                composable("billboard") {
                    BillboardScreen(billboardViewModel)
                }
            }
        }
    }
}
