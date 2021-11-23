package com.artesia.mobile.ui.home

import com.artesia.mobile.data.source.model.Temple

interface TempleCallback {
    fun onTempleClick(temple: Temple)
}