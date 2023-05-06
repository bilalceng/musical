package com.bilalberek.musical.repository

import com.bilalberek.musical.service.PodcastResponse
import com.bilalberek.musical.service.ItunesService
import retrofit2.Response

class ItunesRepo ( private val itunesService: ItunesService) {

    suspend fun getMusics(term: String): Response<PodcastResponse> =  itunesService.searchMusicByTerm(term)

}