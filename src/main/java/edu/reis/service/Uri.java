package edu.reis.service;

public class Uri implements Iuri {


    private String uri;

    public Uri(String cep) {
        this.uri = "https://viacep.com.br/ws/" + cep + "/json/";
    }

    @Override
    public String getUri() {
        return uri;
    }
}
