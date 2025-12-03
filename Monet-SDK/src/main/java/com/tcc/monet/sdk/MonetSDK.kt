package com.tcc.monet.sdk

import android.content.Context
import com.tcc.monet.sdk.billing.PlayBillingManager
import com.tcc.monet.sdk.ump.GoogleConsent

object MonetSDK {

    fun init(context: Context) {
        GoogleConsent.initialize(context.applicationContext)
        PlayBillingManager.init(context.applicationContext)
    }
}