import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AttachServiceComponent } from './attach-service.component';

describe('AttachServiceComponent', () => {
  let component: AttachServiceComponent;
  let fixture: ComponentFixture<AttachServiceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AttachServiceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AttachServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
