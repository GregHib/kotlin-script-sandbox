package world.gregs.script

import com.artemis.ArtemisPlugin
import com.artemis.WorldConfigurationBuilder
import kotlin.script.experimental.annotations.KotlinScript

@KotlinScript(displayName = "Plugin Base Script", fileExtension = "plugin.kts", compilationConfiguration = ScriptConfiguration::class)
abstract class PluginBase : ArtemisPlugin {

    private lateinit var builder: WorldConfigurationBuilder.() -> Unit

    fun setup(action: WorldConfigurationBuilder.() -> Unit) {
        builder = action
    }

    override fun setup(b: WorldConfigurationBuilder) {
        builder.invoke(b)
    }

}