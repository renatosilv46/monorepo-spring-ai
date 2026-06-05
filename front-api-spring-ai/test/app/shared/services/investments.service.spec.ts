import { TestBed } from '@angular/core/testing';

import { InvestmentsService } from '../../../../src/app/shared/services/investments.service';

describe('InvestmentsService', () => {
  let service: InvestmentsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(InvestmentsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
