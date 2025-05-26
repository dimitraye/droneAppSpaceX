import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FlightcontrollerFormComponent } from './flightcontroller-form.component';

describe('FlightcontrollerFormComponent', () => {
  let component: FlightcontrollerFormComponent;
  let fixture: ComponentFixture<FlightcontrollerFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FlightcontrollerFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FlightcontrollerFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
