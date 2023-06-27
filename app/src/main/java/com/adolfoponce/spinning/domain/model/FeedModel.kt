package com.adolfoponce.spinning.domain.model

data class FeedModel(
    val id_post:Int,
    val multimedia:MultimediaDetailModel,
    val id_store:Int,
    val name_store:String,
    val detail_post:DetailPostModel
)
