package world.gregs.script

import org.junit.jupiter.api.Test

internal class Basic_scriptTest : ScriptTester() {

    @Test
    fun `first test`() {
        println(system)
    }
}