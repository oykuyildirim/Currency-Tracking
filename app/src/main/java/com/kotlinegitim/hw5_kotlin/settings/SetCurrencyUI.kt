package com.kotlinegitim.hw5_kotlin.settings

import android.widget.TextView
import com.kotlinegitim.hw5_kotlin.models.Currency

class SetCurrencyUI(forexBuying :TextView,
                    forexSelling : TextView,
                    banknoteBuying : TextView,
                    banknoteSelling : TextView,
                    currentDate : TextView,
                    list: List<Currency>,
                    date:String,
                    position : Int
)

{
    var ForexBuying = forexBuying
    var ForexSelling = forexSelling
    var BanknoteBuying = banknoteBuying
    var BanknoteSelling = banknoteSelling
    var CurrentDate = currentDate
    var List = list
    var Position = position
    var Date = date




    fun SetUI(){

        ForexBuying.text = List.get(Position).ForexBuying
        ForexSelling.text = List.get(Position).ForexSelling
        BanknoteBuying.text = List.get(Position).BanknoteBuying
        BanknoteSelling.text = List.get(Position).BanknoteSelling
        CurrentDate.text = Date

    }

}








