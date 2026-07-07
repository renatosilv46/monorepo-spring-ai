import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';
import { UserSessionManagmentService } from '../services/user-session-managment.service';

export const authenticationGuard: CanActivateFn = () => {
  const router = inject(Router);
  const userSessionManagmentService = inject(UserSessionManagmentService);

  if (userSessionManagmentService.isAuthenticated()) {
    return true;
  }

  router.navigate(['/authentication']);

  return false;
};
