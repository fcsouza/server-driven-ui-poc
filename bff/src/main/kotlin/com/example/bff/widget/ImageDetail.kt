package com.example.bff.widget

import br.com.zup.beagle.annotation.RegisterWidget
import br.com.zup.beagle.widget.Widget
import br.com.zup.beagle.widget.context.Bind

enum class ImageType {
    RED_HEART, SHOPPING
}

@RegisterWidget
data class ImageDetail (
    val value: Bind<String>,
    val image : ImageType
) : Widget()