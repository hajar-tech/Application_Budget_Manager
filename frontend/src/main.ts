import { ApplicationConfig } from '@angular/core';
import { provideHttpClient, withFetch } from '@angular/common/http';
import {AppComponent} from './app/app.component';
import {bootstrapApplication} from '@angular/platform-browser';
// ✅ Add this import


bootstrapApplication(AppComponent, {
  providers: [
    provideHttpClient(withFetch()) // ✅ active l’utilisation de fetch
  ]
});

