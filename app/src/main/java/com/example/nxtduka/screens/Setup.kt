package com.example.nxtduka.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.nxtduka.R
import com.example.nxtduka.ui.theme.DisabledOrange
import com.example.nxtduka.ui.theme.Orange
import com.example.nxtduka.viewModels.DefaultViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Setup() {

    var model:DefaultViewModel = viewModel()
    var isEnabled by remember {
        mutableStateOf(false)
    }
    var secQues by remember {
        mutableStateOf(false)
    }
    var pin by remember {
        mutableStateOf("")
    }
    var confirmPin by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.setup_header),
            contentDescription = "Banner",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.elevatedCardElevation(10.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(10.dp)
                ) {
                    //Orange bar here
                    Text(
                        text = "Setup Login Pin",
                        fontWeight = FontWeight(500),
                        fontSize = 20.sp,
                    )

                }
                Row (
                    modifier= Modifier.fillMaxWidth()
                ){
                    Text(
                        text = "Enter Pin",
                        fontWeight = FontWeight(400),
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(10.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    if(model.showPassword) {
                        Icon(
                            imageVector = Icons.Filled.VisibilityOff,
                            contentDescription = "Hide",
                            modifier= Modifier
                                .size(20.dp)
                                .offset(x = -30.dp, y = 10.dp)
                                .clickable {
                                    model.showPassword = false
                                }
                        )
                    }
                    else{
                        Icon(
                            imageVector = Icons.Filled.Visibility,
                            contentDescription = "Hide",
                            modifier= Modifier
                                .size(20.dp)
                                .offset(x = -30.dp, y = 10.dp)
                                .clickable {
                                    model.showPassword = true
                                }
                        )
                    }
                }

                Row (

                ){

                    var v1 by remember {
                        mutableStateOf("")
                    }
                    var v2 by remember {
                        mutableStateOf("")
                    }
                    var v3 by remember {
                        mutableStateOf("")
                    }
                    var v4 by remember {
                        mutableStateOf("")
                    }
                    var v5 by remember {
                        mutableStateOf("")
                    }
                    var v6 by remember {
                        mutableStateOf("")
                    }
                    OutlinedTextField(
                        value =v1,
                        onValueChange = {
                            if(it.length<=1)
                                v1 = it
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Phone,
                            imeAction = ImeAction.Done,
                        ),
                        modifier = Modifier
                            .padding(10.dp)
                            .wrapContentSize()
                            .width(40.dp)
                            .clip(MaterialTheme.shapes.medium),
                        visualTransformation = if (model.showPassword)
                                VisualTransformation.None
                            else
                                PasswordVisualTransformation(),


                        )
                    OutlinedTextField(
                        value =v2,
                        onValueChange = {
                            if(it.length<=1)
                                v2 = it
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Phone,
                            imeAction = ImeAction.Done,
                        ),
                        modifier = Modifier
                            .padding(10.dp)
                            .width(40.dp)
                            .clip(MaterialTheme.shapes.medium),
                        visualTransformation = if (model.showPassword)
                                VisualTransformation.None
                            else
                                PasswordVisualTransformation(),
                    )

                    OutlinedTextField(
                        value =v3,
                        onValueChange = {
                            if(it.length<=1)
                                v3 = it
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Phone,
                            imeAction = ImeAction.Done,
                        ),
                        modifier = Modifier
                            .padding(10.dp)
                            .width(40.dp)
                            .clip(MaterialTheme.shapes.medium),
                        visualTransformation = if (model.showPassword)
                                VisualTransformation.None
                            else
                                PasswordVisualTransformation(),
                    )
                    OutlinedTextField(
                        value =v4,
                        onValueChange = {
                            if(it.length<=1)
                                v4 = it
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Phone,
                            imeAction = ImeAction.Done,
                        ),
                        modifier = Modifier
                            .padding(10.dp)
                            .width(40.dp)
                            .clip(MaterialTheme.shapes.medium),
                        visualTransformation = if (model.showPassword)
                                VisualTransformation.None
                            else
                                PasswordVisualTransformation(),
                    )
                    OutlinedTextField(
                        value =v5,
                        onValueChange = {
                            if(it.length<=1)
                                v5 = it
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Phone,
                            imeAction = ImeAction.Done,
                        ),
                        modifier = Modifier
                            .padding(10.dp)
                            .width(40.dp)
                            .clip(MaterialTheme.shapes.medium),
                        visualTransformation = if (model.showPassword)
                                VisualTransformation.None
                            else
                                PasswordVisualTransformation(),
                    )
                    OutlinedTextField(
                        value =v6,
                        onValueChange = {
                            if(it.length<=1)
                                v6 = it
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Phone,
                            imeAction = ImeAction.Done,
                        ),
                        modifier = Modifier
                            .padding(10.dp)
                            .width(40.dp)
                            .clip(MaterialTheme.shapes.medium),
                        visualTransformation = if (model.showPassword)
                                VisualTransformation.None
                            else
                                PasswordVisualTransformation(),
                    )
                    pin=v1+v2+v3+v4+v5+v6
                }
                Text(
                    text = "Confirm Pin",
                    fontWeight = FontWeight(400),
                    fontSize = 15.sp,
                    modifier = Modifier.padding(10.dp)
                )
                Row (

                ){
                    var v1 by remember {
                        mutableStateOf("")
                    }
                    var v2 by remember {
                        mutableStateOf("")
                    }
                    var v3 by remember {
                        mutableStateOf("")
                    }
                    var v4 by remember {
                        mutableStateOf("")
                    }
                    var v5 by remember {
                        mutableStateOf("")
                    }
                    var v6 by remember {
                        mutableStateOf("")
                    }
                    OutlinedTextField(
                        value =v1,
                        onValueChange = {
                            if(it.length<=1)
                                v1 = it
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Phone,
                            imeAction = ImeAction.Done,
                        ),
                        modifier = Modifier
                            .padding(10.dp)
                            .wrapContentSize()
                            .width(40.dp)
                            .clip(MaterialTheme.shapes.medium),
                        visualTransformation = if (model.showPassword)
                                VisualTransformation.None
                            else
                                PasswordVisualTransformation(),
                    )
                    OutlinedTextField(
                        value =v2,
                        onValueChange = {
                            if(it.length<=1)
                                v2 = it
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Phone,
                            imeAction = ImeAction.Done,
                        ),
                        modifier = Modifier
                            .padding(10.dp)
                            .width(40.dp)
                            .clip(MaterialTheme.shapes.medium),
                        visualTransformation = if (model.showPassword)
                                VisualTransformation.None
                            else
                                PasswordVisualTransformation(),
                    )

                    OutlinedTextField(
                        value =v3,
                        onValueChange = {
                            if(it.length<=1)
                                v3 = it
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Phone,
                            imeAction = ImeAction.Done,
                        ),
                        modifier = Modifier
                            .padding(10.dp)
                            .width(40.dp)
                            .clip(MaterialTheme.shapes.medium),
                        visualTransformation = if (model.showPassword)
                                VisualTransformation.None
                            else
                                PasswordVisualTransformation(),
                    )
                    OutlinedTextField(
                        value =v4,
                        onValueChange = {
                            if(it.length<=1)
                                v4 = it
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Phone,
                            imeAction = ImeAction.Done,
                        ),
                        modifier = Modifier
                            .padding(10.dp)
                            .width(40.dp)
                            .clip(MaterialTheme.shapes.medium),
                        visualTransformation = if (model.showPassword)
                                VisualTransformation.None
                            else
                                PasswordVisualTransformation(),
                    )
                    OutlinedTextField(
                        value =v5,
                        onValueChange = {
                            if(it.length<=1)
                                v5 = it
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Phone,
                            imeAction = ImeAction.Done,
                        ),
                        modifier = Modifier
                            .padding(10.dp)
                            .width(40.dp)
                            .clip(MaterialTheme.shapes.medium),
                        visualTransformation = if (model.showPassword)
                                VisualTransformation.None
                            else
                                PasswordVisualTransformation(),
                    )
                    OutlinedTextField(
                        value =v6,
                        onValueChange = {
                            if(it.length<=1)
                                v6 = it
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Phone,
                            imeAction = ImeAction.Done,
                        ),
                        modifier = Modifier
                            .padding(10.dp)
                            .width(40.dp)
                            .clip(MaterialTheme.shapes.medium),
                        visualTransformation = if (model.showPassword)
                                VisualTransformation.None
                            else
                                PasswordVisualTransformation(),
                    )
                    confirmPin=v1+v2+v3+v4+v5+v6
                }
            }

        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.elevatedCardElevation(10.dp)
        ) {
            Text(
                text = "Secret Questions",
                fontWeight = FontWeight(500),
                fontSize = 20.sp,
                modifier = Modifier.padding(16.dp)
            )
            var expanded by remember {
                mutableStateOf(false)
            }
            var list = listOf<String>("Mother Last Name", "Best Friend Name", "Your Pet Name")
            var icon= Icons.Filled.KeyboardArrowDown
            var choice by remember {
                mutableStateOf("")
            }
            if(expanded){
                icon = Icons.Filled.KeyboardArrowUp
            }
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange ={expanded=it},
                modifier= Modifier
                    .padding(10.dp)
                    .align(Alignment.CenterHorizontally),
            )
            {
                OutlinedTextField(
                    value = choice,
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier
                        .menuAnchor()
                        .padding(10.dp),
                    label = { Text(text = "Select Question")},
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                    },
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded=false }) {
                    DropdownMenuItem(text = { Text(text = list[0]) }, onClick = {
                        expanded=false
                        choice=list[0]
                    })
                    DropdownMenuItem(text = { Text(text = list[1]) }, onClick = {
                        expanded=false
                        choice=list[1]
                    })
                    DropdownMenuItem(text = { Text(text = list[2]) }, onClick = {
                        expanded=false
                        choice=list[2]
                    })
                }
            }

            if(choice!=""){
                var ans by remember {
                    mutableStateOf("")
                }
                OutlinedTextField(
                    value =ans ,
                    onValueChange = {
                        ans=it
                        if(ans.isNotEmpty())
                            isEnabled=true
                    },
                    modifier= Modifier
                        .clip(MaterialTheme.shapes.medium)
                        .align(Alignment.CenterHorizontally)
                        .padding(10.dp),
                    label = {
                        Text(text = "Enter your Answer")
                    }
                )
            }


        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { },
            enabled = isEnabled && (pin==confirmPin),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonColors(
                containerColor = Orange,
                disabledContainerColor = DisabledOrange,
                contentColor = Color.White,
                disabledContentColor = Color.White
            )
        )
        {
            Text(
                text="Proceed",
                modifier = Modifier
                    .padding(10.dp),
                fontSize = 20.sp
            )
        }
    }
}