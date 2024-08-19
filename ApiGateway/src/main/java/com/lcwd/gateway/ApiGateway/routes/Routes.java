package com.lcwd.gateway.ApiGateway.routes;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.*;

@Configuration
public class Routes {
    @Bean
    public RouterFunction<ServerResponse> userService(){
        return GatewayRouterFunctions.route("user_service")
                .route(RequestPredicates.path("/users/**"), HandlerFunctions.http("http://localhost:8081"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> hotelService(){
        return GatewayRouterFunctions.route("hotel_service")
                .route(RequestPredicates.path("/hotels/**"), HandlerFunctions.http("http://localhost:8082"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> ratingService(){
        return GatewayRouterFunctions.route("rating_service")
                .route(RequestPredicates.path("/ratings/**"), HandlerFunctions.http("http://localhost:8083"))
                .build();
    }
}
