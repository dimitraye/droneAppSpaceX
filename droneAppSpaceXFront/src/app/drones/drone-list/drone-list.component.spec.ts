import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DroneListComponent } from './drone-list.component';

describe('DroneListComponent', () => {
  let component: DroneListComponent;
  let fixture: ComponentFixture<DroneListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DroneListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DroneListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
