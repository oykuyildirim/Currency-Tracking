package com.kotlinegitim.hw5_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.kotlinegitim.hw5_kotlin.CustomAdaptors.DropDownAdaptor
import com.kotlinegitim.hw5_kotlin.models.Currency
import com.kotlinegitim.hw5_kotlin.services.GetResults
import com.kotlinegitim.hw5_kotlin.settings.SetCurrencyUI


class MainActivity : AppCompatActivity() {

    lateinit var listNew: MutableList<Currency>

    lateinit var ForexBuyingTxt : TextView
    lateinit var ForexSellingTxt : TextView
    lateinit var BanknoteBuyingTxt : TextView
    lateinit var BanknoteSellingTxt : TextView
    lateinit var DateTxt : TextView
    private var progressBar: ProgressBar? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ForexBuyingTxt = findViewById(R.id.ForexBuying)
        ForexSellingTxt = findViewById(R.id.ForexSelling)
        BanknoteBuyingTxt = findViewById(R.id.BanknoteBuying)
        BanknoteSellingTxt = findViewById(R.id.BanknoteSelling)
        DateTxt = findViewById(R.id.Date)


        progressBar = findViewById<ProgressBar>(R.id.progress_Bar) as ProgressBar


        //val moneys= resources.getStringArray(R.array.para)
        val money_image= resources.getStringArray(R.array.images)
        val spinner = findViewById<Spinner>(R.id.spinner_languages)





        var money = GetResults()





        Thread(Runnable {

            progressBar!!.visibility = View.VISIBLE


            val list = money.ReadXml()
            val date = money.GetCurrentDate()



            this@MainActivity.runOnUiThread(java.lang.Runnable {

                val adapter = DropDownAdaptor(money_image,this,list)

                spinner.adapter = adapter


            })


            this@MainActivity.runOnUiThread(java.lang.Runnable {


                var UI = SetCurrencyUI(ForexBuyingTxt,ForexSellingTxt,BanknoteBuyingTxt,BanknoteSellingTxt, DateTxt, list, date, 0)
                UI.SetUI()





                spinner.onItemSelectedListener = object :
                    AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(parent: AdapterView<*>,
                                                view: View, position: Int, id: Long) {


                        var UI2 = SetCurrencyUI(ForexBuyingTxt,ForexSellingTxt,BanknoteBuyingTxt,BanknoteSellingTxt,DateTxt,list,date,position)
                        UI2.SetUI()


                    }

                    override fun onNothingSelected(parent: AdapterView<*>) {

                    }
                }

            })
            progressBar!!.visibility = View.INVISIBLE
        }).start()




    }
}