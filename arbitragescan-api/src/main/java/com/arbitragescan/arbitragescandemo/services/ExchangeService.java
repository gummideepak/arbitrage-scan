package com.arbitragescan.arbitragescandemo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.arbitragescan.arbitragescandemo.models.CoinbaseExchange;
import com.arbitragescan.arbitragescandemo.models.Exchange;
import com.arbitragescan.arbitragescandemo.models.ExchangePair;

import org.springframework.stereotype.Service;

@Service
public class ExchangeService {
    private List<Exchange> exchangeList;
    
    // @Autowired
    // public RestService restService;
    
    ExchangeService(RestService restService){
        this.exchangeList = new ArrayList<>();
        this.exchangeList.add(new CoinbaseExchange(restService));
    }

    public Map<String,Double> getAllBuyPrices(ExchangePair exchangePair){
        return this.getAllBuyPrices(exchangePair,new HashSet<>());
    }

    public Map<String,Double> getAllBuyPrices(ExchangePair exchangePair,Set<String> excudeList){
        Map<String,Double> result = new HashMap<>();
        for(Exchange exchange : exchangeList){
            if(!excudeList.contains(exchange.getName())){
                result.put(exchange.getName(),exchange.getBuyPrice(exchangePair));
            }
        }
        return result;
    }

    public List<String> getAllAvailableExchanges(){
        List<String> result = new ArrayList<>();
        for(Exchange exchange : exchangeList){
            result.add(exchange.getName());
        }
        return result;
    }
}
