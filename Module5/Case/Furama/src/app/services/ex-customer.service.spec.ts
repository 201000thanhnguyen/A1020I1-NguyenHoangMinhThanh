import { TestBed } from '@angular/core/testing';

import { ExCustomerService } from './ex-customer.service';

describe('ExCustomerService', () => {
  let service: ExCustomerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExCustomerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
