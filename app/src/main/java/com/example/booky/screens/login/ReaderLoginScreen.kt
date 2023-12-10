package com.example.booky.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier

import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.booky.componets.ReaderLogo


@Composable
fun LoginScreen(navController: NavHostController) {


    Surface (
        modifier =
        Modifier.fillMaxSize(),

    ){
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ReaderLogo()
            UserForm(loading = false,
                isAccountCreatedListener = false,
                onDone = { email, pass ->
                })

        }

    }

}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun UserForm(
    loading: Boolean=false,
    isAccountCreatedListener: Boolean=false,
    onDone:(String,String)->Unit={ email,pass ->},
){
    val email= rememberSaveable { mutableStateOf("") }
    val password= rememberSaveable { mutableStateOf("") }
    val passwordVisibility= remember { mutableStateOf(false) }
    val keyboardController=LocalSoftwareKeyboardController.current
    val valid = remember (email.value, password.value){
        email.value.trim().isNotEmpty() && password.value.trim().isNotEmpty()
    }


    val modifier= Modifier
        .height(230.dp)
        .background(MaterialTheme.colorScheme.background)
        .verticalScroll(rememberScrollState())



    val (username, setUsername) = remember { mutableStateOf("") }

    Column(
        modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        TextField(
            value = username,
            onValueChange = { setUsername(it) }, // Update the username state
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            placeholder = { Text("Username") }
        )
        EmailInput(emailState =email,
            enabled = !loading,
            )

        PasswordInput(
       modifier=Modifier.padding(top = 1.dp),
            passwordState=password,
            enabled=true,
            passwordVisibility = passwordVisibility,
            onAction = KeyboardActions{
                         if ( !valid) return@KeyboardActions
                onDone(email.value.trim(),password.value.trim())
            }
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun PasswordInput(modifier: Modifier,
                  passwordState: MutableState<String>,
                  enabled: Boolean,
                  imeAction: ImeAction = ImeAction.Done,
                  passwordVisibility: MutableState<Boolean>,
                  onAction: KeyboardActions= KeyboardActions.Default) {

    val visualTransformation = if (passwordVisibility.value)
        VisualTransformation.None  else
        PasswordVisualTransformation()


    OutlinedTextField(
        value = passwordState.value,
        onValueChange = {
            passwordState.value=it
        },
        label = { Text(text = "Password") },
        singleLine = true,
        textStyle = TextStyle(fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onBackground),
        modifier= modifier
            .padding(
                start = 10.dp,
                end = 10.dp,
                bottom = 10.dp
            )
            .fillMaxWidth(),
        enabled = enabled,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = imeAction
        ),
        keyboardActions = onAction,
        visualTransformation = visualTransformation,
        trailingIcon = {
            PasswordVisibilty(passwordVisibility = passwordVisibility)
        },
    )
}

@Composable
fun PasswordVisibilty(passwordVisibility: MutableState<Boolean>) {


    val visible=passwordVisibility.value

    IconButton(onClick = {
        passwordVisibility.value= !visible
    }) {
        Icons.Default.Close

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField(modifier: Modifier=Modifier,
               labelId:String,
               valueState:MutableState<String>,
               enabled:Boolean,
               isSingleLine:Boolean = true,
               imeAction:ImeAction = ImeAction.Next,
               keyBoardType: KeyboardType = KeyboardType.Text,
             //  onImeAction:KeyboardActions= KeyboardActions.Default,
               ){

    OutlinedTextField(
        value =valueState.value ,
        onValueChange ={
            valueState.value=it
        },
        label = { Text(text = labelId) },
        singleLine = isSingleLine,
        textStyle = TextStyle(fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onBackground),
        modifier = modifier
            .padding(
                start = 10.dp,
                end = 10.dp,
                bottom = 10.dp
            )
            .fillMaxSize(),
        enabled = enabled,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyBoardType,
            imeAction = imeAction
        ),
//keyboardActions = onImeAction,
        )




}

@Composable
fun EmailInput(modifier: Modifier=Modifier,
               emailState:MutableState<String>,
               labelId:String = "Email",
               enabled:Boolean = true,
               imeAction:ImeAction = ImeAction.Next,
               onAction:KeyboardActions= KeyboardActions.Default,
               ){
InputField(
    labelId = labelId,
    valueState =emailState ,
    enabled = enabled,
    keyBoardType = KeyboardType.Email,
 //   imeAction = imeAction,
 //   onImeAction = onAction
)


}
