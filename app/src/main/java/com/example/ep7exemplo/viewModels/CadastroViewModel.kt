package com.example.ep7exemplo.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class CadastroViewModel: ViewModel() {
    val idade = MutableLiveData<String>()
    var nascimento: String = ""
        set(value){
            val data = textoPraData(value)
            idade.value = dataPraIdade(data).toString()
            field = value
        }

    fun textoPraData(texto: String): Date  =
        SimpleDateFormat("dd/MM/yyyy").parse(texto)

    fun dataPraIdade(data: Date): Int {
        val a = Calendar.getInstance().apply {
            time = data
        }
        val b = Calendar.getInstance() //Data Atual, vulgo hoje
        var diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR)
        return if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH) ||
                a.get(Calendar.MONTH) == b.get(Calendar.MONTH) &&
                a.get(Calendar.DATE) > b.get(Calendar.DATE)
        ) {
            --diff
        }else diff
    }
}