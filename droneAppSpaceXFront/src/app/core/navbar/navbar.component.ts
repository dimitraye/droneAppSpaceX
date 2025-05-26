import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.scss'
})
export class NavbarComponent {

  constructor(private router: Router) {}

  goHome(): void {
    this.router.navigate(['/']);
  }

  goToDrones(): void {
    this.router.navigate(['/drones']);
  }

  goToCameras(): void {
    this.router.navigate(['/cameras']);
  }

  goToGPSModules(): void {
    this.router.navigate(['/gpsmodules']);
  }

  goToFlightControllers(): void {
    this.router.navigate(['/flightcontrollers']);
  }
}
