import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {Navbar} from './pages/navbar/navbar';
import {Header} from './pages/header/header';
import {AnnonceCards} from './pages/annonce-cards/annonce-cards';
import {Footer} from './pages/footer/footer';
import {Login} from './pages/login/login';
import {Register} from './pages/register/register';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Navbar, Header, AnnonceCards, Footer, Login, Register],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title = 'Frontend';
}
