import { TestBed } from '@angular/core/testing';

import { BusinessRequirementService } from './business-requirement.service';

describe('BusinessRequirementService', () => {
  let service: BusinessRequirementService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BusinessRequirementService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
