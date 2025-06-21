import { Component } from '@angular/core';
import {AnnonceCards} from '../annonce-cards/annonce-cards';

@Component({
  selector: 'app-header',
  imports: [
    AnnonceCards
  ],
  templateUrl: './header.html',
  styleUrl: './header.css'
})
export class Header {

}
