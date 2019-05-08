package world.gregs.script

import kotlin.script.experimental.annotations.KotlinScript

@KotlinScript(compilationConfiguration = ScriptConfiguration::class)
abstract class ScriptBase {

    fun aMethod() {
    }

}