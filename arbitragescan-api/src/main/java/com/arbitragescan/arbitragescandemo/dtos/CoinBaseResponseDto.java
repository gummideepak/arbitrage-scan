package com.arbitragescan.arbitragescandemo.dtos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CoinBaseResponseDto {
    private String base;
    private String currency;
    private String amount;

    private CoinBaseResponseDto() {
    }

    private CoinBaseResponseDto(CoinBaseResponseDto dto) {
        this.base = dto.base;
        this.currency = dto.currency;
        this.amount = dto.amount;
    }


    static CoinBaseResponseDto getCoinBaseResponseDtoFromJson(String jsonResString){
        try{
            ObjectMapper mapper = new ObjectMapper();
            CoinBaseResponseDto coinBaseResponseDto = mapper.readValue(jsonResString, CoinBaseResponseDto.class);
            return new CoinBaseResponseDto(coinBaseResponseDto);
        }
        catch(JsonProcessingException ex){
            ex.printStackTrace();
        }
        return null;
    }


    public String getBase() {
        return this.base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

}
