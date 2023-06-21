import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuCuentasComponent } from './menu-cuentas.component';

describe('MenuCuentasComponent', () => {
  let component: MenuCuentasComponent;
  let fixture: ComponentFixture<MenuCuentasComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MenuCuentasComponent]
    });
    fixture = TestBed.createComponent(MenuCuentasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
