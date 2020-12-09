package com.example.bff.builder

import br.com.zup.beagle.annotation.BeaglePreview
import br.com.zup.beagle.builder.core.cornerRadius
import br.com.zup.beagle.core.CornerRadius
import br.com.zup.beagle.core.PositionType
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitPercent
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.ui.image
import br.com.zup.beagle.ui.text
import br.com.zup.beagle.widget.Widget
import br.com.zup.beagle.widget.action.Alert
import br.com.zup.beagle.widget.action.SetContext
import br.com.zup.beagle.widget.context.ContextData
import br.com.zup.beagle.widget.context.expressionOf
import br.com.zup.beagle.widget.core.*
import br.com.zup.beagle.widget.layout.*
import br.com.zup.beagle.widget.ui.Image
import br.com.zup.beagle.widget.ui.ImagePath
import br.com.zup.beagle.widget.ui.Text
import com.example.bff.widget.Color
import com.example.bff.widget.ColorSelector
import com.example.bff.widget.ImageDetail
import com.example.bff.widget.ImageType

@BeaglePreview
fun buildPreview() = OutfitScreen()

data class ShirtData(
    val id : String,
    val price: String
)

class OutfitScreen :ScreenBuilder {
    override fun build(): Screen {
        return Screen(
            navigationBar = navBar(),
            child = Container(
                context = ContextData(
                    id = "shirtData",
                    value = ShirtData(id = "123", price = "$23.99")
                ),
                children = listOf(
                    outfitImage()
                )
            )
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
                ),
                ImageDetail(
                    value = expressionOf("@{shirtData.price}"),
                    image = ImageType.RED_HEART
                ).applyStyle(
                    Style(
                        padding = EdgeValue(bottom = 5.unitReal()),
                        margin = EdgeValue(horizontal = 10.unitReal()),
                        positionType = PositionType.ABSOLUTE
                    )
                )
            )
        ).applyStyle(
            Style(
                flex = Flex(justifyContent = JustifyContent.FLEX_END),
                margin = EdgeValue(left = 18.unitReal(), right = 18.unitReal()),
                size = Size(height = 65.unitPercent())
            )
        )
    }

    private fun outfitColor() : Widget {
        return ColorSelector(
            colors = listOf(
                Color(hex = "#FFFFF", onPress = SetContext("shirtData", path = "price", value = "$23.99")),
                Color(hex = "#422332", onPress = SetContext("shirtData", path = "price", value = "$24.99")),
                Color(hex = "#C0C0C", onPress = SetContext("shirtData", path = "price", value = "$25.99")),
                Color(hex = "#DDDDD", onPress = SetContext("shirtData", path = "price", value = "$26.99"))
            )
        )
    }
}