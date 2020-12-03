package com.example.bff.builder

import br.com.zup.beagle.annotation.BeaglePreview
import br.com.zup.beagle.builder.core.cornerRadius
import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ui.image
import br.com.zup.beagle.ui.text
import br.com.zup.beagle.widget.Widget
import br.com.zup.beagle.widget.action.Alert
import br.com.zup.beagle.widget.core.ImageContentMode
import br.com.zup.beagle.widget.layout.*
import br.com.zup.beagle.widget.ui.Image
import br.com.zup.beagle.widget.ui.ImagePath
import br.com.zup.beagle.widget.ui.Text

@BeaglePreview
fun buildPreview() = OutfitScreen()

class OutfitScreen :ScreenBuilder {
    override fun build(): Screen {
        return Screen(
            navigationBar = navBar(),
            child = Text(text = "Hello World")
        )
    }

    private fun navBar(): NavigationBar {
        return NavigationBar(
            title = "Outfit",
            styleId = "customNavigation",
            navigationBarItems = listOf(
                NavigationBarItem(
                    text = "Heart Icon",
                    image = ImagePath.Local.justMobile("heart"),
                    action = Alert(
                        title = "Clicked Heart Icon",
                        message = "You've clicked in Heart Icon",
                        labelOk = "Ok"
                    )
                ),
                NavigationBarItem(
                    text = "Bag Icon",
                    image = ImagePath.Local.justMobile("bag"),
                    action = Alert(
                        title = "Clicked Bag Icon",
                        message = "You've clicked in Bag Icon",
                        labelOk = "Ok"
                    )
                )
            )
        )
    }

    private fun outfitImage() : Widget {
        return Container(
            children = listOf(
                Image(
                    path = ImagePath.Local.justMobile("shirt"),
                    mode = ImageContentMode.CENTER
                ).applyStyle(
                    Style(cornerRadius = CornerRadius(20.0))
                )
            )
        )
    }
}