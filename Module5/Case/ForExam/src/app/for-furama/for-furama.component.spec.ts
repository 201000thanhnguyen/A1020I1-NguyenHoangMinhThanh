import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ForFuramaComponent } from './for-furama.component';

describe('ForFuramaComponent', () => {
  let component: ForFuramaComponent;
  let fixture: ComponentFixture<ForFuramaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ForFuramaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ForFuramaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
