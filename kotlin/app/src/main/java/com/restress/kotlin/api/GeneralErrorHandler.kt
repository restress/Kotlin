package com.restress.kotlin.api

import android.support.annotation.StringRes
import android.text.TextUtils
import android.view.View
import com.restress.kotlin.R
import com.restress.kotlin.mvp.BaseMvpView
import retrofit2.adapter.rxjava.HttpException
import rx.functions.Action1
import java.lang.ref.WeakReference
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException


/**
 * Created by win10 on 2017/12/13.
 */
class GeneralErrorHandler(view: BaseMvpView? =null,
                          private val mShowError: Boolean = false,
                          val onFailure:(Throwable, ErrorBody?, Boolean) -> Unit)
    :Action1<Throwable>{

    private val mViewReference: WeakReference<BaseMvpView>

    init {
        mViewReference = WeakReference<BaseMvpView>(view)
    }

    override fun call(throwable: Throwable) {
        var isNetwork = false
        var errorBody: ErrorBody? =null
        if (isNetworkError(throwable)){
            isNetwork = true
            showMessage(R.string.internet_connection_unavailable)
        }else if (throwable is HttpException){
           errorBody = ErrorBody.parseError(throwable.response())
            if(errorBody != null){
                handleError(errorBody)
            }
        }
        onFailure(throwable,errorBody,isNetwork)
    }

    private fun isNetworkError(throwable: Throwable): Boolean{
        return throwable is SocketException ||
                throwable is UnknownHostException ||
                throwable is SocketTimeoutException
    }

    private fun handleError(errorBody: ErrorBody){
        if (errorBody.code != ErrorBody.UNKNOW_ERROR){
            showErrorIfRequired(R.string.server_error)
        }
    }

    private fun showErrorIfRequired(@StringRes strResId: Int){
        if(mShowError){
            mViewReference.get()?.showError(strResId)
        }
    }

    private fun showErrorIfRequires(error: String){
        if (mShowError && !TextUtils.isEmpty(error)){
            mViewReference.get()?.showError(error)
        }
    }

    private fun showMessage(@StringRes strResId: Int){
        mViewReference.get()?.showMessage(strResId)
    }

    private fun showMessage(error: String){
        if(error.isNotEmpty()){
            mViewReference.get()?.showError(error)
        }
    }
}