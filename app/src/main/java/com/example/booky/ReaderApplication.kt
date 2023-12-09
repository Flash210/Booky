package com.example.booky

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class ReaderApplication :Application(){
}


// @HiltAndroidApp
/*
The @HiltAndroidApp annotation is
 used in Dagger Hilt to mark an Android Application class as
 the application-level component. When you annotate your Application
  class with @HiltAndroidApp, Dagger Hilt generates the necessary
components and setup code to enable dependency injection throughout your application.
 */