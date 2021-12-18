package com.example.ticktactoe

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    val btn1 = findViewById<Button>(R.id.btn1)
    val btn2 = findViewById<Button>(R.id.btn2)
    val btn3 = findViewById<Button>(R.id.btn3)
    val btn4 = findViewById<Button>(R.id.btn4)
    val btn5 = findViewById<Button>(R.id.btn5)
    val btn6 = findViewById<Button>(R.id.btn6)
    val btn7 = findViewById<Button>(R.id.btn7)
    val btn8 = findViewById<Button>(R.id.btn8)
    val btn9 = findViewById<Button>(R.id.btn9)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnClick(view: View)
    {
        val btnSelected:Button = view as Button

        var cellId = 0
        when(btnSelected.id)
        {
            R.id.btn1 -> cellId = 1
            R.id.btn2 -> cellId = 2
            R.id.btn3 -> cellId = 3
            R.id.btn4 -> cellId = 4
            R.id.btn5 -> cellId = 5
            R.id.btn6 -> cellId = 6
            R.id.btn7 -> cellId = 7
            R.id.btn8 -> cellId = 8
            R.id.btn9 -> cellId = 9
        }

        playGame(cellId, btnSelected)
    }

    var activePlayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    fun playGame(cellId:Int, btnSelected:Button)
    {
        if( activePlayer == 1 ){
            btnSelected.text = "X"
            btnSelected.setBackgroundResource(R.color.blue)
            player1.add(cellId)
            activePlayer = 2
            autoPlay()

        }else{

            btnSelected.text = "O"
            btnSelected.setBackgroundResource(R.color.darkGreen)
            player2.add(cellId)
            activePlayer = 1

        }

        btnSelected.isEnabled = false

        checkWinner()
    }

    fun checkWinner()
    {
        var winner = -1

        // row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }


        // row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }

        // row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }


        // col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }


        // col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }


        // col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }



        if (winner == 1) {
            player1WinsCounts += 1
            Toast.makeText(this, "Player 1 win the game", Toast.LENGTH_LONG).show()
            restartGame()

        } else if (winner == 2) {
            player2WinsCounts += 1
            Toast.makeText(this, "Player 2 win the game", Toast.LENGTH_LONG).show()
            restartGame()
        }

    }

    fun autoPlay()
    {
        var emptyCells = ArrayList<Int>()

        for( cellId in 1..9)
        {
            if( !(player1.contains(cellId) || player2.contains(cellId)))
            {
                emptyCells.add(cellId)
            }
        }

        if(emptyCells.size==0)
        {
            restartGame()
        }


        val r = Random()
        val randIndex = r.nextInt(emptyCells.size )
        val cellId = emptyCells[randIndex]

        var btnSelected:Button? = null

        btnSelected =  when(cellId){
            1-> btn1
            2-> btn2
            3-> btn3
            4-> btn4
            5-> btn5
            6-> btn6
            7-> btn7
            8-> btn8
            9-> btn9
            else ->{ btn1}
        }

        playGame(cellId, btnSelected)

    }



    var player1WinsCounts = 0
    var player2WinsCounts = 0

    fun restartGame(){

        activePlayer = 1
        player1.clear()
        player2.clear()

        for(cellId in 1..9){

            var btnSelected:Button? = when(cellId){
                1-> btn1
                2-> btn2
                3-> btn3
                4-> btn4
                5-> btn5
                6-> btn6
                7-> btn7
                8-> btn8
                9-> btn9
                else ->{ btn1}

            }
            btnSelected!!.text = ""
            btnSelected!!.setBackgroundResource(R.color.whiteBackground)
            btnSelected!!.isEnabled = true
        }

        Toast.makeText(this,"Player1: $player1WinsCounts, Player2: $player2WinsCounts",
                Toast.LENGTH_LONG).show()


    }
}

