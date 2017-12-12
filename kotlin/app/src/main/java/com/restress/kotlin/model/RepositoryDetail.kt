package com.restress.kotlin.model

import javax.xml.transform.Source

/**
 * Created by win10 on 2017/12/12.
 */
data class RepositoryDetail(val name:String,
                            val description:String,
                            val stargazers_count: String,
                            val forks_count: String,
                            val created_at: String,
                            val updated_at: String,
                            val source: Source?)