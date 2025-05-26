import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GpsmoduleDetailsComponent } from './gpsmodule-details.component';

describe('GpsmoduleDetailsComponent', () => {
  let component: GpsmoduleDetailsComponent;
  let fixture: ComponentFixture<GpsmoduleDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GpsmoduleDetailsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(GpsmoduleDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
