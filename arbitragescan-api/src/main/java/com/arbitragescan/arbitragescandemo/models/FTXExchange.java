package com.arbitragescan.arbitragescandemo.models;

import java.io.IOException;

import com.arbitragescan.arbitragescandemo.services.RestService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.client.RestClientException;

public class FTXExchange extends Exchange {

    public FTXExchange(RestService restService) {
        super(restService, "https://ftx.us/api");
    }

    @Override
    public Double getTopBuyOrderPrice(ExchangePair currencyPair) {
        // TODO Auto-generated method stub
        String url = this.BASE_URL + "/markets/" + formatExchangePair(currencyPair) + "/orderbook?depth=1";
        try {
            String jsonResponse = this.restService.getPostsPlainJSON(url);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonRootNode = objectMapper.readTree(jsonResponse);
            return jsonRootNode.get("result").get("bids").get(0).get(0).asDouble();
        } catch (RestClientException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return 0.0;
    }

    @Override
    public Double getTopSellOrderPrice(ExchangePair currencyPair) {
        String url = this.BASE_URL + "/markets/" + formatExchangePair(currencyPair) + "/orderbook?depth=1";
        try {
            String jsonResponse = this.restService.getPostsPlainJSON(url);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonRootNode = objectMapper.readTree(jsonResponse);
             return jsonRootNode.get("result").get("asks").get(0).get(0).asDouble();
            //return Double.parseDouble(jsonRootNode.get("result").get("bids").get(0).asText());
        } catch (RestClientException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return 0.0;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "ftx";
    }

    @Override
    public String formatExchangePair(ExchangePair currencyPair) {
        return currencyPair.getCryptoCurrency() + "/" + currencyPair.getBaseCurrency();
    }

}
