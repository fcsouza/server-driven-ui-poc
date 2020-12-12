package com.example.mobileapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.beagle.android.components.Text
import br.com.zup.beagle.android.components.layout.Container
import br.com.zup.beagle.android.components.layout.Screen
import br.com.zup.beagle.android.utils.newServerDrivenIntent
import br.com.zup.beagle.android.view.ScreenRequest
import br.com.zup.beagle.core.Style
import br.com.zup.beagle.ext.applyStyle
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.widget.core.AlignSelf
import br.com.zup.beagle.widget.core.EdgeValue
import br.com.zup.beagle.widget.core.Flex

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = this.newServerDrivenIntent<AppBeagleActivity>(ScreenRequest("/screen"))
        startActivity(intent)
        finish()
    }

    private fun screen() = Screen(
        child = Container(
            children = listOf(
                Text(
                    text = "Testando o Beagle",
                    styleId = "Title"
                ).applyStyle(
                    Style(
                        margin = EdgeValue(bottom = 30.unitReal(), top = 15.unitReal()),
                        flex = Flex(
                            alignSelf = AlignSelf.CENTER
                        )
                    )
                ),
                Text("Beagle framework para teste de server driven ui")
            )
        )
    )
}
