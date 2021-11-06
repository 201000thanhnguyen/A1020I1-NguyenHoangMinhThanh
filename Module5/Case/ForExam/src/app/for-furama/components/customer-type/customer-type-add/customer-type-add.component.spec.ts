import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerTypeAddComponent } from './customer-type-add.component';

describe('CustomerTypeAddComponent', () => {
  let component: CustomerTypeAddComponent;
  let fixture: ComponentFixture<CustomerTypeAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerTypeAddComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerTypeAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
