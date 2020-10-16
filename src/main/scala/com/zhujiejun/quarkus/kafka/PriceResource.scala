package com.zhujiejun.quarkus.kafka

import javax.inject.Inject
import javax.ws.rs.core.MediaType
import javax.ws.rs.{GET, Path, Produces}
import org.eclipse.microprofile.reactive.messaging.Channel
import org.jboss.resteasy.annotations.SseElementType
import org.reactivestreams.Publisher

@Path("/price")
class PriceResource {
    @Inject
    @Channel("my-data-stream")
    var prices: Publisher[Double] = null

    @GET
    @Path("/stream")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @SseElementType("text/plain")
    def stream(): Publisher[Double] = {
        prices
    }
}
