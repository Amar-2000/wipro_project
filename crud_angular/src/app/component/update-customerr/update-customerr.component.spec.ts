import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateCustomerrComponent } from './update-customerr.component';

describe('UpdateCustomerrComponent', () => {
  let component: UpdateCustomerrComponent;
  let fixture: ComponentFixture<UpdateCustomerrComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UpdateCustomerrComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateCustomerrComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
