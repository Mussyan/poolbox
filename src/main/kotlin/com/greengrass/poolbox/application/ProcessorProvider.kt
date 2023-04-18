package com.greengrass.poolbox.application

object ProcessorProvider {
    private val processorList = mutableListOf<ProcessorBase>()
    internal val processors: List<ProcessorBase> = processorList
    fun register(processor: ProcessorBase) {
        processorList.add(processor)
    }

    fun clear() {
        processorList.clear()
    }
}