package com.example.hearme_jc.data.viewmodel

import android.annotation.SuppressLint
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.hearme_jc.data.model.Chart
import com.example.hearme_jc.data.model.ChartData

class ChartsViewModel : ViewModel() {
    @SuppressLint("MutableCollectionMutableState")
    private val _charts: MutableState<ArrayList<Chart>> = mutableStateOf(ArrayList())
    val chart = _charts

    init {
        _charts.value = ChartData.dataChart()
    }

    fun GetAllCharts() = chart.value

}