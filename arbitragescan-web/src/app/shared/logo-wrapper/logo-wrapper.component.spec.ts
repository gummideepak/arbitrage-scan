import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LogoWrapperComponent } from './logo-wrapper.component';

describe('LogoWrapperComponent', () => {
  let component: LogoWrapperComponent;
  let fixture: ComponentFixture<LogoWrapperComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LogoWrapperComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LogoWrapperComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
