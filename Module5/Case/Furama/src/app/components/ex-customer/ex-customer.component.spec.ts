import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExCustomerComponent } from './ex-customer.component';

describe('ExCustomerComponent', () => {
  let component: ExCustomerComponent;
  let fixture: ComponentFixture<ExCustomerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExCustomerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
