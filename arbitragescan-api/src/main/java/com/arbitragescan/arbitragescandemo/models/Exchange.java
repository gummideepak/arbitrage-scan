package com.arbitragescan.arbitragescandemo.models;

public interface Exchange {
    public abstract Double getBuyPrice(ExchangePair currencyPair);
    public abstract Double getSellPrice(ExchangePair currencyPair);
    public abstract String formatExchangePair(ExchangePair currencyPair);
    public abstract String getName();
    public abstract Double extractPriceFromJsonResponse(String jsonResponse);
}
