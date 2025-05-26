import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormSelectEntityComponent } from './form-select-entity.component';

describe('FormSelectEntityComponent', () => {
  let component: FormSelectEntityComponent;
  let fixture: ComponentFixture<FormSelectEntityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormSelectEntityComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FormSelectEntityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
