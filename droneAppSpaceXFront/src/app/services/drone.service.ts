import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Drone } from '../models/drone';

@Injectable({
  providedIn: 'root'
})
export class DroneService {

  private apiUrl = 'http://localhost:8088/api/drones'; // à adapter selon ton controller

  constructor(private http: HttpClient) {}

  getAll(): Observable<Drone[]> {
    return this.http.get<Drone[]>(this.apiUrl);
  }

  getById(id: number): Observable<Drone> {
    return this.http.get<Drone>(`${this.apiUrl}/${id}`);
  }

  create(drone: Drone): Observable<Drone> {
    return this.http.post<Drone>(this.apiUrl, drone);
  }

  update(id: number, drone: Drone): Observable<Drone> {
    return this.http.put<Drone>(`${this.apiUrl}/${id}`, drone);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
