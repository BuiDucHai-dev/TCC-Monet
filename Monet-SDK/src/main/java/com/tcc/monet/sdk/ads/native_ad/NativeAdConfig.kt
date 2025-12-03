package com.tcc.monet.sdk.ads.native_ad

data class NativeAdConfig(
    val key: String,
    val adUnitIds: List<String>,
    val enable: Boolean,
    val timeout: Long
)
