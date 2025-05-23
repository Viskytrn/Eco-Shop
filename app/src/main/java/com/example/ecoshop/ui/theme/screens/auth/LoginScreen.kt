package com.example.EcoShop.ui.theme.screens.auth



import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.EcoShop.navigation.ROUT_EXPLORE
import com.example.EcoShop.navigation.ROUT_HOME
import com.example.EcoShop.navigation.ROUT_REGISTER
import com.example.EcoShop.ui.theme.viewmodel.AuthViewModel
import com.example.ecoshop.R


@Composable
fun LoginScreen(
  authViewModel: AuthViewModel,
  navController: NavController,
  onLoginSuccess: () -> Unit
) {
  var email by remember { mutableStateOf("") }
  var password by remember { mutableStateOf("") }
  var passwordVisible by remember { mutableStateOf(false) }
  val context = LocalContext.current

  // Observe login logic
  LaunchedEffect(authViewModel) {
    authViewModel.loggedInUser = { user ->
      if (user == null) {
        Toast.makeText(context, "Invalid Credentials", Toast.LENGTH_SHORT).show()
      } else {
        if (user.role == "admin") {
          navController.navigate(ROUT_HOME) {
          }
        } else {
          navController.navigate(ROUT_EXPLORE) {
          }
        }
      }
    }
  }
//End of login logic

  Column(
    modifier = Modifier
      .fillMaxSize()
      .background(Color(0xFFF5F5DC)) // Light olive background




      .padding(20.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Image(
      painter = painterResource(R.drawable.save),
      contentDescription = "dress",
      modifier = Modifier.clip(shape = RoundedCornerShape(10.dp)),

      contentScale = ContentScale.FillBounds
    )

    // Animated Welcome Text
    AnimatedVisibility(
      visible = true,
      enter = fadeIn(animationSpec = tween(1000)),
      exit = fadeOut(animationSpec = tween(1000))
    ) {
      Text(
        text = "Welcome Back!",
        fontSize = 40.sp,
        fontFamily = FontFamily.Cursive
      )
    }

    Spacer(modifier = Modifier.height(24.dp))

    // Email Input
    OutlinedTextField(
      value = email,
      onValueChange = { email = it },
      label = { Text("Email") },
      leadingIcon = { Icon(Icons.Filled.Email, contentDescription = "Email Icon") },
      keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
      modifier = Modifier.fillMaxWidth(),
      shape = RoundedCornerShape(12.dp)
    )

    Spacer(modifier = Modifier.height(12.dp))

    // Password Input with Show/Hide Toggle
    OutlinedTextField(
      value = password,
      onValueChange = { password = it },
      label = { Text("Password") },
      leadingIcon = { Icon(Icons.Filled.Lock, contentDescription = "Password Icon") },
      visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
      keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
      modifier = Modifier.fillMaxWidth(),
      shape = RoundedCornerShape(12.dp),
      trailingIcon = {
        val image = if (passwordVisible) painterResource(R.drawable.eyeicon) else painterResource(R.drawable.visibilityoff)
        IconButton(onClick = { passwordVisible = !passwordVisible }) {
          Icon(image, contentDescription = if (passwordVisible) "Hide Password" else "Show Password")
        }
      }
    )

    Spacer(modifier = Modifier.height(20.dp))

    // Gradient Login Button
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)
        .background(
          brush = Brush.horizontalGradient(
            colors = listOf(Color(0xFF00C6FF), Color(0xFF0072FF))
          ),
          shape = RoundedCornerShape(12.dp)
        ),
      contentAlignment = Alignment.Center
    ) {
      Button(
        onClick = {
          if (email.isBlank() || password.isBlank()) {
            Toast.makeText(context, "Please enter email and password", Toast.LENGTH_SHORT).show()
          } else {
            authViewModel.loginUser(email, password)
          }
        },
        modifier = Modifier.fillMaxSize(),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        shape = RoundedCornerShape(12.dp)
      ) {
        Text("Login", color = Color.White)
      }
    }

    Spacer(modifier = Modifier.height(16.dp))

    // Register Navigation Button
    TextButton(onClick = { navController.navigate(ROUT_REGISTER) }) {
      Text("Don't have an account? Register")
    }
  }
}
