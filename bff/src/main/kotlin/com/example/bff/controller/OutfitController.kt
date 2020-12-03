package com.example.bff.controller

import com.example.bff.builder.OutfitScreen
import com.example.bff.service.OutfitService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OutfitController(private val outfitService: OutfitService) {
    @GetMapping("/outfit")
    fun showOutfitScreen() : OutfitScreen = outfitService.getOutfitScreen()
}