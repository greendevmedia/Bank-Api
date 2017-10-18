import { TestBed, inject } from '@angular/core/testing';

import { DocumentDetailsService } from './document-details.service';

describe('DocumentDetailsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DocumentDetailsService]
    });
  });

  it('should be created', inject([DocumentDetailsService], (service: DocumentDetailsService) => {
    expect(service).toBeTruthy();
  }));
});
