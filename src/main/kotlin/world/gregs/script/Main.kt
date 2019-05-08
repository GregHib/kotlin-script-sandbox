package world.gregs.script

import java.io.File
import kotlin.script.experimental.api.EvaluationResult
import kotlin.script.experimental.api.ResultWithDiagnostics
import kotlin.script.experimental.host.toScriptSource
import kotlin.script.experimental.jvmhost.BasicJvmScriptingHost
import kotlin.script.experimental.jvmhost.createJvmCompilationConfigurationFromTemplate

object Main {

    @JvmStatic
    fun main(args: Array<String>) {

        val file = File("src/main/testData/script.kts")

        val eval = evalFile(file)

        eval.reports.forEach {
            println("${it.message} ${it.severity}")
            it.exception?.printStackTrace()
        }
    }

    fun evalFile(scriptFile: File): ResultWithDiagnostics<EvaluationResult> {

        val compilationConfiguration = createJvmCompilationConfigurationFromTemplate<ScriptBase>()

        return BasicJvmScriptingHost().eval(scriptFile.toScriptSource(), compilationConfiguration, null)
    }
}