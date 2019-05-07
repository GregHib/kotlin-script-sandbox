package world.gregs.script

import kotlin.script.experimental.api.ScriptCompilationConfiguration
import kotlin.script.experimental.api.defaultImports

object ScriptConfiguration : ScriptCompilationConfiguration({
    defaultImports("java.io.*")
})