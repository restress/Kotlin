package com.restress.kotlin.mvp

import android.content.Context
import android.support.annotation.StringRes

/**
 * Created by win10 on 2017/12/13.
 */
interface BaseMvpView {

    fun getContext():Context

    fun showError(error: String?)

    fun showError(@StringRes stringResId: Int)

    fun showMessage(@StringRes srtResId: Int)

    fun showMessage(message: String)
}