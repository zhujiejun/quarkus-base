package com.zhujiejun.quarkus.kafka

import javax.inject.Inject
import javax.ws.rs.core.MediaType
import javax.ws.rs.{GET, Path, Produces}
import org.eclipse.microprofile.reactive.messaging.Channel
import org.jboss.resteasy.annotations.SseElementType
import org.reactivestreams.Publisher

@Path("/prices")
class PriceResource {
    @Inject
    @Channel("my-data-stream")
    var prices: Publisher[Double] = _

    @GET
    @Path("/stream")
    @SseElementType("text/plain")
    @Produces(Array[String](MediaType.SERVER_SENT_EVENTS))
    def stream(): Publisher[Double] = {
        prices
    }
}
