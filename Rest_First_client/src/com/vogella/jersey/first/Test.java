package com.vogella.jersey.first;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

public class Test {

  public static void main(String[] args) {
    ClientConfig config = new ClientConfig();

    Client client = ClientBuilder.newClient(config);

    WebTarget target = client.target(getBaseURI());
    
    WebTarget pathWS_Hello = target.path("rest").path("hello");
    Builder requestWS_Hello = pathWS_Hello.request();

//    String response = requestWS_Hello.accept(MediaType.TEXT_PLAIN).get(Response.class).toString();
//    String plainAnswer = requestWS_Hello.accept(MediaType.TEXT_PLAIN).get(String.class);
//    String xmlAnswer = requestWS_Hello.accept(MediaType.TEXT_XML).get(String.class);
//    String htmlAnswer= requestWS_Hello.accept(MediaType.TEXT_HTML).get(String.class);

    String response = pathWS_Hello.request().accept(MediaType.TEXT_PLAIN).get(Response.class).toString();
    String plainAnswer = pathWS_Hello.request().accept(MediaType.TEXT_PLAIN).get(String.class);
    String xmlAnswer = pathWS_Hello.request().accept(MediaType.TEXT_XML).get(String.class);
    String htmlAnswer= pathWS_Hello.request().accept(MediaType.TEXT_HTML).get(String.class);

    
    System.out.println(response);
    System.out.println(plainAnswer);
    System.out.println(xmlAnswer);
    System.out.println(htmlAnswer);
  }

  private static URI getBaseURI() {
    return UriBuilder.fromUri("http://localhost:8080/Rest_First").build();
  }
} 
