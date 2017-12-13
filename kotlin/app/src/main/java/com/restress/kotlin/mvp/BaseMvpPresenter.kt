package com.restress.kotlin.mvp

/**
 * Created by win10 on 2017/12/13.
 */
interface BaseMvpPresenter <in V : BaseMvpView>{

    fun attachView(view: V)

    fun detachView()
}