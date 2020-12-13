package com.example.mobileapp.widgets

import android.app.Notification
import android.view.View
import br.com.zup.beagle.android.utils.handleEvent
import br.com.zup.beagle.android.widget.RootView
import br.com.zup.beagle.android.widget.WidgetView
import br.com.zup.beagle.annotation.RegisterWidget

data class Color(
    val hex: String,
    val onPress: Notification.Action
)

@RegisterWidget
data class ColorSelector(
    val colors: List<Color>
) : WidgetView() {

    override fun buildView(rootView: RootView) = ColorSelectorView(rootView.getContext()).apply {
        colors.forEach {
            setItem(it.hex){
                handleEvent(rootView, this, listOf(it.onPress))
            }
        }
    }

}