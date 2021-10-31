import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArbitrageDashboardComponent } from './arbitrage-dashboard.component';

describe('ArbitrageDashboardComponent', () => {
  let component: ArbitrageDashboardComponent;
  let fixture: ComponentFixture<ArbitrageDashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ArbitrageDashboardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ArbitrageDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
