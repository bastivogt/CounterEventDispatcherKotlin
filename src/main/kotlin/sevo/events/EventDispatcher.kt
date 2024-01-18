package org.example.sevo.events

open class EventDispatcher {

    private var listeners: MutableMap<String, (Event) -> Unit> = mutableMapOf()


    protected fun hasListener(type: String): Boolean{
        return listeners.containsKey(type)
    }


    fun addListener(type: String, listener: (Event) -> Unit): Boolean {
        if(!this.hasListener(type)) {
            this.listeners.put(type, listener)
            return true
        }
        return false
    }

    fun removeListener(type: String): Boolean {
        if(this.hasListener(type)) {
            this.listeners.remove(type)
        }
        return false
    }

    fun dispatchEvent(event: Event): Boolean {
        if(this.hasListener(event.type)) {
            this.listeners.get(event.type)?.invoke(event)
            return true
        }
        return false
    }

}