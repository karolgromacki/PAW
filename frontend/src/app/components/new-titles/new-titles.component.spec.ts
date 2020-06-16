import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewTitlesComponent } from './new-titles.component';

describe('NewTitlesComponent', () => {
  let component: NewTitlesComponent;
  let fixture: ComponentFixture<NewTitlesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewTitlesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewTitlesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
