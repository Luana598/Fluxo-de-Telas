package com.aulasandroid.navegacaofluxotelas.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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

@Composable
fun perfilScreen(){
    Box(modifier = Modifier.fillMaxSize()
        .background(Color(0xFFD3C3F8))
        .padding(32.dp)
    ){
        Text(
            text = "PERFIL",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(161, 117, 243, 255)
        )

        Button(
            onClick = {/* TODO */},
            colors = ButtonDefaults.buttonColors(
                Color.White
            ),
            modifier = Modifier.align(Alignment.Center)
        ){
            Text(
                text = "VOLTAR",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color(161, 117, 243, 255)
            )
        }


    }
}