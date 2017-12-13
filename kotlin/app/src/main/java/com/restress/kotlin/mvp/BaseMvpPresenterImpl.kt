package com.restress.kotlin.mvp

/**
 * Created by win10 on 2017/12/13.
 */
open class BaseMvpPresenterImpl<V: BaseMvpView > :BaseMvpPresenter<V> {

    protected var mView: V? =null

    override fun attachView(view: V) {
        mView = view
    }

    override fun detachView() {
        mView = null
    }
}