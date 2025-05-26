import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-camera-details',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './camera-details.component.html',
  styleUrls: ['./camera-details.component.scss']
})
export class CameraDetailsComponent implements OnInit {

  cameraId: number | null = null;

  // Exemple d'objet camera, ici statique, tu pourras remplacer par un service
  camera = {
    id: 2,
    resolution: '4K',
    brand: 'Sony',
    zoom: 3.5
  };

  constructor(private route: ActivatedRoute, private router: Router) {}

  ngOnInit(): void {
    this.cameraId = Number(this.route.snapshot.paramMap.get('id'));
    // Ici tu pourrais récupérer les détails via un service selon cameraId
  }

  editCamera(id: number): void {
    alert(`Modifier caméra ID: ${id}`);
    // this.router.navigate(['/camera-edit', id]);
  }

  deleteCamera(id: number): void {
    if (confirm('Voulez-vous vraiment supprimer cette caméra ?')) {
      alert(`Caméra ${id} supprimée.`);
      // Appeler un service pour supprimer la caméra
    }
  }

  goBack(): void {
    this.router.navigate(['/cameras']);
  }
}
