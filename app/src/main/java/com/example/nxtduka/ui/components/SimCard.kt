package com.example.nxtpetask.ui.screen.component

import android.util.Log
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.nxtduka.R
import kotlin.math.round

@Composable
fun SimCard(text1: String,text2:String,isReg:Boolean, onClick: () -> Unit) {

    ElevatedCard(
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                onClick()
                       },
        colors = CardDefaults.cardColors(Color.White, contentColor = Black),
        elevation = CardDefaults.elevatedCardElevation(5.dp),
        shape = RectangleShape
    ) {

        Row(
            Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.minisim),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Column(
                modifier = Modifier
                    .wrapContentHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = text1,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(start = 10.dp),
                    fontWeight = FontWeight.Bold

                )
                Text(
                    text = text2,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .padding(start = 10.dp)
                )
            }
            Spacer(
                modifier= Modifier.weight(1f)
            )
            if(isReg) {
                Image(
                    painter = painterResource(id = R.drawable.check_green),
                    contentDescription = "null",
                )
            }
            else{
                Image(
                    painter = painterResource(id = R.drawable.check_white),
                    contentDescription = "null",
                )
            }



        }
    }
}