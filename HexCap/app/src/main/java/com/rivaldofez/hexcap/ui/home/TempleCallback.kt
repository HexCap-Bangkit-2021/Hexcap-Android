package com.rivaldofez.hexcap.ui.home

import com.rivaldofez.hexcap.data.source.model.Temple

interface TempleCallback {
    fun onTempleClick(temple: Temple)
}