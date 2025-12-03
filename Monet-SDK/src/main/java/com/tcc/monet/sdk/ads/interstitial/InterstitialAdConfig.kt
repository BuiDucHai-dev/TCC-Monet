package com.tcc.monet.sdk.ads.interstitial

data class InterstitialAdConfig(
    val key: String,
    val adUnitIds: List<String>,
    val enable: Boolean,
    val timeout: Long
)