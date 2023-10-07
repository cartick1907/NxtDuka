package com.example.nxtduka.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.nxtduka.R
import com.example.nxtduka.ui.theme.Orange
import com.example.nxtduka.viewModels.DefaultViewModel
import kotlinx.coroutines.Delay
import kotlinx.coroutines.delay

@Composable
fun VerificationPopUp(changePage:()->Unit,onDismiss:()->Unit) {

    var model:DefaultViewModel=viewModel()
    LaunchedEffect(Unit ){
        delay(3000)
        model.showVerification=false
        changePage()

    }
    Dialog(onDismissRequest = {
        onDismiss()
    }) {
        Card(
            colors = CardDefaults.cardColors(Color.White, Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier= Modifier
                    .wrapContentHeight()
                    .padding(16.dp, 24.dp, 16.dp, 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.minisim),
                        contentDescription = null,
                        modifier = Modifier.size(34.dp)
                    )
                    Text(
                        text ="Verify Mobile Number",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(16.dp,8.dp,16.dp,16.dp)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.check_green),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                    Text(
                        text ="Verification Initiated",
                        modifier = Modifier.padding(10.dp)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.check_green),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                    Text(
                        text ="SMS sent from mobile",
                        modifier = Modifier.padding(10.dp)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.check_white),
                        contentDescription = null,
                        modifier = Modifier.size(40.dp)
                    )
                    Text(
                        text ="Verification completed",
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
        }
    }

}