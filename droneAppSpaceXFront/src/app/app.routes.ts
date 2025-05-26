import { Routes } from '@angular/router';
import { CameraListComponent } from './cameras/camera-list/camera-list.component';
import { DroneListComponent } from './drones/drone-list/drone-list.component';
import { HomeComponent } from './home/home.component';
import { GpsmoduleListComponent } from './gpsmodules/gpsmodule-list/gpsmodule-list.component';
import { FlightcontrollerListComponent } from './flightcontrollers/flightcontroller-list/flightcontroller-list.component';
import { DroneDetailsComponent } from './drones/drone-details/drone-details.component';
import { CameraDetailsComponent } from './cameras/camera-details/camera-details.component';
import { GpsmoduleDetailsComponent } from './gpsmodules/gpsmodule-details/gpsmodule-details.component';
import { FlightcontrollerDetailsComponent } from './flightcontrollers/flightcontroller-details/flightcontroller-details.component';
import { DroneFormComponent } from './drones/drone-form/drone-form.component';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'drones', component: DroneListComponent },
  { path: 'drone-details/:id', component: DroneDetailsComponent },
  { path: 'drone-form', component: DroneFormComponent },
  { path: 'cameras', component: CameraListComponent },
  { path: 'camera-details/:id', component: CameraDetailsComponent },
  { path: 'gpsmodules', component: GpsmoduleListComponent },
  { path: 'gpsmodules-details/:id', component: GpsmoduleDetailsComponent },
  { path: 'flightcontrollers', component: FlightcontrollerListComponent },
  { path: 'flightcontrollers-details/:id', component: FlightcontrollerDetailsComponent }
];
