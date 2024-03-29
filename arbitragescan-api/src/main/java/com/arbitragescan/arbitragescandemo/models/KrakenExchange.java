package com.arbitragescan.arbitragescandemo.models;

import java.io.IOException;

import com.arbitragescan.arbitragescandemo.services.RestService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.client.RestClientException;

public class KrakenExchange extends Exchange {

    public KrakenExchange(RestService restService) {
        super(restService, "https://api.kraken.com/0");
    }

    @Override
    public Double getTopBuyOrderPrice(ExchangePair currencyPair) {
        String url = this.BASE_URL + "/public/Ticker?pair=" + formatExchangePair(currencyPair);
        try {
            String jsonResponse = this.restService.getPostsPlainJSON(url);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonRootNode = objectMapper.readTree(jsonResponse);
            return Double.parseDouble(jsonRootNode.get("result").elements().next().get("b").get(0).asText());
        } catch (RestClientException ex) {
            System.out.println("Kraken Buy Fetch Failed");
        } catch (IOException ex) {
            System.out.println("Kraken Buy Fetch Failed");
        }
        return null;
    }

    @Override
    public Double getTopSellOrderPrice(ExchangePair currencyPair) {
        String url = this.BASE_URL + "/public/Ticker?pair=" + formatExchangePair(currencyPair);
        try {
            String jsonResponse = this.restService.getPostsPlainJSON(url);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonRootNode = objectMapper.readTree(jsonResponse);
            return Double.parseDouble(jsonRootNode.get("result").elements().next().get("a").get(0).asText());
        } catch (RestClientException ex) {
            System.out.println("Kraken Sell Fetch Failed");
        } catch (IOException ex) {
            System.out.println("Kraken Sell Fetch Failed");
        }
        return null;
    }

    @Override
    public String getName() {
        return "kraken";
    }

}
