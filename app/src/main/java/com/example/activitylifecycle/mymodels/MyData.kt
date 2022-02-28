package com.example.activitylifecycle.mymodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyData : ViewModel(){

//    var name:String =""
//    var age:Int=0

    //Live update changes

                //object
    var name = MutableLiveData<String>()
    var age = MutableLiveData<Int>()




}