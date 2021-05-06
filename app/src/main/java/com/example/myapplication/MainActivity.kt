package com.example.myapplication

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
   lateinit var diceText: TextView
    lateinit var diceButton: Button
   lateinit var diceImage:ImageView
    lateinit var sendButton: Button
    lateinit var sendText:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         diceText=findViewById(R.id.diceText)
         diceButton=findViewById(R.id.diceButton)
         diceImage=findViewById(R.id.diceImage)
         sendText=findViewById(R.id.sendText)
        sendButton=findViewById(R.id.sendButton)


        diceButton.setOnClickListener{
           changeText()
        }
        sendButton.setOnClickListener{
            sendText()
        }

 // println("on create")
    }
    private fun sendText(){
        val intent=Intent(this,SecondActivity::class.java)
        intent.putExtra("send",sendText.text.toString())
        startActivity(intent)
    }
    private fun changeText(){
        val randomNumber=(1..6).random()
        val drawableResource=when(randomNumber){
            1->R.drawable.dice1
            2->R.drawable.dice2
            3->R.drawable.dice3
            4->R.drawable.dice4
            5->R.drawable.dice5
            else->R.drawable.dice6
        }
        diceImage.setImageResource(drawableResource)
      diceText.text=randomNumber.toString()
       //mesaj gösterme
        Toast.makeText(this,"Cliked",Toast.LENGTH_SHORT).show()

    }







 /*   override fun onStart() {
        super.onStart()
        println("on start")
    }

    override fun onResume() {
        super.onResume()
        println("on resume")
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

  */
}