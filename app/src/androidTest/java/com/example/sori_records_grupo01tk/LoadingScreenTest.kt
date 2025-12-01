package com.example.sori_records_grupo01tk

import androidx.compose.material3.Text
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sori_records_grupo01tk.ui.screens.LoadingScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.ext.junit.runners.AndroidJUnit4 // Import the runner


@RunWith(AndroidJUnit4::class)
class LoadingScreenTest {


    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testLoadingScreenNavigatesAfterDelay() {


        composeTestRule.setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "loading") {
                composable("loading") {
                    LoadingScreen(navController = navController)
                }
                composable("pagoC") {
                    Text("Payment Screen")
                }
            }
        }


        composeTestRule.onNodeWithTag("progressIndicator").assertIsDisplayed()


        composeTestRule.mainClock.advanceTimeBy(2500)


        composeTestRule.onNodeWithText("Payment Screen").assertIsDisplayed()


        composeTestRule.onNodeWithTag("progressIndicator").assertDoesNotExist()
    }
}
