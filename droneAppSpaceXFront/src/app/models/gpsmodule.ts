export interface GPSModule {
  id?: number;
  model: string;
  latitude: number;
  longitude: number;
  altitude: number;
  features: string;
  gpsPrecision: string;
  geofencingEnabled: boolean;
  realTimeTrackingEnabled: boolean;
}
