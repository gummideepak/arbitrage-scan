import { Injectable } from '@angular/core';
import { ExchangePriceControllerService } from 'swagger';

@Injectable({
  providedIn: 'root'
})
export class ArbitrageService {

  constructor(private exchangePriceController: ExchangePriceControllerService) { }

  getArbitrage(cryptos:string[]){
    if(cryptos == null) cryptos = [""];
    return this.exchangePriceController.getArbitrageListUsingGET(cryptos,"USD");
  }
}
