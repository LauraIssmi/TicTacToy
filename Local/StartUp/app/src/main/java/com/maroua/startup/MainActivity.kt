package com.maroua.startup

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


    }

    fun buSelect(view : View){
     val buChoise= view as Button
        var cellID=0
        when(buChoise.id)
        {
            R.id.bu1 -> cellID=1
            R.id.bu2 -> cellID=2
            R.id.bu3 -> cellID=3
            R.id.bu4 -> cellID=4
            R.id.bu5 -> cellID=5
            R.id.bu6 -> cellID=6
            R.id.bu7 -> cellID=7
            R.id.bu8 -> cellID=8
            R.id.bu9 -> cellID=9

        }
playGame(cellID,buChoise)
    }
    val play1=ArrayList<Int>()
    val play2=ArrayList<Int>()
    var ActivePlayer=1

fun playGame(cellID: Int, buChoise : Button){
if(ActivePlayer==1)
{
    buChoise.text="X"
    buChoise.setBackgroundResource(R.color.Color1Rose)
    play1.add(cellID)
    ActivePlayer=2
    AutoPlay()


}else{
    buChoise.text="O"
    buChoise.setBackgroundResource(R.color.Color2fochia)
    play2.add(cellID)
    ActivePlayer=1

}
    buChoise.isEnabled=false
    checkWinner()


}
    fun AutoPlay()
    {
        var cellulesVides = ArrayList<Int>()
        for(cellId in 1..9)
        {
            if(!(play1.contains(cellId) || play2.contains(cellId)))
            {
                cellulesVides.add(cellId)
            }
        }
        val r= java.util.Random()
        val randIndex=r.nextInt(cellulesVides.size-0)
        val cellulId=cellulesVides[randIndex]
        var buSelect : Button?
        when(cellulId){
            1 -> buSelect=bu1
            2 -> buSelect=bu2
            3 -> buSelect=bu3
            4 -> buSelect=bu4
            5 -> buSelect=bu5
            6 -> buSelect=bu6
            7 -> buSelect=bu7
            8 -> buSelect=bu8
            9 -> buSelect=bu9
            else ->buSelect=bu1
        }
        playGame(cellulId,buSelect)

    }
    fun checkWinner() : Boolean{
        var winner = -1
        //ligne1
        if(play1.contains(1) && play1.contains(2) && play1.contains(3)){
            winner=1
        }
        if(play2.contains(1) && play2.contains(2) && play2.contains(3)){
            winner=2
        }
        //ligne2
        if(play1.contains(4) && play1.contains(5) && play1.contains(6)){
            winner=1
        }
        if(play2.contains(4) && play2.contains(5) && play2.contains(6)){
            winner=2
        }
        //ligne3
        if(play1.contains(7) && play1.contains(8) && play1.contains(9)){
            winner=1
        }
        if(play2.contains(7) && play2.contains(8) && play2.contains(9)){
            winner=2
        }
        //col1
        if(play1.contains(1) && play1.contains(4) && play1.contains(7)){
            winner=1
        }
        if(play2.contains(1) && play2.contains(4) && play2.contains(7)){
            winner=2
        }
        //col2
        if(play1.contains(2) && play1.contains(5) && play1.contains(8)){
            winner=1
        }
        if(play2.contains(2) && play2.contains(5) && play2.contains(8)){
            winner=2
        }
        //col3
        if(play1.contains(3) && play1.contains(6) && play1.contains(9)){
            winner=1
        }
        if(play2.contains(3) && play2.contains(6) && play2.contains(9)){
            winner=2
        }
        //diagonale1
        if(play1.contains(1) && play1.contains(5) && play1.contains(9)){
            winner=1
        }
        if(play2.contains(1) && play2.contains(5) && play2.contains(9)){
            winner=2
        }
        //diag2
        //diagonale1
        if(play1.contains(3) && play1.contains(5) && play1.contains(7)){
            winner=1
        }
        if(play2.contains(3) && play2.contains(5) && play2.contains(7)){
            winner=2
        }
        if (winner ==1)
        {
            Toast.makeText(this,"player 1 is the Winner",Toast.LENGTH_LONG).show()
            return true

        }else
        if(winner==2){
            Toast.makeText(this,"player 2 is the Winner",Toast.LENGTH_LONG).show()
            return true
        }
        return false
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
