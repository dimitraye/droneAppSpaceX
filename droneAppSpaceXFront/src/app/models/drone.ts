import { Camera } from "./camera";
import { FlightController } from "./flight-controller";
import { GPSModule } from "./gpsmodule";

export interface Drone {
  id?: number;
  model: string;
  weight: number;
  maxRange: number;
  batteryCapacity: number;
  camera?: Camera | null;
  gpsModule?: GPSModule | null;
  flightController?: FlightController | null;
}