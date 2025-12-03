package com.dtech.tcc.monet.sdk

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.dtech.tcc.monet.sdk.databinding.ActivitySplashBinding
import com.tcc.monet.sdk.ads.app_open.AppOpenAdConfig
import com.tcc.monet.sdk.ads.app_open.AppOpenAdsManager
import com.tcc.monet.sdk.ads.banner.BannerAdConfig
import com.tcc.monet.sdk.ads.banner.BannerAdType
import com.tcc.monet.sdk.ads.banner.BannerAdsManager
import com.tcc.monet.sdk.ads.interstitial.InterstitialAdConfig
import com.tcc.monet.sdk.ads.interstitial.InterstitialAdsManager
import com.tcc.monet.sdk.ads.native_ad.NativeAdConfig
import com.tcc.monet.sdk.ads.native_ad.NativeAdsManager
import com.tcc.monet.sdk.ads.reward.RewardAdConfig
import com.tcc.monet.sdk.ads.reward.RewardAdsManager

class SplashActivity: AppCompatActivity() {

    val binding: ActivitySplashBinding by lazy {
        DataBindingUtil.setContentView<ActivitySplashBinding>(this, R.layout.activity_splash).apply {
            lifecycleOwner = this@SplashActivity
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        loadBannerAd()
        loadInterstitialAd()
//        loadNativeAd()
//        loadAppOpenAd()
//        loadReward()
        binding.btn.setOnClickListener {
//            navigateToHome()
            showInter()
//            showAppOpenAd()
//            showReward()
        }
    }

    private fun loadBannerAd() {
        val bannerConfig = BannerAdConfig(
            key = "Main",
            adUnitIds = listOf(
                "ca-app-pub-3940256099942544/9214589741",
                "ca-app-pub-3940256099942544/9214589741"
            ),
            bannerType = BannerAdType.Adaptive,
//            bannerType = BannerType.Inline,
            enable = true,
            refreshIntervalSec = 5,
            timeout = 10
        )
        BannerAdsManager.loadBanner(this, bannerConfig)
    }

    private fun loadInterstitialAd() {
        val interstitialConfig = InterstitialAdConfig(
            key = "Main",
            adUnitIds = listOf(
                "ca-app-pub-3940256099942544/1033173712",
                "ca-app-pub-3940256099942544/1033173712",
            ),
            enable = true,
            timeout = 10
        )
        InterstitialAdsManager.loadInterstitial(this, interstitialConfig)
    }

    private fun loadNativeAd() {
        val nativeConfig = NativeAdConfig(
            key = "Main",
            adUnitIds = listOf(
                "ca-app-pub-3940256099942544/2247696110"
            ),
            enable = true,
            timeout = 5
        )
        NativeAdsManager.loadNative(
            this,
            nativeConfig
        )
    }

    private fun showInter() {
        InterstitialAdsManager.showInterstitial(this, "Main") {
            navigateToHome()
        }
    }

    private fun navigateToHome() {
        Log.e("HAI", "navigateToHome: ")
//        finish()
    }

    private fun loadAppOpenAd() {
        val config = AppOpenAdConfig(
            key = "Main",
            adUnitIds = listOf(
                "ca-app-pub-3940256099942544/9257395921"
            ),
            enable = true,
            timeout = 10
        )
        AppOpenAdsManager.loadAppOpenAd(this, config)
    }

    private fun showAppOpenAd() {
        AppOpenAdsManager.showAppOpenAd(this, "Main") {
            navigateToHome()
        }
    }

    private fun loadReward() {
        val config = RewardAdConfig(
            key = "Main",
            adUnitIds = listOf(
                "ca-app-pub-3940256099942544/5224354917"
            ),
            enable = true,
            timeout = 10
        )
        RewardAdsManager.loadRewardAd(this, config)
    }

    private fun showReward() {
        RewardAdsManager.showRewardAd(
            this,
            "Main"
        )
    }

}