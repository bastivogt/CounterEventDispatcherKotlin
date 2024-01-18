package org.example

import org.example.sevo.events.Event
import kotlin.reflect.typeOf

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val counter = Counter()

    counter.addListener(CounterEvent.COUNTER_START) {event: Event ->
        val e = event as CounterEvent
        val c = e.sender as Counter
        println("${e.type} count: ${c.count} ${e.name}")
    }

    counter.addListener(CounterEvent.COUNTER_CHANGE) {event: Event ->
        val e = event as CounterEvent
        val c = e.sender as Counter
        println("${e.type} count: ${c.count} ${e.name}")
    }

    counter.addListener(CounterEvent.COUNTER_FINISH) {event: Event ->
        val e = event as CounterEvent
        val c = e.sender as Counter
        println("${e.type} count: ${c.count} ${e.name}")
    }

    // counter.removeListener(CounterEvent.COUNTER_CHANGE)



    counter.run()

}