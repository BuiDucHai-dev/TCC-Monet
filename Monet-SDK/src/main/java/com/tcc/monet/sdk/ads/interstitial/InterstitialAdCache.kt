package com.tcc.monet.sdk.ads.interstitial

import com.google.android.gms.ads.interstitial.InterstitialAd

internal data class InterstitialAdCache(
    val interstitialAd: InterstitialAd,
    val isUse: Boolean
)
