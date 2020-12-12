package com.example.mobileapp.mobile

import br.com.zup.beagle.android.annotation.BeagleComponent
import br.com.zup.beagle.android.setup.BeagleConfig
import br.com.zup.beagle.android.setup.Cache
import br.com.zup.beagle.android.setup.Environment

@BeagleComponent
class AppBeagleConfig : BeagleConfig {
    override val baseUrl: String get() = "http://10.0.2.2:8080" // return the base url based on your environment
    override val environment: Environment get() = Environment.DEBUG // return the current build state of your app
    override val isLoggingEnabled: Boolean = true
    override val cache: Cache get() = Cache(
        enabled = true, // If true, we will cache data on disk and memory.
        maxAge = 300, // Time in seconds that memory cache will live.
        memoryMaximumCapacity = 15 // Memory LRU cache size. It represents number of screens that will be in memory.
    ) // Cache management configuration
}