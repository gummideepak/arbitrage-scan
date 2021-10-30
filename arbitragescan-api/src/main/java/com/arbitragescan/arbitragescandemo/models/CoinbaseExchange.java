package com.arbitragescan.arbitragescandemo.models;

import java.io.IOException;
import com.arbitragescan.arbitragescandemo.services.RestService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CoinbaseExchange implements Exchange {
    private RestService restController;
    private final String BASE_URL = "https://api.coinbase.com/v2/";

    public CoinbaseExchange() {
    }

    public CoinbaseExchange(RestService restController) {
        this.restController = restController;
    }

    @Override
    public Double getBuyPrice(ExchangePair currencyPair) {
        // HttpRequest request = HttpRequest.newBuilder().uri(new
        // URI("https://postman-echo.com/get")).GET().build();
        String url = this.BASE_URL + "prices/" + this.formatExchangePair(currencyPair) + "/buy";
        return extractPriceFromJsonResponse(this.restController.getPostsPlainJSON(url));
    }

    @Override
    public Double getSellPrice(ExchangePair currencyPair) {
        String url = this.BASE_URL + "prices/" + this.formatExchangePair(currencyPair) + "/sell";
        return extractPriceFromJsonResponse(this.restController.getPostsPlainJSON(url));
    }

    @Override
    public String formatExchangePair(ExchangePair currencyPair) {
        return currencyPair.getCryptoCurrency() + "-" + currencyPair.getBaseCurrency();
    }

    @Override
    public String getName() {
        return "coinbase";
    }

    @Override
    public Double extractPriceFromJsonResponse(String jsonResponse) {
        try{
            // create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();
            // convert json file to map
            JsonNode jsonRootNode = objectMapper.readTree(jsonResponse);
            return Double.parseDouble(jsonRootNode.get("data").get("amount").asText());
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        return 0.0;
    }

}
