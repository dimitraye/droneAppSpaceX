import { TestBed } from '@angular/core/testing';

import { GpsmoduleService } from './gpsmodule.service';

describe('GpsmoduleService', () => {
  let service: GpsmoduleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GpsmoduleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
