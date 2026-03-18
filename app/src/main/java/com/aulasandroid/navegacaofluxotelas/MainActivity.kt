package com.aulasandroid.navegacaofluxotelas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aulasandroid.navegacaofluxotelas.screens.LoginScreen
import com.aulasandroid.navegacaofluxotelas.screens.MenuScreen
import com.aulasandroid.navegacaofluxotelas.screens.pedidosScreen
import com.aulasandroid.navegacaofluxotelas.screens.perfilScreen
import com.aulasandroid.navegacaofluxotelas.ui.theme.NavegacaoFluxoTelasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavegacaoFluxoTelasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "login",
                        exitTransition = {
                            slideOutOfContainer(
                                towards = AnimatedContentTransitionScope
                                          .SlideDirection.Left,
                                animationSpec = tween(1000)
                            ) + fadeOut(animationSpec = tween(500))
                        },
                        enterTransition = {
                            slideIntoContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Left,
                                animationSpec = tween(1000)
                            ) + fadeIn(animationSpec = tween(500))
                        }
                    ){
                        composable(
                            route = "login",
                            exitTransition = {
                                slideOutOfContainer(
                                    towards = AnimatedContentTransitionScope.SlideDirection.Up,
                                    animationSpec = tween(500)
                                )
                            }) { LoginScreen(
                            navController = navController
                        ) }
                        composable(route = "menu") { MenuScreen(
                            navController = navController
                        ) }
                        composable(
                            route = "perfil/{nome}/{idade}",
                            arguments = listOf(
                                navArgument("nome"){
                                  type = NavType.StringType
                                },
                                navArgument("idade"){
                                    type = NavType.IntType
                                }
                            )
                        ) {
                            navBackStackEntry ->
                            val nome = navBackStackEntry
                                .arguments?.getString("nome")

                            val idade = navBackStackEntry
                                .arguments?.getInt("idade")

                            perfilScreen(
                            navController = navController,
                            nome = nome!!,
                            idade = idade!!
                        ) }
                        composable(
                            route = "pedidos?numeroPedido={numeroPedido}",
                            arguments = listOf(
                                navArgument("numeroPedido"){
                                    defaultValue = "Sem Pedidos"
                                }
                            )
                        ) {
                            val numeroPedido = it.arguments?.getString("numeroPedido")

                            pedidosScreen(
                                navController = navController,
                                numeroPedido = numeroPedido!!
                        )
                        }
                    }
                }
            }
        }
    }
}


