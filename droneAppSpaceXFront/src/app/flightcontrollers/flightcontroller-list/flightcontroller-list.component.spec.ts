import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FlightcontrollerListComponent } from './flightcontroller-list.component';

describe('FlightcontrollerListComponent', () => {
  let component: FlightcontrollerListComponent;
  let fixture: ComponentFixture<FlightcontrollerListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FlightcontrollerListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FlightcontrollerListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
