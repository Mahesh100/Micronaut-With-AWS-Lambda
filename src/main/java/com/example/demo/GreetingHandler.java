package com.example.demo;

import io.micronaut.context.ApplicationContext;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.function.aws.MicronautRequestHandler;
import jakarta.inject.Inject;


@Introspected
public class GreetingHandler extends MicronautRequestHandler<String, String> {

    @Inject
    private MyService myService;
    //This constructor is used in aws (Default constructor)
    public GreetingHandler() {


    }

    //used in micronaut test(J-unit test)
    public GreetingHandler(ApplicationContext applicationContext) {
        super(applicationContext);
    }

    @Override
    public String execute(String input) {
        myService.sayHello();
        return "Hello"+input;
    }

}
