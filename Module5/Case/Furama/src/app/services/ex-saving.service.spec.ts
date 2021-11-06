import { TestBed } from '@angular/core/testing';

import { ExSavingService } from './ex-saving.service';

describe('ExSavingService', () => {
  let service: ExSavingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExSavingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
