import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GpsmoduleListComponent } from './gpsmodule-list.component';

describe('GpsmoduleListComponent', () => {
  let component: GpsmoduleListComponent;
  let fixture: ComponentFixture<GpsmoduleListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GpsmoduleListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(GpsmoduleListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
