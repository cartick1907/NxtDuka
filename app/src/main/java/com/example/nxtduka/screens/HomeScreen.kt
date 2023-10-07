package com.example.nxtduka.screens

import android.content.Context
import android.telephony.TelephonyManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.getSystemService
import com.example.nxtduka.R
import com.example.nxtpetask.ui.screen.component.SimCard
import android.Manifest
import android.content.pm.PackageManager
import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.ui.window.Popup
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.nxtduka.ui.components.VerificationPopUp
import com.example.nxtduka.viewModels.DefaultViewModel
import com.example.nxtpetask.ui.screen.component.popUp

@Composable
fun HomeScreen(navController: NavController) {

    var viewModel: DefaultViewModel = viewModel()
    Column (
        modifier = Modifier.fillMaxSize(),
    ){
        Image(
            painter = painterResource(id = R.drawable.logo_nobg),
            contentDescription ="Banner",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .offset(y = -26.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                colors = CardDefaults.cardColors(Color.White),
                elevation = CardDefaults.elevatedCardElevation(10.dp)
            ) {
                // Card content goes here
                Text(
                    text = "Verify Mobile Number",
                    modifier = Modifier
                        .padding(top = 80.dp, start = 10.dp, end = 10.dp, bottom = 5.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Text(
                    text = "We need to send an SMS from your phone to verify and register your number on nxtduka",
                    modifier = Modifier.padding(16.dp),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight(400),
                    fontSize = 17.sp
                )
            }

            Image(
                painter = painterResource(id = R.drawable.simcard),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .align(Alignment.TopCenter)
                    .offset(y = -70.dp)
            )
        }
        Text(
            text = "Please select SIM registered with your bank & Ensure mobile data is enabled",
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight(300),
            fontSize = 15.sp
        )
//        var simName by remember { mutableStateOf("Unknown SIM Name") }
//        var simNumber by remember { mutableStateOf("Unknown SIM Number") }
//
//        val telephonyManager = getSystemService(context, Context.TELEPHONY_SERVICE) as? TelephonyManager
//
//        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
//            val simInfo = telephonyManager?.simOperatorName
//            val phoneNumber = telephonyManager?.line1Number
//
//            if (simInfo != null) {
//                simName = "SIM Name: $simInfo"
//            }
//
//            if (phoneNumber != null) {
//                simNumber = "SIM Number: $phoneNumber"
//            }
//        } else {
//            simName = "SIM Name: Permission not granted"
//            simNumber = "SIM Number: Permission not granted"
//        }
        var simname ="Airtel"
        var simnumber ="9868XXXXXX"
        var selectedSIM by remember {
            mutableStateOf("")
        }
        var selectedNumber by remember {
            mutableStateOf("")
        }
        Column (
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top
        ){

            SimCard(text1 = simname, text2 = simnumber,true ) {
                Log.d("simcard","clicked")
                selectedSIM=simname
                selectedNumber=simnumber
                viewModel.showConfirmation=true
            }
            SimCard(text1 = "Unavailable", text2 = "Unavailabe",false) {
            }
        }
        Spacer(modifier=Modifier.weight(1f))
        Text(
            text = "By selecting a SIM I agree to the Terms and Conditions.Regular carrier charges may apply",
//            text= viewModel.showConfirmation.toString(),
            textAlign = TextAlign.Center,
            fontSize = 10.sp,
            fontWeight = FontWeight(400),
            modifier = Modifier.padding(20.dp)
        )
        if(viewModel.showConfirmation){
            popUp(text1 = simname, text2 =simnumber ){
                viewModel.showConfirmation=false
            }
        }
        if(viewModel.showVerification){
            viewModel.showConfirmation=false
            VerificationPopUp({ navController.navigate("Setup") }) {
                viewModel.showVerification=false
            }
        }


    }


}