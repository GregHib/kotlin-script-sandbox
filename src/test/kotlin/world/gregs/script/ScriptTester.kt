package world.gregs.script

import com.artemis.BaseSystem
import com.artemis.World
import com.artemis.WorldConfigurationBuilder
import org.junit.jupiter.api.BeforeEach

abstract class ScriptTester {

    protected lateinit var system: BaseSystem

    @BeforeEach
    fun setup() {
        val builder = WorldConfigurationBuilder()
        system = Class.forName(this::class.java.simpleName.substringBefore("Test")).getConstructor().newInstance() as BaseSystem
        builder.with(system)
        val config = builder.build()
        //Initialize world
        World(config)
    }
}