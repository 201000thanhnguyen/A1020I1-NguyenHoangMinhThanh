import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerTypeDetailComponent } from './customer-type-detail.component';

describe('CustomerTypeDetailComponent', () => {
  let component: CustomerTypeDetailComponent;
  let fixture: ComponentFixture<CustomerTypeDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerTypeDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerTypeDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
