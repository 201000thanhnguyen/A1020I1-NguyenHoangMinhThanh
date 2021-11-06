import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExSavingComponent } from './ex-saving.component';

describe('ExSavingComponent', () => {
  let component: ExSavingComponent;
  let fixture: ComponentFixture<ExSavingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExSavingComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExSavingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
