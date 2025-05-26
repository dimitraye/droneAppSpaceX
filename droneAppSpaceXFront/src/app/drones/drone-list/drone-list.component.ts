import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-drone-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './drone-list.component.html',
  styleUrl: './drone-list.component.scss'
})
export class DroneListComponent {

  drones: { id: number; name: string }[] = [];
    selectedDrone: number | null = null;
  
    constructor(private router: Router) {}
  
    ngOnInit(): void {
      this.drones = [
        { id: 1, name: 'Drone Alpha' },
        { id: 2, name: 'Drone Bravo' },
        { id: 3, name: 'Drone Charlie' },
        { id: 4, name: 'Drone Delta' },
        { id: 5, name: 'Drone Echo' },
        { id: 6, name: 'Drone Foxtrot' },
        { id: 7, name: 'Drone Golf' },
        { id: 8, name: 'Drone Hotel' },
        { id: 9, name: 'Drone India' }
      ];
    }
  
    selectDrone(id: number) {
      this.selectedDrone = id;
      this.router.navigate(['/drone-details', id]);
    }
  
    editDrone(id: number, event: MouseEvent): void {
      event.stopPropagation();
      alert(`Éditer drone avec ID: ${id}`);
      // rediriger vers une page de modification par exemple
      // this.router.navigate(['/drone-edit', id]);
    }
  
    deleteDrone(id: number, event: MouseEvent): void {
      event.stopPropagation();
      if (confirm('Voulez-vous vraiment supprimer ce drone ?')) {
        this.drones = this.drones.filter(drone => drone.id !== id);
      }
    }

    createDrone(): void {
      this.router.navigate(['/drone-form']);
    }

}
