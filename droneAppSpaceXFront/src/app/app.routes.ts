import { Routes } from '@angular/router';
import { CameraListComponent } from './cameras/camera-list/camera-list.component';
import { DroneListComponent } from './drones/drone-list/drone-list.component';
import { HomeComponent } from './home/home.component';
import { GpsmoduleListComponent } from './gpsmodules/gpsmodule-list/gpsmodule-list.component';
import { FlightcontrollerListComponent } from './flightcontrollers/flightcontroller-list/flightcontroller-list.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'drones', component: DroneListComponent },
  { path: 'cameras', component: CameraListComponent },
  { path: 'gpsmodules', component: GpsmoduleListComponent },
  { path: 'flightcontrollers', component: FlightcontrollerListComponent },
];
