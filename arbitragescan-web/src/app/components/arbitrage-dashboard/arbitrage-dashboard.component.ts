import { ArbitrageDto } from './../../../../swagger/model/arbitrageDto';
import { ArbitrageService } from './arbitrage.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-arbitrage-dashboard',
  templateUrl: './arbitrage-dashboard.component.html',
  styleUrls: ['./arbitrage-dashboard.component.scss'],
})
export class ArbitrageDashboardComponent implements OnInit {
  breakpoint:number = 0;
  arbitrageOptions:ArbitrageDto[] = [];
  constructor(private arbitrageService: ArbitrageService) {

  }

  ngOnInit() {
    this.breakpoint = window.innerWidth <= 650 ? 1 : 4;
    this.arbitrageService.getArbitrage().subscribe(x => {
      this.arbitrageOptions = x;
      console.log(x);
    });
  }

  onResize(event:any) {
    console.log(event);
    this.breakpoint = event.target.innerWidth <= 650 ? 1 : 4;
  }
}
