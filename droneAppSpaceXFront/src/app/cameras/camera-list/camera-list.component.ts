import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-camera-list',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './camera-list.component.html',
  styleUrls: ['./camera-list.component.scss']
})
export class CameraListComponent {

  cameras: { id: number; brand: string; resolution: string; zoom: number }[] = [];
  selectedCamera: number | null = null;

  constructor(private router: Router) {}

  ngOnInit(): void {
    this.cameras = [
      { id: 1, brand: 'Canon', resolution: '1080p', zoom: 2 },
      { id: 2, brand: 'Sony', resolution: '4K', zoom: 3.5 },
      { id: 3, brand: 'Nikon', resolution: '720p', zoom: 1.8 },
      { id: 4, brand: 'GoPro', resolution: '4K', zoom: 1 },
      // ajoute d'autres caméras si tu veux
    ];
  }

  selectCamera(id: number): void {
    this.selectedCamera = id;
    this.router.navigate(['/camera-details', id]);
  }

  editCamera(id: number, event: MouseEvent): void {
    event.stopPropagation();
    alert(`Modifier caméra avec ID: ${id}`);
    // par exemple, rediriger vers une page d'édition
    //this.router.navigate(['/camera-form', id]);
  }

  deleteCamera(id: number, event: MouseEvent): void {
    event.stopPropagation();
    if (confirm('Voulez-vous vraiment supprimer cette caméra ?')) {
      this.cameras = this.cameras.filter(camera => camera.id !== id);
    }
  }

  createCamera(): void {
    this.router.navigate(['/camera-form']);
  }
}
