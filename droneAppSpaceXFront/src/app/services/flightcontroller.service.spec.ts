import { TestBed } from '@angular/core/testing';

import { FlightcontrollerService } from './flightcontroller.service';

describe('FlightcontrollerService', () => {
  let service: FlightcontrollerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FlightcontrollerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
