package com.example.bff.builder

import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.layout.Screen
import br.com.zup.beagle.widget.layout.ScreenBuilder
import br.com.zup.beagle.widget.ui.Text

class OutfitScreen :ScreenBuilder {
    override fun build(): Screen {
        return Screen(
                child = Container(
                   children = listOf(
                           Text(text= "Hello World")
                   )
                )
        )
    }
}