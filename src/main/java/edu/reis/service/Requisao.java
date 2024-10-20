package edu.reis.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Requisao implements Irequisicao {

    private HttpClient client;
    private HttpRequest request;
    private HttpResponse<String> response;
    private Iuri iuri;

    public Requisao(Iuri iuri) {

        try {
            this.client = HttpClient.newHttpClient();
            this.request = HttpRequest.newBuilder(URI.create(iuri.getUri())).build();
            this.response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getJson() {
        String json = this.response.body();
        return json;
    }
}
