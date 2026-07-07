import { HttpClient, HttpParams } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { environment } from '../../../environments/environment';
import { UserRequest, UserResponse } from '../dtos/user.dto';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {
  private readonly http = inject(HttpClient);
  private readonly apiUrl = `${environment.SPRING_AI_API_URL}/users`;

  public authenticate(userRequest: UserRequest): Observable<UserResponse> {
    const httpParams: HttpParams = new HttpParams().append('username', userRequest.username);
    return this.http.get<UserResponse>(this.apiUrl, { params: httpParams });
  }
}
