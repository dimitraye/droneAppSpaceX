import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-gpsmodule-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './gpsmodule-list.component.html',
  styleUrl: './gpsmodule-list.component.scss'
})
export class GpsmoduleListComponent {

  gpsModules: {
    id: number;
    model: string;
    gpsPrecision: string;
    latitude: number;
    longitude: number;
    altitude: number;
    features: string;
    geofencingEnabled: boolean;
    realTimeTrackingEnabled: boolean;
  }[] = [];

  selectedGpsModule: number | null = null;

  constructor(private router: Router) {}

  ngOnInit(): void {
    this.gpsModules = [
      {
        id: 1,
        model: 'Ublox M7',
        gpsPrecision: '5 mètres',
        latitude: 48.8584,
        longitude: 2.2945,
        altitude: 30,
        features: 'Waypoint navigation',
        geofencingEnabled: false,
        realTimeTrackingEnabled: true
      },
      {
        id: 2,
        model: 'Ublox NEO-M8N',
        gpsPrecision: '1 mètre',
        latitude: 48.8566,
        longitude: 2.3522,
        altitude: 35,
        features: 'RTK, geofencing, waypoint navigation',
        geofencingEnabled: true,
        realTimeTrackingEnabled: true
      }
    ];
  }

  selectGpsModule(id: number): void {
    this.selectedGpsModule = id;
    this.router.navigate(['/gpsmodule-details', id]);
  }

  editGpsModule(id: number, event: MouseEvent): void {
    event.stopPropagation();
    alert(`Éditer GPS Module avec ID: ${id}`);
    // Exemple : this.router.navigate(['/gpsmodule-edit', id]);
  }

  deleteGpsModule(id: number, event: MouseEvent): void {
    event.stopPropagation();
    if (confirm('Voulez-vous vraiment supprimer ce GPS Module ?')) {
      this.gpsModules = this.gpsModules.filter(gps => gps.id !== id);
    }
  }

  createGpsModule(): void {
    this.router.navigate(['/gpsmodule-form']);
  }
}
