package com.example.mobileapp.mobile

import br.com.zup.beagle.android.annotation.BeagleComponent
import br.com.zup.beagle.android.setup.DesignSystem
import com.example.mobileapp.R


@BeagleComponent
class AppDesignSystem : DesignSystem() {
    override fun textStyle(id: String): Int? {
        return when (id) {
            "Title" -> R.style.Title
            else -> R.style.Default
        }
    }
}