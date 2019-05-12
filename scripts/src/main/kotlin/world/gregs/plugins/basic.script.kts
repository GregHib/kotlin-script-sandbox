package world.gregs.plugins

import com.artemis.ComponentMapper
import world.gregs.script.TestComponent

println("Hello World!")

val aspect = all(TestComponent::class)
aMethod()
lateinit var testComponentMapper: ComponentMapper<TestComponent>

fun initialize() {
    println("init")
}

test = {
    println("Something")
    println(testComponentMapper)
}

test {
    println("Something else")
}

