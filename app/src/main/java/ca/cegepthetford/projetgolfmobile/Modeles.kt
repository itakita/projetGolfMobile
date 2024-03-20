package ca.cegepthetford.projetgolfmobile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class TrouGolf(val noTrou: Int, val par: Int) {
    var score: Int by mutableStateOf(0)
    fun manqueScore(): Boolean{
        return score == 0
    }
    fun determinerTermeScore() : String {
        var termeScore = when(score - par){
            -4 -> "Condor"
            -3 -> "Albatros"
            -2 -> "Egle"
            -1 -> "Birdle"
             0 -> "Par"
             1 -> "Bogey"
             2 -> "Double Bogey"
             3 -> "Triple Bogey"
             4 -> "Quadruple Bogey"
             else -> "Quintuple Bogey"
        }
        return termeScore
    }
}
class ParcoursGolfViewModel : ViewModel() {
    val trous = mutableStateListOf<TrouGolf>()
    val banqueTrous = mutableListOf<TrouGolf>()
    init {
        listOf(5,3,4,4,3,4,4,5,3).forEachIndexed { indice, par ->
            banqueTrous.add(TrouGolf(indice+1, par))
        }
        trous.add(banqueTrous[0])
    }
    fun inscrireScore(noTrou: Int, nouveauScore: Int) {
        trous[noTrou-1].score = nouveauScore
        if(noTrou < 9)
            trous.add(banqueTrous[noTrou])
    }
}

