package com.arbitragescan.arbitragescandemo.models;

public class ExchangePair {
    private String baseCurrency;
    private String cryptoCurrency;

    // standard getters and setters


    public ExchangePair(String baseCurrency, String cryptoCurrency) {
        this.baseCurrency = baseCurrency.toUpperCase();
        this.cryptoCurrency = cryptoCurrency.toUpperCase();
    }


    public String getBaseCurrency() {
        return this.baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getCryptoCurrency() {
        return this.cryptoCurrency;
    }

    public void setCryptoCurrency(String cryptoCurrency) {
        this.cryptoCurrency = cryptoCurrency;
    }


}
