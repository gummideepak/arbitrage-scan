package com.arbitragescan.arbitragescandemo.models;

import com.arbitragescan.arbitragescandemo.dtos.ExchangePriceDto;
import com.arbitragescan.arbitragescandemo.services.RestService;

import org.springframework.web.client.HttpClientErrorException;

public abstract class Exchange {
    protected RestService restService;
    protected final String BASE_URL;

    Exchange(RestService restService, String baseUrl) {
        this.restService = restService;
        this.BASE_URL = baseUrl;
    }

    public ExchangePriceDto getPrice(ExchangePair currencyPair) {
        ExchangePriceDto result = new ExchangePriceDto();
        try {
            result.topBuyOrder = getTopBuyOrderPrice(currencyPair);
            result.topSellOrder = getTopSellOrderPrice(currencyPair);
            if(result.topBuyOrder==null || result.topSellOrder==null){
                return null;
            }
        } catch (Exception ex) {
            // Failed to fetch Buy/Sell Order Price
            return null;
        }
        result.exchangeName = getName();
        result.ticker = currencyPair.getCryptoCurrency() + currencyPair.getBaseCurrency();
        return result;
    }

    public abstract Double getTopBuyOrderPrice(ExchangePair currencyPair);

    public abstract Double getTopSellOrderPrice(ExchangePair currencyPair);

    public abstract String getName();
    // public abstract Double extractPriceFromJsonResponse(String jsonResponse);

    public String formatExchangePair(ExchangePair currencyPair) {
        return currencyPair.getCryptoCurrency() + currencyPair.getBaseCurrency();
    }
}
