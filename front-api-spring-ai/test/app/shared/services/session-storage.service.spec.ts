import { TestBed } from '@angular/core/testing';

import { AuthenticationService } from '../../../../src/app/shared/services/user-session-managment.service';

describe('AuthenticationService', () => {
  let service: AuthenticationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthenticationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
