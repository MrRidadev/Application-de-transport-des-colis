import { Component, OnInit } from '@angular/core';
import { TrajetService } from '../../services/TrajetService';
import { Trajet } from '../../Model/trajet.model';
import {CommonModule, NgForOf} from '@angular/common';

@Component({
  selector: 'app-annonce-cards',
  standalone: true,
  imports: [
    NgForOf,
    CommonModule,

  ],
  templateUrl: './annonce-cards.html',
  styleUrl: './annonce-cards.css'
})
export class AnnonceCards implements OnInit {

  trajets: Trajet[] = [];


  constructor(private trajetService: TrajetService) {}

  ngOnInit(): void {
    this.trajetService.getAllTrajets().subscribe({
      next: (data) => this.trajets = data,
      error: (err) => console.error('Erreur lors du chargement des trajets', err)
    });
  }
}
