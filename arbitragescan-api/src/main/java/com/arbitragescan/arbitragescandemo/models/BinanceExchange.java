package com.arbitragescan.arbitragescandemo.models;

import java.io.IOException;

import com.arbitragescan.arbitragescandemo.services.RestService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.client.RestClientException;

public class BinanceExchange extends Exchange {

    public BinanceExchange(RestService restService) {
        super(restService, "https://api.binance.com");
    }

    @Override
    public Double getTopBuyOrderPrice(ExchangePair currencyPair) {
        String url = this.BASE_URL + "/api/v3/ticker/bookTicker?symbol="+formatExchangePair(currencyPair);
        try {
            String jsonResponse = this.restService.getPostsPlainJSON(url);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonRootNode = objectMapper.readTree(jsonResponse);
            return jsonRootNode.get("askPrice").asDouble();
        } catch (RestClientException ex) {
            System.out.println("Binance Buy Fetch Failed");
        } catch (IOException ex) {
            System.out.println("Binance Buy Fetch Failed");
        }
        return null;
    }

    @Override
    public Double getTopSellOrderPrice(ExchangePair currencyPair) {
        String url = this.BASE_URL + "/api/v3/ticker/bookTicker?symbol="+formatExchangePair(currencyPair);
        try {
            String jsonResponse = this.restService.getPostsPlainJSON(url);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonRootNode = objectMapper.readTree(jsonResponse);
            return jsonRootNode.get("bidPrice").asDouble();
        } catch (RestClientException ex) {
            System.out.println("Binance Sell Fetch Failed");
        } catch (IOException ex) {
            System.out.println("Binance Sell Fetch Failed");
        }
        return null;
    }

    @Override
    public String getName() {
        return "binance";
    }

    @Override
    public String formatExchangePair(ExchangePair currencyPair) {
        if(currencyPair.getBaseCurrency().equals("USD")){
            return currencyPair.getCryptoCurrency() + currencyPair.getBaseCurrency()+"T";
        }
        return currencyPair.getCryptoCurrency() + currencyPair.getBaseCurrency();
    }
    
}
