import { Injectable } from '@angular/core';
import { ExchangePriceControllerService } from 'swagger';

@Injectable({
  providedIn: 'root'
})
export class ArbitrageService {

  constructor(private exchangePriceController: ExchangePriceControllerService) { }

  getArbitrage(){
    return this.exchangePriceController.getArbitrageListUsingGET(["BTC","ETH"],"USD");
  }
}
