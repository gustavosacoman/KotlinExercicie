package com.example.projetoteste.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.projetoteste.navigation.Screen

@Composable
fun WelcomeScreen(navController: NavController, name: String?) {
    var currentName by remember { mutableStateOf(name ?: "Visitante") }

    val savedStateHandle = navController.currentBackStackEntry?.savedStateHandle
    LaunchedEffect(savedStateHandle) {
        savedStateHandle?.get<String>("newName")?.let { newNameFromSettings ->
            currentName = newNameFromSettings
            savedStateHandle.remove<String>("newName")
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Olá, $currentName!",
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                navController.navigate(Screen.Settings.createRoute(currentName))
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ir para Configurações")
        }
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Sair")
        }
    }
}