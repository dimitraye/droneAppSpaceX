import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FlightcontrollerDetailsComponent } from './flightcontroller-details.component';

describe('FlightcontrollerDetailsComponent', () => {
  let component: FlightcontrollerDetailsComponent;
  let fixture: ComponentFixture<FlightcontrollerDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FlightcontrollerDetailsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FlightcontrollerDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
