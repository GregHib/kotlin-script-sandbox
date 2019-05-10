package world.gregs.script

import io.github.classgraph.ClassGraph

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        ClassGraph().enableAllInfo().whitelistModules("scripts").scan().use { result ->
            val plugins = result.getSubclasses(ScriptBase::class.java.name).directOnly()
            plugins.forEach { p ->
                val pluginClass = p.loadClass(ScriptBase::class.java)
                val constructor = pluginClass.getConstructor()
                constructor.newInstance()
            }
        }
    }
}