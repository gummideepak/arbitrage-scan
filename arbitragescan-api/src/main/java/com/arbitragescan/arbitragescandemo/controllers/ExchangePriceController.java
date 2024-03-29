package com.arbitragescan.arbitragescandemo.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.arbitragescan.arbitragescandemo.dtos.ArbitrageDto;
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
        // return
        // this.restController.getPostsPlainJSON("https://api.coinbase.com/v2/prices/BTC-USD/buy");
        // Exchange coinbase = new CoinbaseExchange(restController);
        // return coinbase.getBuyPrice(null);
        return null;
    }

    @GetMapping("/getTickersBuyPrices")
    public Map<String, Map<String, ExchangePriceDto>> getTickersBuyPrices(@RequestParam List<String> cryptoTickerList,
            String fiatCurrency) {
        Map<String, Map<String, ExchangePriceDto>> result = new HashMap<>();
        for (String cryptoTicker : cryptoTickerList) {
            Map<String, ExchangePriceDto> exchangePrices = this.exchangeService
                    .getAllPrices(new ExchangePair(fiatCurrency, cryptoTicker));
            result.put(cryptoTicker, exchangePrices);
        }
        return result;
    }

    @GetMapping("/getArbitrageList")
    public List<ArbitrageDto> getArbitrageList(@RequestParam List<String> cryptoTickerList, String fiatCurrency) {
        Map<String, Map<String, ExchangePriceDto>> allPrices = getTickersBuyPrices(cryptoTickerList, fiatCurrency);
        List<ArbitrageDto> result = new ArrayList<>();
        for (String key : allPrices.keySet()) {
            if (allPrices.get(key).size() > 1) {
                Map<String, ExchangePriceDto> temp = allPrices.get(key);
                ExchangePriceDto buyEntry = temp.entrySet().stream()
                        .min((Entry<String, ExchangePriceDto> e1,
                                Entry<String, ExchangePriceDto> e2) -> e1.getValue().topSellOrder
                                        .compareTo(e2.getValue().topSellOrder))
                        .get().getValue();
                ExchangePriceDto sellEntry = temp.entrySet().stream()
                        .filter(x -> !x.getValue().exchangeName.equals(buyEntry.exchangeName))
                        .max((Entry<String, ExchangePriceDto> e1,
                                Entry<String, ExchangePriceDto> e2) -> e1.getValue().topBuyOrder
                                        .compareTo(e2.getValue().topBuyOrder))
                        .get().getValue();

                ExchangePriceDto sellEntry2 = temp.entrySet().stream()
                        .max((Entry<String, ExchangePriceDto> e1,
                                Entry<String, ExchangePriceDto> e2) -> e1.getValue().topBuyOrder
                                        .compareTo(e2.getValue().topBuyOrder))
                        .get().getValue();
                ExchangePriceDto buyEntry2 = temp.entrySet().stream()
                        .filter(x -> !x.getValue().exchangeName.equals(sellEntry2.exchangeName))
                        .min((Entry<String, ExchangePriceDto> e1,
                                Entry<String, ExchangePriceDto> e2) -> e1.getValue().topSellOrder
                                        .compareTo(e2.getValue().topSellOrder))
                        .get().getValue();
                if (sellEntry.topBuyOrder - buyEntry.topSellOrder > sellEntry2.topBuyOrder - buyEntry.topSellOrder) {
                    if (!buyEntry.exchangeName.equals(sellEntry.exchangeName)
                            && buyEntry.topSellOrder < sellEntry.topBuyOrder) {
                        ArbitrageDto arbitrageDtoEntry = new ArbitrageDto();
                        arbitrageDtoEntry.numOfTokens = "1";
                        arbitrageDtoEntry.usdEquivalentBuy = buyEntry.topSellOrder.toString();
                        arbitrageDtoEntry.usdEquivalentSell = sellEntry.topBuyOrder.toString();
                        arbitrageDtoEntry.exchangeNameBuy = buyEntry.exchangeName;
                        arbitrageDtoEntry.exchangeNameSell = sellEntry.exchangeName;
                        arbitrageDtoEntry.tokenName = key;
                        result.add(arbitrageDtoEntry);
                    }
                } else {
                    if (!buyEntry2.exchangeName.equals(sellEntry2.exchangeName)
                            && buyEntry2.topSellOrder < sellEntry2.topBuyOrder) {
                        ArbitrageDto arbitrageDtoEntry = new ArbitrageDto();
                        arbitrageDtoEntry.numOfTokens = "1";
                        arbitrageDtoEntry.usdEquivalentBuy = buyEntry2.topSellOrder.toString();
                        arbitrageDtoEntry.usdEquivalentSell = sellEntry2.topBuyOrder.toString();
                        arbitrageDtoEntry.exchangeNameBuy = buyEntry2.exchangeName;
                        arbitrageDtoEntry.exchangeNameSell = sellEntry2.exchangeName;
                        arbitrageDtoEntry.tokenName = key;
                        result.add(arbitrageDtoEntry);
                    }
                }

            }
        }
        return result;
    }
}
