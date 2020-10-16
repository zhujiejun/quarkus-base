package com.zhujiejun.quarkus.kafka

import io.smallrye.reactive.messaging.annotations.Broadcast
import javax.enterprise.context.ApplicationScoped
import org.eclipse.microprofile.reactive.messaging.{Incoming, Outgoing}

@ApplicationScoped
class PriceConverter {
    private val CONVERSION_RATE: Double = 0.88

    @Broadcast
    @Incoming("price")
    @Outgoing("my-data-stream")
    def process(priceInUsd: Int): Double = {
        priceInUsd * CONVERSION_RATE
    }
}
