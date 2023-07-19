import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TablaCuentasComponent } from './tabla-cuentas.component';

describe('TablaCuentasComponent', () => {
  let component: TablaCuentasComponent;
  let fixture: ComponentFixture<TablaCuentasComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TablaCuentasComponent]
    });
    fixture = TestBed.createComponent(TablaCuentasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
