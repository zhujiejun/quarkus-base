package com.zhujiejun.quarkus.kafka

import java.util.Random
import java.util.concurrent.TimeUnit

import io.reactivex.rxjava3.core.Flowable
import javax.enterprise.context.ApplicationScoped
import org.eclipse.microprofile.reactive.messaging.Outgoing

@ApplicationScoped
class PriceGenerator {
    private val RANDOM: Random = new Random()

    @Outgoing("generated-price")
    def generate(): Flowable[Int] = {
        Flowable.interval(5, TimeUnit.SECONDS).map(_ => RANDOM.nextInt(100))
    }
}
