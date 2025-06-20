import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnnonceCards } from './annonce-cards';

describe('AnnonceCards', () => {
  let component: AnnonceCards;
  let fixture: ComponentFixture<AnnonceCards>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AnnonceCards]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AnnonceCards);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
