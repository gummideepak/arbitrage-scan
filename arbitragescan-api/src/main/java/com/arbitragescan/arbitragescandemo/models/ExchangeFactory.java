package com.arbitragescan.arbitragescandemo.models;

import com.arbitragescan.arbitragescandemo.services.RestService;

public class ExchangeFactory {
    private RestService restService;

    ExchangeFactory(RestService restService){
        this.restService = restService;
    }

    public Exchange getShape(String exchangeName){
        if(exchangeName == null){
           return null;
        }		
        if(exchangeName.equalsIgnoreCase("COINBASE")){
           return new CoinbaseExchange(restService);
           
        } else if(exchangeName.equalsIgnoreCase("KARKEN")){
           return new KrakenExchange(restService);
           
        } else if(exchangeName.equalsIgnoreCase("BINANCE")){
           return null;
        }
        
        return null;
     }
}
