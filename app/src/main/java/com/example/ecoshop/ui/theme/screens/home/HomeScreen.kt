package com.mike.EcoShop.ui.theme.screens.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.EcoShop.navigation.ROUT_ADD_PRODUCT
import com.example.EcoShop.navigation.ROUT_CART
import com.example.EcoShop.navigation.ROUT_EXPLORE
import com.example.EcoShop.navigation.ROUT_HOME
import com.example.EcoShop.navigation.ROUT_INTENT
import com.example.EcoShop.navigation.ROUT_OTHERS
import com.example.EcoShop.navigation.ROUT_PRODUCT_LIST
import com.example.ecoshop.R


@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun HomeScreen(navController: NavHostController) {
  val mContext= LocalContext.current


  //Scaffold

  var selectedIndex by remember { mutableIntStateOf(0) }


  Scaffold(
    //TopBar
    topBar = {
      //top App Bar
      TopAppBar(
        title = {Text(text = "Home")},
        colors = TopAppBarDefaults.topAppBarColors(
          containerColor = Gray,
          titleContentColor = Color.White,
          navigationIconContentColor = Color.White,
          actionIconContentColor = Color.White

        ),
        navigationIcon = {
          IconButton(onClick = {
            navController.navigate(ROUT_INTENT)


          }) {
            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
          }
        },
        actions = {
          IconButton(onClick = {
            navController.navigate(ROUT_CART)



          }) {
            Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "")
          }
          IconButton(onClick = {}) {
            Icon(imageVector = Icons.Default.Notifications, contentDescription = "")
          }
          IconButton(onClick = {
            navController.navigate(ROUT_ADD_PRODUCT)


          }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "")
          }
        })

    },

    //BottomBar
    bottomBar = {
      NavigationBar(
        containerColor = Color.LightGray
      ){
        NavigationBarItem(
          icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
          label = { Text("Home") },
          selected = selectedIndex == 0,
          onClick = { selectedIndex = 0
            navController.navigate(ROUT_HOME)
          }
        )
        NavigationBarItem(
          icon = { Icon(Icons.Default.Search, contentDescription = "Explore") },
          label = { Text("Explore") },
          selected = selectedIndex == 1,
          onClick = { selectedIndex = 1
            navController.navigate(ROUT_EXPLORE)
          }
        )


        NavigationBarItem(
          icon = { Icon(Icons.Default.List, contentDescription = "Favorites") },
          label = { Text("Collection") },
          selected = selectedIndex == 3,
          onClick = { selectedIndex = 3
            navController.navigate(ROUT_OTHERS)
          }
        )
        NavigationBarItem(
          icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Profile") },
          label = { Text("Insta Buy") },
          selected = selectedIndex == 2,
          onClick = { selectedIndex = 2
            navController.navigate(ROUT_PRODUCT_LIST)

            //  navController.navigate(ROUT_HOME)
          }
        )

      }
    },


    content = { paddingValues ->
      Column(
        modifier = Modifier
          .fillMaxSize()
          .background(Color(0xFFF5F5DC)) // Light olive background
          .padding(paddingValues)
      ) {
        // Top Bar
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween
        ) {
          Text("EcoShop", fontSize = 24.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Cursive)
          Icon(Icons.Default.Notifications, contentDescription = "Notifications")
        }

//        Spacer(modifier = Modifier.height(16.dp))
        // Category Tabs
//        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
//          listOf("All", "Skirts", "Bags", "Tanks", "Socks").forEachIndexed { index, tab ->
//            val bgColor = if (index == 0) Color(0xFFBA8B65) else Color.Transparent
//            Text(
//              text = tab,
//              modifier = Modifier
//                .background(bgColor, RoundedCornerShape(20.dp))
//                .padding(horizontal = 12.dp, vertical = 6.dp)
//            )
//          }
//        }
        Spacer(modifier = Modifier.height(6.dp))

        // On Sale Section
        Text("Get your offers here", fontWeight = FontWeight.Bold)

        Card(
          modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
          elevation = CardDefaults.cardElevation(4.dp)
        ) {
          Row (
            modifier = Modifier.horizontalScroll(rememberScrollState())
          ){
            Row(modifier = Modifier.padding(8.dp)) {
              Box(
                modifier = Modifier
                  .size(64.dp)
                  .background(Gray)
              ) {
                // Product Image Placeholder
                Image(
                  painter = painterResource(R.drawable.socks1),
                  contentDescription = "dress",
                  modifier = Modifier.fillMaxSize(),

                  contentScale = ContentScale.FillBounds
                )
                Icon(
                  imageVector = Icons.Default.Add,
                  contentDescription = "",
                  tint = Gray,
                  modifier = Modifier.align (Alignment.BottomStart)
                    .clickable{
                      val simToolKitLaunchIntent =
                        mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                      simToolKitLaunchIntent?.let { mContext.startActivity(it) }

                    },

                  )
              }
              Spacer(modifier = Modifier.width(8.dp))
              Column {
                Text("Socks", fontWeight = FontWeight.Bold)
                Text("Comfy and Casual", fontSize = 12.sp)
                Text(
                  text = " Was Ksh.450",
                  textDecoration = TextDecoration.LineThrough,
                  fontSize = 15.sp
                )
                Text(
                  text = " Now Ksh.399",
                  fontSize = 15.sp
                )



              }


            }
            Spacer(modifier = Modifier.width(20.dp))
            Row(modifier = Modifier.padding(8.dp)) {
              Box(
                modifier = Modifier
                  .size(64.dp)
                  .background(Gray)
              ) {
                // Product Image Placeholder
                Image(
                  painter = painterResource(R.drawable.all),
                  contentDescription = "dress",
                  modifier = Modifier.fillMaxSize(),

                  contentScale = ContentScale.FillBounds
                )
                Icon(
                  imageVector = Icons.Default.Add,
                  contentDescription = "",
                  tint = Color.Black,
                  modifier = Modifier.align (Alignment.BottomStart)
                    .clickable{
                      val simToolKitLaunchIntent =
                        mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                      simToolKitLaunchIntent?.let { mContext.startActivity(it) }

                    },

                  )
              }
              Spacer(modifier = Modifier.width(8.dp))
              Column {
                Text("Full Tracksuits", fontWeight = FontWeight.Bold)
                Text("Comfy and Casual", fontSize = 12.sp)
                Text(
                  text = "Was Ksh.5000",
                  textDecoration = TextDecoration.LineThrough,
                  fontSize = 15.sp
                )
                Text(
                  text = "Now Ksh.4599",
                  fontSize = 15.sp
                )


              }


            }
            Spacer(modifier = Modifier.width(8.dp))
            Row(modifier = Modifier.padding(8.dp)) {
              Box(
                modifier = Modifier
                  .size(64.dp)
                  .background(Gray)
              ) {
                // Product Image Placeholder
                Image(
                  painter = painterResource(R.drawable.shoes4),
                  contentDescription = "dress",
                  modifier = Modifier.fillMaxSize(),

                  contentScale = ContentScale.FillBounds
                )
                Icon(
                  imageVector = Icons.Default.Add,
                  contentDescription = "",
                  tint = Gray,
                  modifier = Modifier.align (Alignment.BottomStart)
                    .clickable{
                      val simToolKitLaunchIntent =
                        mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                      simToolKitLaunchIntent?.let { mContext.startActivity(it) }

                    },

                  )
              }
              Spacer(modifier = Modifier.width(8.dp))
              Column {
                Text("", fontWeight = FontWeight.Bold)
                Text("Comfy and Casual", fontSize = 12.sp)
                Text(
                  text = "Was Ksh.4500",
                  textDecoration = TextDecoration.LineThrough,
                  fontSize = 15.sp
                )
                Text(
                  text = "Now Ksh.3999",
                  fontSize = 15.sp
                )


              }


            }
          }

        }

        // Popular Products Section
        Text("Popular products", fontWeight = FontWeight.Bold)

        LazyVerticalGrid(
          columns = GridCells.Fixed(2),
          modifier = Modifier.fillMaxHeight(),
          contentPadding = PaddingValues(top = 8.dp),
          verticalArrangement = Arrangement.spacedBy(12.dp),
          horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
          items(1) { index ->
            Card(
              modifier = Modifier.fillMaxWidth(),
              elevation = CardDefaults.cardElevation(4.dp)
            ) {
              Column(modifier = Modifier.padding(8.dp)) {
                Box(
                  modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .background(Color.LightGray)
                ) {

                  // Product Image Placeholder
                  Image(
                    painter = painterResource(R.drawable.ttisho),
                    contentDescription = "dress",
                    modifier = Modifier.fillMaxSize(),

                    contentScale = ContentScale.FillBounds
                  )

                }
                Spacer(modifier = Modifier.height(8.dp))
                Text("Cotton T-shirt")
                Text("Ksh 850", fontWeight = FontWeight.Bold)
                Row{
                  

                  Icon(Icons.Default.FavoriteBorder, contentDescription = "Favorite")
                  Spacer(modifier = Modifier.width(10.dp))

                  Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    tint = Gray,
                    modifier = Modifier
                      .clickable{
                        val simToolKitLaunchIntent =
                          mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                        simToolKitLaunchIntent?.let { mContext.startActivity(it) }

                      },

                    )

                }

              }
            }
          }
          items(1) { index ->
            Card(
              modifier = Modifier.fillMaxWidth(),
              elevation = CardDefaults.cardElevation(4.dp)
            ) {
              Column(modifier = Modifier.padding(8.dp)) {
                Box(
                  modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .background(Color.LightGray)
                ) {
                  // Product Image Placeholder
                  Image(
                    painter = painterResource(R.drawable.tttisho),
                    contentDescription = "dress",
                    modifier = Modifier.fillMaxSize(),

                    contentScale = ContentScale.FillBounds
                  )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text("T-shirt")
                Text("Ksh 500", fontWeight = FontWeight.Bold)
                Row{
                  Icon(Icons.Default.FavoriteBorder, contentDescription = "Favorite")
                  Spacer(modifier = Modifier.width(10.dp))

                  Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    tint = Gray,
                    modifier = Modifier
                      .clickable{
                        val simToolKitLaunchIntent =
                          mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                        simToolKitLaunchIntent?.let { mContext.startActivity(it) }

                      },

                    )

                }
              }
            }
          }
          items(1) { index ->
            Card(
              modifier = Modifier.fillMaxWidth(),
              elevation = CardDefaults.cardElevation(4.dp)
            ) {
              Column(modifier = Modifier.padding(8.dp)) {
                Box(
                  modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .background(Color.LightGray)
                ) {
                  // Product Image Placeholder
                  Image(
                    painter = painterResource(R.drawable.all1),
                    contentDescription = "dress",
                    modifier = Modifier.fillMaxSize(),

                    contentScale = ContentScale.FillBounds
                  )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text("Full Track suit")
                Text("Ksh 5000", fontWeight = FontWeight.Bold)
                Row{
                  Icon(Icons.Default.FavoriteBorder, contentDescription = "Favorite")
                  Spacer(modifier = Modifier.width(10.dp))

                  Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    tint = Gray,
                    modifier = Modifier
                      .clickable{
                        val simToolKitLaunchIntent =
                          mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                        simToolKitLaunchIntent?.let { mContext.startActivity(it) }

                      },

                    )

                }
              }
            }
          }
          items(1) { index ->
            Card(
              modifier = Modifier.fillMaxWidth(),
              elevation = CardDefaults.cardElevation(4.dp)
            ) {
              Column(modifier = Modifier.padding(8.dp)) {
                Box(
                  modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .background(Color.LightGray)
                ) {
                  // Product Image Placeholder
                  Image(
                    painter = painterResource(R.drawable.all),
                    contentDescription = "dress",
                    modifier = Modifier.fillMaxSize(),

                    contentScale = ContentScale.FillBounds
                  )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text("Full Track Suit")
                Text("Ksh 5000", fontWeight = FontWeight.Bold)
                Row{
                  Icon(Icons.Default.FavoriteBorder, contentDescription = "Favorite")
                  Spacer(modifier = Modifier.width(10.dp))

                  Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    tint = Gray,
                    modifier = Modifier
                      .clickable{
                        val simToolKitLaunchIntent =
                          mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                        simToolKitLaunchIntent?.let { mContext.startActivity(it) }

                      },

                    )

                }
              }
            }
          }
          items(1) { index ->
            Card(
              modifier = Modifier.fillMaxWidth(),
              elevation = CardDefaults.cardElevation(4.dp)
            ) {
              Column(modifier = Modifier.padding(8.dp)) {
                Box(
                  modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .background(Color.LightGray)
                ) {
                  // Product Image Placeholder
                  Image(
                    painter = painterResource(R.drawable.sweater2),
                    contentDescription = "dress",
                    modifier = Modifier.fillMaxSize(),

                    contentScale = ContentScale.FillBounds
                  )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text("Sweater")
                Text("Ksh 2500", fontWeight = FontWeight.Bold)
                Row{
                  Icon(Icons.Default.FavoriteBorder, contentDescription = "Favorite")
                  Spacer(modifier = Modifier.width(10.dp))

                  Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    tint = Gray,
                    modifier = Modifier
                      .clickable{
                        val simToolKitLaunchIntent =
                          mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                        simToolKitLaunchIntent?.let { mContext.startActivity(it) }

                      },

                    )

                }
              }
            }
          }
          items(1) { index ->
            Card(
              modifier = Modifier.fillMaxWidth(),
              elevation = CardDefaults.cardElevation(4.dp)
            ) {
              Column(modifier = Modifier.padding(8.dp)) {
                Box(
                  modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .background(Color.LightGray)
                ) {
                  // Product Image Placeholder
                  Image(
                    painter = painterResource(R.drawable.sweater3),
                    contentDescription = "dress",
                    modifier = Modifier.fillMaxSize(),

                    contentScale = ContentScale.FillBounds
                  )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text("Sweater")
                Text("Ksh 2500", fontWeight = FontWeight.Bold)
                Row{
                  Icon(Icons.Default.FavoriteBorder, contentDescription = "Favorite")
                  Spacer(modifier = Modifier.width(10.dp))

                  Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    tint = Gray,
                    modifier = Modifier
                      .clickable{
                        val simToolKitLaunchIntent =
                          mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                        simToolKitLaunchIntent?.let { mContext.startActivity(it) }

                      },

                    )

                }
              }
            }
          }
          items(1) { index ->
            Card(
              modifier = Modifier.fillMaxWidth(),
              elevation = CardDefaults.cardElevation(4.dp)
            ) {
              Column(modifier = Modifier.padding(8.dp)) {
                Box(
                  modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .background(Color.LightGray)
                ) {
                  // Product Image Placeholder
                  Image(
                    painter = painterResource(R.drawable.shoes6),
                    contentDescription = "dress",
                    modifier = Modifier.fillMaxSize(),

                    contentScale = ContentScale.FillBounds
                  )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text("Sneakers - Nike")
                Text("Ksh 4500", fontWeight = FontWeight.Bold)
                Row{
                  Icon(Icons.Default.FavoriteBorder, contentDescription = "Favorite")
                  Spacer(modifier = Modifier.width(10.dp))

                  Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    tint = Gray,
                    modifier = Modifier
                      .clickable{
                        val simToolKitLaunchIntent =
                          mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                        simToolKitLaunchIntent?.let { mContext.startActivity(it) }

                      },

                    )

                }
              }
            }
          }
          items(1) { index ->
            Card(
              modifier = Modifier.fillMaxWidth(),
              elevation = CardDefaults.cardElevation(4.dp)
            ) {
              Column(modifier = Modifier.padding(8.dp)) {
                Box(
                  modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .background(Color.LightGray)
                ) {
                  // Product Image Placeholder
                  Image(
                    painter = painterResource(R.drawable.shoes9),
                    contentDescription = "dress",
                    modifier = Modifier.fillMaxSize(),

                    contentScale = ContentScale.FillBounds
                  )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text("Sneakers")
                Text("Ksh 4500", fontWeight = FontWeight.Bold)
                Row{
                  Icon(Icons.Default.FavoriteBorder, contentDescription = "Favorite")
                  Spacer(modifier = Modifier.width(10.dp))

                  Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    tint = Gray,
                    modifier = Modifier
                      .clickable{
                        val simToolKitLaunchIntent =
                          mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                        simToolKitLaunchIntent?.let { mContext.startActivity(it) }

                      },

                    )

                }
              }
            }
          }
        }
      }
    })

}


















  //End of scaffold





@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
  HomeScreen(navController = rememberNavController())
}
