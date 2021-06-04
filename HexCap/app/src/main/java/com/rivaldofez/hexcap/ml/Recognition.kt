package com.rivaldofez.hexcap.ml

data class Recognition(val name:String, val confidence:Float, val label:String ) {

    // For easy logging
    override fun toString():String{
        return "$label / $probabilityString"
    }

    // Output probability as a string to enable easy data binding
    val probabilityString = String.format("%.1f%%", confidence * 100.0f)

}