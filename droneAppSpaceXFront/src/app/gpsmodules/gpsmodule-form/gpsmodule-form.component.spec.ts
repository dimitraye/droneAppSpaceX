import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GpsmoduleFormComponent } from './gpsmodule-form.component';

describe('GpsmoduleFormComponent', () => {
  let component: GpsmoduleFormComponent;
  let fixture: ComponentFixture<GpsmoduleFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GpsmoduleFormComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(GpsmoduleFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
