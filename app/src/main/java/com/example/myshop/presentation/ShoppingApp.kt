package com.example.myshop.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.myshop.presentation.navigation.MainDestinations
import com.example.myshop.presentation.navigation.rememberShoppingAppNavController
import com.example.myshop.presentation.designsystem.theme.ShoppingAppTheme
import com.example.myshop.model.shopping.Product
import com.example.myshop.presentation.cart.CartScreen
import com.example.myshop.presentation.home.HomeSections
import com.example.myshop.presentation.home.addHomeGraph
import com.example.myshop.presentation.login.LoginScreen
import com.example.myshop.presentation.payment.PaymentScreen
import com.example.myshop.presentation.product_detail.ProductDetailScreen
import com.example.myshop.presentation.sign_up.SignUpScreen

@Composable
fun ShoppingApp(startDestination: String) {
    ShoppingAppTheme {
        val shoppingAppNavController = rememberShoppingAppNavController()
        NavHost(
            navController = shoppingAppNavController.navController,
            startDestination = startDestination,
        ) {
            shoppingAppGraph(
                onProductClick = shoppingAppNavController::navigateToProduct,
                onSignOutClick = shoppingAppNavController::onNavigateLogin,
                onCartClick = shoppingAppNavController::navigateCart,
                onSignUpClick = shoppingAppNavController::navigateToSignUp,
                onLoginClick = shoppingAppNavController::navigateHome,
                onPaymentClick = shoppingAppNavController::navigatePayment,
                onContinueShoppingClick = shoppingAppNavController::navigateHome,
                upPress = shoppingAppNavController::upPress,
                onNavigateToRoute = shoppingAppNavController::navigateToBottomBarRoute
            )
        }
    }
}

private fun NavGraphBuilder.shoppingAppGraph(
    onProductClick: (Product, NavBackStackEntry) -> Unit,
    onSignOutClick: (NavBackStackEntry) -> Unit,
    onCartClick: (NavBackStackEntry) -> Unit,
    onSignUpClick: (NavBackStackEntry) -> Unit,
    onLoginClick: (NavBackStackEntry) -> Unit,
    onPaymentClick: (Float, NavBackStackEntry) -> Unit,
    onContinueShoppingClick: (NavBackStackEntry) -> Unit,
    upPress: () -> Unit,
    onNavigateToRoute: (String) -> Unit
) {
    navigation(
        route = MainDestinations.PRODUCT_ROUTE,
        startDestination = HomeSections.PRODUCT.route
    ) {
        addHomeGraph(onProductClick, onSignOutClick, onCartClick, onNavigateToRoute)
    }
    composable(route = MainDestinations.LOGIN_ROUTE) { from ->
        LoginScreen(
            onSignUpClick = remember { { onSignUpClick(from) } },
            onLoginClick = remember { { onLoginClick(from) } }
        )
    }
    composable(route = MainDestinations.SIGNUP_ROUTE) {
        SignUpScreen(upPress = upPress)
    }
    composable(route = MainDestinations.CART_ROUTE) { from ->
        CartScreen(onPaymentClick = remember { { amount -> onPaymentClick(amount, from) } })
    }
    composable(
        route = "${MainDestinations.PAYMENT_ROUTE}/{${MainDestinations.PAYMENT_AMOUNT_KEY}}",
        arguments = listOf(navArgument(MainDestinations.PAYMENT_AMOUNT_KEY) {
            type = NavType.FloatType
        })
    ) { from ->
        PaymentScreen(onContinueShoppingClick = remember { { onContinueShoppingClick(from) } })
    }
    composable(
        route = "${MainDestinations.PRODUCT_DETAIL_ROUTE}/{${MainDestinations.PRODUCT_DETAIL_KEY}}",
        arguments = listOf(
            navArgument(MainDestinations.PRODUCT_DETAIL_KEY) { type = NavType.StringType }
        )
    ) { from ->
        ProductDetailScreen(onCartClick = remember { { onCartClick(from) } })
    }
}