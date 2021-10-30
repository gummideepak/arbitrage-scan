package com.arbitragescan.arbitragescandemo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.arbitragescan.arbitragescandemo.dtos.ExchangePriceDto;
import com.arbitragescan.arbitragescandemo.models.CoinbaseExchange;
import com.arbitragescan.arbitragescandemo.models.Exchange;
import com.arbitragescan.arbitragescandemo.models.ExchangePair;
import com.arbitragescan.arbitragescandemo.models.FTXExchange;
import com.arbitragescan.arbitragescandemo.models.KrakenExchange;

import org.springframework.stereotype.Service;

@Service
public class ExchangeService {
    private List<Exchange> exchangeList;
    
    // @Autowired
    // public RestService restService;
    
    ExchangeService(RestService restService){
        this.exchangeList = new ArrayList<>();
        this.exchangeList.add(new CoinbaseExchange(restService));
        this.exchangeList.add(new KrakenExchange(restService));
        this.exchangeList.add(new FTXExchange(restService));
    }

    public Map<String,ExchangePriceDto> getAllPrices(ExchangePair exchangePair){
        return this.getAllPrices(exchangePair,new HashSet<>());
    }

    public Map<String,ExchangePriceDto> getAllPrices(ExchangePair exchangePair,Set<String> excudeList){
        Map<String,ExchangePriceDto> result = new HashMap<>();
        for(Exchange exchange : exchangeList){
            if(!excudeList.contains(exchange.getName())){
                ExchangePriceDto exchangePrice = exchange.getPrice(exchangePair);
                if(exchangePrice != null){
                    result.put(exchange.getName(),exchangePrice);
                }   
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
