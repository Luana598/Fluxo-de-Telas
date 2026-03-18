package com.aulasandroid.navegacaofluxotelas.screens

import android.view.Menu
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MenuScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()
        .background(Color(0xFFE0CFFF))
        .padding(32.dp)
    ){
        Text(
            text = "MENU",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(161, 117, 243, 255)
        )

        Column(modifier = Modifier.fillMaxWidth()
            .align(Alignment.Center)
            .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)) {

            Button(
                onClick = {navController.navigate("perfil/Lua/18")},
                colors = ButtonDefaults.buttonColors(
                    Color(0xFFF6EFBC)
                ),
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    text = "PERFIL",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color(161, 117, 243, 255)
                )
            }

            Button(
                onClick = {navController.navigate("pedidos?numeroPedido=666")},
                colors = ButtonDefaults.buttonColors(
                    Color(0xFFFCF5D9)
                ),
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    text = "PEDIDOS",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color(161, 117, 243, 255)
                )
            }

            Button(
                onClick = {navController.popBackStack()},
                colors = ButtonDefaults.buttonColors(
                    Color(0xFFF6EFBC)
                ),
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    text = "SAIR",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color(161, 117, 243, 255)
                )
            }

        }


    }
}
