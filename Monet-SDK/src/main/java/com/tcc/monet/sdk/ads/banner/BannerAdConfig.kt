package com.tcc.monet.sdk.ads.banner

data class BannerAdConfig(
    val key: String,
    val adUnitIds: List<String>,
    val bannerType: BannerAdType = BannerAdType.Adaptive,
    val enable: Boolean,
    val refreshIntervalSec: Long,
    val timeout: Long
)