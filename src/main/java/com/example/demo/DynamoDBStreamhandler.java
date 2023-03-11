package com.example.demo;

import com.amazonaws.services.lambda.runtime.Context;
import io.micronaut.context.ApplicationContextBuilder;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.function.aws.MicronautRequestHandler;
import io.micronaut.function.aws.MicronautRequestStreamHandler;

import java.io.*;
import java.util.stream.Collectors;

@Introspected
public class DynamoDBStreamhandler extends MicronautRequestStreamHandler {

    @Override
    public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException{

     System.out.println("Inside Handler for Dynamodb stream");
     String record = new BufferedReader(new InputStreamReader(input)).lines().collect(Collectors.joining("\n"));

     System.out.println("stream report recived is"+record);
 }
}
