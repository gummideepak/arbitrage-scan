import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-logo-wrapper',
  templateUrl: './logo-wrapper.component.html',
  styleUrls: ['./logo-wrapper.component.scss']
})
export class LogoWrapperComponent implements OnInit {

  @Input() logo = '';


  constructor() { }

  ngOnInit(): void {
  }

}
