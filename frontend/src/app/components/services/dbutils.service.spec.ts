import { TestBed } from '@angular/core/testing';

import { DBUtilsService } from './dbutils.service';

describe('DBUtilsService', () => {
  let service: DBUtilsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DBUtilsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
