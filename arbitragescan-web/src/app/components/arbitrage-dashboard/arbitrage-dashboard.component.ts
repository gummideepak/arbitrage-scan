import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-arbitrage-dashboard',
  templateUrl: './arbitrage-dashboard.component.html',
  styleUrls: ['./arbitrage-dashboard.component.scss'],
})
export class ArbitrageDashboardComponent implements OnInit {
  breakpoint:number = 0;
  arbitrageOptions = [];
  constructor() {}

  ngOnInit() {
    this.breakpoint = window.innerWidth <= 650 ? 1 : 4;
  }

  onResize(event:any) {
    console.log(event);
    this.breakpoint = event.target.innerWidth <= 650 ? 1 : 4;
  }
}
