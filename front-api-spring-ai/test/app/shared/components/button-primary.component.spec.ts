import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ButtonPrimaryComponent } from '../../../../src/app/shared/components/button-primary/button-primary.component';

describe('ButtonPrimaryComponent', () => {
  let component: ButtonPrimaryComponent;
  let fixture: ComponentFixture<ButtonPrimaryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ButtonPrimaryComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(ButtonPrimaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
