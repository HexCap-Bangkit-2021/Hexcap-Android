package com.rivaldofez.hexcap.ml

data class Recognition(val label:String, val confidence:Float) {

    // For easy logging
    override fun toString():String{
        return "$label / $probabilityString"
    }

    // Output probability as a string to enable easy data binding
    val probabilityString = String.format("%.1f%%", confidence * 100.0f)

}