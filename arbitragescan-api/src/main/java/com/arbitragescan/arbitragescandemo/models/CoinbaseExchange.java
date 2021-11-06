package com.arbitragescan.arbitragescandemo.models;

import java.io.IOException;
import com.arbitragescan.arbitragescandemo.services.RestService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CoinbaseExchange extends Exchange {
    // private RestService restController;
    // private final String BASE_URL = "https://api.coinbase.com/v2/";

    public CoinbaseExchange(RestService restService) {
        super(restService,"https://api.coinbase.com/v2");
    }

    @Override
    public Double getTopBuyOrderPrice(ExchangePair currencyPair) {
        String url = this.BASE_URL + "/prices/" + this.formatExchangePair(currencyPair) + "/sell";
        return extractPriceFromJsonResponse(this.restService.getPostsPlainJSON(url));
    }

    @Override
    public Double getTopSellOrderPrice(ExchangePair currencyPair) {
        String url = this.BASE_URL + "/prices/" + this.formatExchangePair(currencyPair) + "/buy";
        return extractPriceFromJsonResponse(this.restService.getPostsPlainJSON(url));
    }

    @Override
    public String formatExchangePair(ExchangePair currencyPair) {
        return currencyPair.getCryptoCurrency() + "-" + currencyPair.getBaseCurrency();
    }

    @Override
    public String getName() {
        return "coinbase";
    }

    public Double extractPriceFromJsonResponse(String jsonResponse) {
        try{
            // create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();
            // convert json file to map
            JsonNode jsonRootNode = objectMapper.readTree(jsonResponse);
            return Double.parseDouble(jsonRootNode.get("data").get("amount").asText());
        }
        catch(IOException ex){
            System.out.println("Coinbase Buy/Sell Fetch Failed");
        }
        return null;
    }

}
