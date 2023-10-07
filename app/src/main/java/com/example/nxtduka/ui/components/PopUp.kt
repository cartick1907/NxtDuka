package com.example.nxtpetask.ui.screen.component

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@Composable
fun popUp(text1: String,text2:String, onDismiss: ()->Unit) {

    var viewModel:DefaultViewModel = viewModel()
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
                       text ="Confirm SIM",
                       fontWeight = FontWeight.Bold,
                       modifier = Modifier.padding(16.dp,8.dp,16.dp,16.dp)
                   )
               }
                Text(
                    text ="You have selected $text1 - $text2 Do you want to proceed?",
                    modifier = Modifier.padding(16.dp)
                    )
                Row(
                    modifier=Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text="Change SIM",
                        modifier = Modifier
                            .clickable {
                                onDismiss()
                            }
                            .padding(10.dp)
                    )
                    Text(
                        text ="Proceed",
                        color = Orange,
                        modifier = Modifier
                            .padding(10.dp)
                            .clickable {
                                viewModel.showVerification=true
                            }
                    )
                }

            }
        }
    }
}