import { Component,OnInit } from '@angular/core';
import {TrajetService} from '../../services/TrajetService';
import {NgForOf} from '@angular/common';

@Component({
  selector: 'app-annonce-cards',
  imports: [
    NgForOf
  ],
  templateUrl: './annonce-cards.html',
  styleUrl: './annonce-cards.css'
})
export class AnnonceCards implements OnInit {

  trajets: TrajetService[] = [];

  constructor(private trajetService: TrajetService) {}

  ngOnInit(): void {
    this.trajetService.getAllTrajets().subscribe({
      next: (data) => this.trajets = data,
      error: (err) => console.error('Erreur lors du chargement des trajets', err)
    });
  }

}
