import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-flightcontroller-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './flightcontroller-list.component.html',
  styleUrl: './flightcontroller-list.component.scss'
})
export class FlightcontrollerListComponent implements OnInit {

  flightControllers: { id: number; name: string }[] = [];
  selectedFlightController: number | null = null;

  constructor(private router: Router) {}

  ngOnInit(): void {
    this.flightControllers = [
      { id: 1, name: 'FC Model A' },
      { id: 2, name: 'FC Model B' },
      { id: 3, name: 'FC Model C' },
      { id: 4, name: 'FC Model D' },
      { id: 5, name: 'FC Model E' }
    ];
  }

  selectFlightController(id: number) {
    this.selectedFlightController = id;
    this.router.navigate(['/flightcontroller-details', id]);
  }

  editFlightController(id: number, event: MouseEvent): void {
    event.stopPropagation();
    alert(`Éditer FlightController avec ID: ${id}`);
    // this.router.navigate(['/flightcontroller-edit', id]);
  }

  deleteFlightController(id: number, event: MouseEvent): void {
    event.stopPropagation();
    if (confirm('Voulez-vous vraiment supprimer ce FlightController ?')) {
      this.flightControllers = this.flightControllers.filter(fc => fc.id !== id);
    }
  }

  createFlightController(): void {
    this.router.navigate(['/flightcontroller-form']);
  }
}
