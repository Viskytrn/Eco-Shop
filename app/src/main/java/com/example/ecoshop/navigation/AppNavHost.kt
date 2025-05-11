package com.example.EcoShop.navigation


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.EcoShop.data.UserDatabase
import com.example.EcoShop.repository.UserRepository
import com.example.EcoShop.ui.theme.screens.about.AboutScreen
import com.example.EcoShop.ui.theme.screens.auth.LoginScreen
import com.example.EcoShop.ui.theme.screens.auth.RegisterScreen
import com.example.EcoShop.ui.theme.screens.explore.ExploreScreen
import com.example.EcoShop.ui.theme.screens.intent.IntentScreen
import com.example.EcoShop.ui.theme.screens.others.OthersScreen
import com.example.EcoShop.ui.theme.screens.products.AddProductScreen
import com.example.EcoShop.ui.theme.screens.products.EditProductScreen
import com.example.EcoShop.ui.theme.screens.products.ProductListScreen
import com.example.EcoShop.ui.theme.screens.splash.SplashScreen
import com.example.EcoShop.ui.theme.screens.start.StartScreen
import com.example.EcoShop.ui.theme.viewmodel.AuthViewModel
import com.example.EcoShop.ui.theme.viewmodel.CartViewModel
import com.example.EcoShop.ui.theme.viewmodel.ProductViewModel
import com.mike.EcoShop.ui.theme.screens.cart.CartScreen
import com.mike.EcoShop.ui.theme.screens.home.HomeScreen


@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun AppNavHost(
  modifier: Modifier = Modifier,
  navController: NavHostController = rememberNavController(),
  startDestination: String = ROUT_SPLASH,
  productViewModel: ProductViewModel = viewModel(),
  cartViewModel: CartViewModel = viewModel(),



  ) {
  val context = LocalContext.current


  NavHost(
    navController = navController,
    startDestination = startDestination,
    modifier = modifier
  ) {
    composable(ROUT_HOME) {
      HomeScreen(navController)
    }
    composable(ROUT_ABOUT) {
      AboutScreen(navController)
    }
    composable(ROUT_INTENT) {
      IntentScreen(navController)
    }
    composable(ROUT_START) {
      StartScreen(navController)
    }
    composable(ROUT_EXPLORE) {
      ExploreScreen(navController)
    }
    composable(ROUT_OTHERS) {
      OthersScreen(navController)
    }
    composable(ROUT_SPLASH) {
      SplashScreen(navController)
    }
    //cart
    composable("cart") {
      CartScreen(cartViewModel = cartViewModel)
    }
    //AUTHENTICATION

    // Initialize Room Database and Repository for Authentication
    val appDatabase = UserDatabase.getDatabase(context)
    val authRepository = UserRepository(appDatabase.userDao())
    val authViewModel = AuthViewModel(authRepository)
    composable(ROUT_REGISTER) {
      RegisterScreen(authViewModel, navController) {
        navController.navigate(ROUT_LOGIN) {
          popUpTo(ROUT_REGISTER) { inclusive = true }
        }
      }
    }

    composable(ROUT_LOGIN) {
      LoginScreen(authViewModel, navController) {
        navController.navigate(ROUT_HOME) {
          popUpTo(ROUT_LOGIN) { inclusive = true }
        }
      }
    }

    // PRODUCTS
    composable(ROUT_ADD_PRODUCT) {
      AddProductScreen(navController,productViewModel)
    }

    composable(ROUT_PRODUCT_LIST) {
      ProductListScreen(navController,productViewModel)
    }

    composable(
      route = ROUT_EDIT_PRODUCT,
      arguments = listOf(navArgument("productId") { type = NavType.IntType })
    ) { backStackEntry ->
      val productId = backStackEntry.arguments?.getInt("productId")
      if (productId != null) {
        EditProductScreen(productId,navController,productViewModel)
      }
    }




  }
}
