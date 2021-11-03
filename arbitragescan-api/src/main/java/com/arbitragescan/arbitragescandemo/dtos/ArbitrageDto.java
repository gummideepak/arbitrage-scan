package com.arbitragescan.arbitragescandemo.dtos;

import java.util.Map;

public class ArbitrageDto {

    public String numOfTokens;

    public String usdEquivalentBuy;
    public String exchangeNameBuy;

    public String usdEquivalentSell;
    public String exchangeNameSell;

    public Map<String, Map<String, ExchangePriceDto>> allPrices;

    public String tokenName;
}
