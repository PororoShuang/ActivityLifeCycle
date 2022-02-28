package com.example.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.activitylifecycle.mymodels.MyData

class MainActivity : AppCompatActivity() {

    //myValue here refers to the MyData class
    private lateinit var myValue : MyData

    //var myValue : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("MainActivity","onCreate")

        //create one object when view is created, view destroyed, this model will still stay
        //Activity destroyed but view will not be destroyed
        myValue=ViewModelProvider(this).get(com.example.activitylifecycle.mymodels.MyData::class.java) //:: refers to class name
        //or  myValue=ViewModelProvider(this).get(MyData::class.java)

        val btn : Button = findViewById(R.id.btnOk)
        val tvName : TextView = findViewById(R.id.tvName)
        val tvAge : TextView = findViewById(R.id.tvAge)

        myValue.name.observe(this,Observer{
          newName -> tvName.text = newName //when name is changed, automatically update

        })

        myValue.age.observe(this,Observer{
                newAge -> tvAge.text = newAge.toString() //when name is changed, automatically update

        })

//        val tv : TextView = findViewById(R.id.tvResult)

//        if (savedInstanceState!=null){
//            myValue = savedInstanceState.getString("value").toString()
//            tv.text = myValue
//        }

        //Even after rotate, the data will still show
        //not mutable is myValue.name
        if(myValue.name.value!=null){
//            tv.text=myValue.name
//            display()
        }

        //display hello world first
//        if(myValue.name!=""){
//            tv.text=myValue.name
//        }

        btn.setOnClickListener(){
//            myValue.name="John"
//            myValue.age = 21

            //for Mutable object class accessing value
            myValue.name.value="John"
            myValue.age.value = 21
//            tv.text=myValue.name
//            display()


//            myValue = "123456"
//            tv.text= myValue

        }

            //if another button to show age, and didn't call display, the age will not be shown
//        btn2.setOnCLickListener(){
//            myValue.age=50
//        }



    }

//    fun display(){
//        val tv : TextView = findViewById(R.id.tvResult)
//        tv.text=myValue.name
//    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putString("value",myValue)
//    }

    override fun onStart(){
        super.onStart()
        Log.i("MainActivity","onCreate")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainActivity","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainActivity","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainActivity","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainActivity","onDestroy")
    }
}