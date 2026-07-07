import { Routes } from '@angular/router';
import { InvestmentsPlanComponent } from './pages/investments-plan/investments-plan.component';
import { ImageGeneratorComponent } from './pages/image-generator/image-generator.component';
import { authenticationGuard } from './shared/guards/authentication.guard';

export const routes: Routes = [
  {
    path: 'investments-plan',
    loadComponent: () =>
      import('./pages/investments-plan/investments-plan.component').then((m) => m.InvestmentsPlanComponent),
    canActivate: [authenticationGuard],
  },
  {
    path: 'image-generator',
    loadComponent: () =>
      import('./pages/image-generator/image-generator.component').then((m) => m.ImageGeneratorComponent),
    canActivate: [authenticationGuard],
  },
  {
    path: 'authentication',
    loadComponent: () =>
      import('./pages/authentication/authentication.component').then((m) => m.AuthenticationComponent),
  },
  {
    path: '',
    redirectTo: 'authentication',
    pathMatch: 'full',
  },
];
