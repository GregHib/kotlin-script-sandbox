package world.gregs.script

import com.artemis.World
import com.artemis.WorldConfigurationBuilder
import io.github.classgraph.ClassGraph

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        var plugin: PluginBase? = null
        val graph = ClassGraph()
        graph.enableAllInfo().whitelistModules("scripts").scan().use { result ->
            val plugins = result.getSubclasses(PluginBase::class.java.name).directOnly()
            plugins.forEach { p ->
                val pluginClass = p.loadClass(PluginBase::class.java)
                val constructor = pluginClass.getConstructor()
                plugin = constructor.newInstance()
            }
            result.close()
        }


        val builder = WorldConfigurationBuilder()
        plugin?.setup(builder)
        val config = builder.build()
        //Initialize world
        val server = World(config)

        val script = server.systems.filterIsInstance<ScriptBase>().first()
        script.test.invoke()
        println("Done")
    }
}