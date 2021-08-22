import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerControllerComponent } from './customer-controller.component';

describe('CustomerControllerComponent', () => {
  let component: CustomerControllerComponent;
  let fixture: ComponentFixture<CustomerControllerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerControllerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerControllerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
