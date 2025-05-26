export interface FlightController {
  id?: number;
  model: string;
  supportedFlightModes: string;
  currentSpeed: number;
  targetAltitude: number;
  commandInterpretation: string;
  autoStabilizationEnabled: boolean;
  emergencyReturnEnabled: boolean;
}
