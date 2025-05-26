import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-flightcontroller-details',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './flightcontroller-details.component.html',
  styleUrls: ['./flightcontroller-details.component.scss']
})
export class FlightcontrollerDetailsComponent implements OnInit {

  flightControllerId: number | null = null;

  flightController: {
    id: number;
    model: string;
    supportedFlightModes: string;
    currentSpeed: number;
    targetAltitude: number;
    commandInterpretation: string;
    autoStabilizationEnabled: boolean;
    emergencyReturnEnabled: boolean;
  } | null = null;

  // Données mockées (à remplacer par un appel service)
  flightControllersMock = [
    {
      id: 1,
      model: 'FC Model A',
      supportedFlightModes: 'Manual, GPS Hold',
      currentSpeed: 10.0,
      targetAltitude: 100.0,
      commandInterpretation: 'Interprets basic commands',
      autoStabilizationEnabled: true,
      emergencyReturnEnabled: false,
    },
    {
      id: 2,
      model: 'Pixhawk',
      supportedFlightModes: 'Manual, GPS Hold, Waypoint, Return to Home',
      currentSpeed: 15.0,
      targetAltitude: 120.0,
      commandInterpretation: 'Interprets commands from ground station and autopilot',
      autoStabilizationEnabled: true,
      emergencyReturnEnabled: true,
    },
    {
      id: 3,
      model: 'FC Model C',
      supportedFlightModes: 'Manual, GPS Hold, Auto',
      currentSpeed: 12.0,
      targetAltitude: 110.0,
      commandInterpretation: 'Advanced command interpretation',
      autoStabilizationEnabled: false,
      emergencyReturnEnabled: true,
    },
    {
      id: 4,
      model: 'FC Model D',
      supportedFlightModes: 'Manual',
      currentSpeed: 8.0,
      targetAltitude: 90.0,
      commandInterpretation: 'Basic commands only',
      autoStabilizationEnabled: false,
      emergencyReturnEnabled: false,
    },
    {
      id: 5,
      model: 'FC Model E',
      supportedFlightModes: 'Manual, GPS Hold, Return to Home',
      currentSpeed: 14.0,
      targetAltitude: 115.0,
      commandInterpretation: 'Standard command interpreter',
      autoStabilizationEnabled: true,
      emergencyReturnEnabled: true,
    }
  ];

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.flightControllerId = Number(this.route.snapshot.paramMap.get('id'));
    if (this.flightControllerId) {
      this.flightController = this.flightControllersMock
        .find(fc => fc.id === this.flightControllerId) || null;
    }
  }
}
