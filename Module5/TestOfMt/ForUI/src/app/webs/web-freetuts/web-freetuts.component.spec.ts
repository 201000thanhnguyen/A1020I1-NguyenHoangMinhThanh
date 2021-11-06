import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WebFreetutsComponent } from './web-freetuts.component';

describe('WebFreetutsComponent', () => {
  let component: WebFreetutsComponent;
  let fixture: ComponentFixture<WebFreetutsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WebFreetutsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(WebFreetutsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
