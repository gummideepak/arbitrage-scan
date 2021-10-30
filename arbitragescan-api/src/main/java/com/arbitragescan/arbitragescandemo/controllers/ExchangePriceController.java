package com.arbitragescan.arbitragescandemo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.arbitragescan.arbitragescandemo.dtos.ExchangePriceDto;
import com.arbitragescan.arbitragescandemo.models.ExchangePair;
import com.arbitragescan.arbitragescandemo.services.ExchangeService;
import com.arbitragescan.arbitragescandemo.services.RestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangePriceController {
    @Autowired
    public RestService restController;

    @Autowired
    public ExchangeService exchangeService;

    @GetMapping("/getBTCPrice")
    public List<String> getBTCPrice() {
        // return this.restController.getPostsPlainJSON("https://api.coinbase.com/v2/prices/BTC-USD/buy");
        // Exchange coinbase = new CoinbaseExchange(restController);
        // return coinbase.getBuyPrice(null);
        return null;
    }

    @GetMapping("/getTickersBuyPrices")
    public  Map<String,Map<String,ExchangePriceDto>> getTickersBuyPrices(@RequestParam List<String> cryptoTickerList, String fiatCurrency) {
        Map<String,Map<String,ExchangePriceDto>> result = new HashMap<>();
        for(String cryptoTicker: cryptoTickerList){
            Map<String,ExchangePriceDto> exchangePrices = this.exchangeService.getAllPrices(new ExchangePair(fiatCurrency, cryptoTicker));
            result.put(cryptoTicker, exchangePrices);
        }
        return result;
    }
}
