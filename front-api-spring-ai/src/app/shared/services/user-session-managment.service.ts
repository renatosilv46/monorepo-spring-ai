import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class UserSessionManagmentService {
  private readonly USER_ID_KEY = 'userId';

  getUserId(): string {
    return sessionStorage.getItem(this.USER_ID_KEY) || '';
  }

  setUserId(userId: string): void {
    sessionStorage.setItem(this.USER_ID_KEY, userId);
  }

  clearUserId(): void {
    sessionStorage.removeItem(this.USER_ID_KEY);
  }

  isAuthenticated(): boolean {
    return !!this.getUserId();
  }
}
