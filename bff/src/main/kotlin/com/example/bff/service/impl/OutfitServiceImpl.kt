package com.example.bff.service.impl

import com.example.bff.builder.OutfitScreen
import com.example.bff.service.OutfitService
import org.springframework.stereotype.Service

@Service
class OutfitServiceImpl : OutfitService {
    override fun getOutfitScreen(): OutfitScreen = OutfitScreen()
}