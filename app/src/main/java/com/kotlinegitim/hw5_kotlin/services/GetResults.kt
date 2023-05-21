package com.kotlinegitim.hw5_kotlin.services

import com.kotlinegitim.hw5_kotlin.models.Currency
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class GetResults {

    var Date : String =""
    fun ReadXml () : List<Currency> {
        val arr = mutableListOf<Currency>()
        val url = "https://www.tcmb.gov.tr/kurlar/today.xml"
        val doc: Document = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get()
        val elements: Elements = doc.getElementsByTag("Currency")
        for (item in elements) {
            val Isim = item.getElementsByTag("Isim").text()
            val ForexBuying =  CheckNullable(item.getElementsByTag("ForexBuying").text())
            val ForexSelling = CheckNullable(item.getElementsByTag("ForexSelling").text())
            val BanknoteBuying = CheckNullable(item.getElementsByTag("BanknoteBuying").text())
            val BanknoteSelling = CheckNullable(item.getElementsByTag("BanknoteSelling").text())

            val currency = Currency(Isim, ForexBuying, ForexSelling, BanknoteBuying, BanknoteSelling);

            arr.add(currency)
        }


        SetCurrentDate(doc)

        return arr
    }

    fun SetCurrentDate(document: Document){

        Date = document.select("Tarih_Date").attr("Tarih").toString()
    }

    fun GetCurrentDate() : String{

        return Date
    }

    fun CheckNullable(item : String) : String{

        var myItem = item

        if (item.isNullOrEmpty()) {

            myItem = "Veri Girişi Yok"

        }

        return myItem

    }
}