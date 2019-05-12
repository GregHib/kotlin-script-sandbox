package world.gregs.script

import com.artemis.Aspect
import com.artemis.BaseSystem
import com.artemis.Component
import kotlin.reflect.KClass
import kotlin.script.experimental.annotations.KotlinScript

@KotlinScript(displayName = "Game Content Script", fileExtension = "script.kts", compilationConfiguration = ScriptConfiguration::class)
abstract class ScriptBase : BaseSystem() {

    /**
     * TODO support
     * BaseSystem
     * ParallelSystem
     * PassiveSystem
     * SubscriptionSystem
     * IteratingSystem
     * etc..
     * Script testing
     */
    lateinit var test: () -> Unit

    fun aMethod() {
        println("A method")
    }

    fun test(action: () -> Unit) {
        action.invoke()
    }


    /**
     * Returns an aspect where an entity must possess all of the specified
     * component types.
     * Note: Performance cost
     *
     * @param types a required component type
     * @return an aspect that can be matched against entities
     */
    fun all(vararg types: KClass<out Component>): Aspect.Builder = Aspect.all(types.map { it.java })

    /**
     * Returns an aspect where an entity must possess one of the specified
     * component types.
     * Note: Performance cost
     *
     * @param types one of the types the entity must possess
     * @return an aspect that can be matched against entities
     */
    fun one(vararg types: KClass<out Component>): Aspect.Builder = Aspect.one(types.map { it.java })

    /**
     * Excludes all of the specified component types from the aspect.
     * <p>
     * A system will not be interested in an entity that possesses one of the
     * specified exclusion component types.
     * </p>
     * Note: Performance cost
     *
     * @param types component type to exclude
     * @return an aspect that can be matched against entities
     */
    fun exclude(vararg types: KClass<out Component>): Aspect.Builder = Aspect.exclude(types.map { it.java })
}