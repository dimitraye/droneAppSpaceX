import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-gpsmodule-details',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './gpsmodule-details.component.html',
  styleUrl: './gpsmodule-details.component.scss'
})
export class GpsmoduleDetailsComponent implements OnInit {
  gpsModuleId: number | null = null;

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.gpsModuleId = Number(this.route.snapshot.paramMap.get('id'));
  }
}
