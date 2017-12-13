package com.restress.kotlin.mvp

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.widget.Toast
import com.restress.kotlin.R

abstract class BaseMvpActivity <in V : BaseMvpView,T :BaseMvpPresenter<V>>
    : AppCompatActivity() ,BaseMvpView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter.attachView(this as V)
    }

    override fun getContext():Context = this

    protected abstract var mPresenter: T

    override fun showError(error: String?) {
        Toast.makeText(this,error,Snackbar.LENGTH_LONG).show()
    }

    override fun showError(stringResId: Int) {
        Toast.makeText(this,stringResId,Snackbar.LENGTH_LONG).show()
    }

    override fun showMessage(srtResId: Int) {
        Toast.makeText(this,srtResId,Snackbar.LENGTH_LONG).show()
    }

    override fun showMessage(message: String) {
        Toast.makeText(this,message,Snackbar.LENGTH_LONG).show()
    }

}
