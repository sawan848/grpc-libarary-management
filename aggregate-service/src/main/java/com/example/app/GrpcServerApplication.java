package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class GrpcServerApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(GrpcServerApplication.class,args);
    }
}
