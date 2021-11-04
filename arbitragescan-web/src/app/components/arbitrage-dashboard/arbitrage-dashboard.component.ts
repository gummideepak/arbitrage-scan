import { ArbitrageDto } from './../../../../swagger/model/arbitrageDto';
import { ArbitrageService } from './arbitrage.service';
import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-arbitrage-dashboard',
  templateUrl: './arbitrage-dashboard.component.html',
  styleUrls: ['./arbitrage-dashboard.component.scss'],
})
export class ArbitrageDashboardComponent implements OnInit {
  selectedCryptos = new FormControl();
  breakpoint:number = 0;
  arbitrageOptions:ArbitrageDto[] = [];
  cryptos = ["BTC","ETH","SOL","LTC","BCH"];
  constructor(private arbitrageService: ArbitrageService) {

  }

  ngOnInit() {
    this.breakpoint = window.innerWidth <= 650 ? 1 : 4;
    this.arbitrageService.getArbitrage(this.cryptos).subscribe(x => {
      this.arbitrageOptions = x;
      console.log(x);
    });
  }
  getProfit(sell:number,buy:number){
    return (sell-buy).toPrecision(4);
  }

  onResize(event:any) {
    console.log(event);
    this.breakpoint = event.target.innerWidth <= 650 ? 1 : 4;
  }
  scan(){
    let options = this.selectedCryptos.value;
    if(options == null || options.length == 0){
      options = this.cryptos;
    }
    this.arbitrageService.getArbitrage(options).subscribe(x => {
      this.arbitrageOptions = x;
      console.log(x);
    });
  }
}
