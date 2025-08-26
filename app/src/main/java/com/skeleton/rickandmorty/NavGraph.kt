package com.skeleton.rickandmorty

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.skeleton.rickandmorty.domain.model.Karakter
import com.skeleton.rickandmorty.ui.presentation.detail.CharacterDetailScreen
import com.skeleton.rickandmorty.ui.presentation.home.CharacterListScreen
import com.skeleton.rickandmorty.ui.presentation.home.CharacterListViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    viewModel: CharacterListViewModel = getViewModel()
) {
    var selectedCharacter by remember { mutableStateOf<Karakter?>(null) }

    NavHost(
        navController = navController,
        startDestination = "character_list"
    ) {
        composable("character_list") {
            CharacterListScreen(
                viewModel = viewModel,
                onCharacterClick = { character ->
                    selectedCharacter = character
                    navController.navigate("character_detail")
                }
            )
        }

        composable("character_detail") {
            selectedCharacter?.let {
                CharacterDetailScreen(character = it)
            }
        }
    }
}
