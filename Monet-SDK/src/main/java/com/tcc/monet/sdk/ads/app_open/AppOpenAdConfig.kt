package com.tcc.monet.sdk.ads.app_open

data class AppOpenAdConfig(
    val key: String,
    val adUnitIds: List<String>,
    val enable: Boolean,
    val timeout: Long
)