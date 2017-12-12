package com.restress.kotlin.manaer

import com.restress.kotlin.api.GithubService

/**
 * Created by win10 on 2017/12/12.
 */
//Object是用来定义单例的
object ApiManager {
    private const val SERVER:String = "https://api.github.com/"

    private lateinit var mGithubService: GithubService

    init {
        val retrofit = initRetrofit();

    }
}