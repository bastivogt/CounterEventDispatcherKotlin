package org.example


import org.example.sevo.events.EventDispatcher


open class Counter(start: Int = 0, end: Int = 10, step: Int = 1) : EventDispatcher(){

    private var start: Int = 0
    private var end: Int = 0
    private var step: Int = 0
    var count: Int = 0
        private set





    init {
        this.start = start
        this.end = end
        this.step = step
    }



    fun run() {
        this.count = 0
        this.dispatchEvent(CounterEvent(CounterEvent.COUNTER_START, this, "Sevo"))
        for (i in this.start..this.end step this.step) {
            this.count = i
            this.dispatchEvent(CounterEvent(CounterEvent.COUNTER_CHANGE, this, "Ute"))
        }
        this.dispatchEvent(CounterEvent(CounterEvent.COUNTER_FINISH, this, "Günther"))
    }



}