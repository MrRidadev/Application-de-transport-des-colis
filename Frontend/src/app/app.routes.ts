import { Routes } from '@angular/router';
import {Header} from './pages/header/header';
import {Login} from './pages/login/login';
import {Register} from './pages/register/register';
import {AnnonceCards} from './pages/annonce-cards/annonce-cards';

export const routes: Routes = [

  {
    path: '',
    component : Header
  },
  {
    path: 'login',
    component:Login
  },
  {
    path: 'register',
    component:Register
  },
  {
    path: 'annonce',
    component: AnnonceCards
  }

];
