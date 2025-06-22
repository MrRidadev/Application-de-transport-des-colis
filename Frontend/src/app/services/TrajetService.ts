import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TrajetService {

  private apiUrl = 'http://localhost:8080/Trajet/findAllTrajet';

  constructor(private http: HttpClient) {}

  getAllTrajets(): Observable<TrajetService[]> {
    return this.http.get<TrajetService[]>(this.apiUrl);
}}
