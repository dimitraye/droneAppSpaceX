import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-drone-details',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './drone-details.component.html',
  styleUrl: './drone-details.component.scss'
})
export class DroneDetailsComponent implements OnInit {
  droneId: number | null = null;

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.droneId = Number(this.route.snapshot.paramMap.get('id'));
  }
}
