package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import static io.micronaut.http.MediaType.APPLICATION_JSON;

@Introspected
@Controller("/redis")
public class RedisController {

    private StatefulRedisConnection<String, String>redis;
    public RedisController(StatefulRedisConnection<String,String> redis){
          this.redis=redis;
    }

    @Post(value = "/put", consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    public HttpResponse<String> insertIntoCache() throws JsonProcessingException {
        RedisCommands<String,String> redisCommands=redis.sync();
        redisCommands.set("name", "Mahesh");
        redisCommands.expire("name",120);
        return HttpResponse.ok(new ObjectMapper().writeValueAsString("data inserted into cache sucessfully"));

    }

    @Get("/get")
    public HttpResponse<String> getValueFromCache() throws JsonProcessingException{
        RedisCommands<String, String> redisCommands=redis.sync();
        String name=redisCommands.get("name");
        return HttpResponse.ok(new ObjectMapper().writeValueAsString("name"));
    }

}
