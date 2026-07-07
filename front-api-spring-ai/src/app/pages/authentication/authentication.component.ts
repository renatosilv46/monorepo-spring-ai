import { Component, DestroyRef, inject, signal } from '@angular/core';
import { AuthenticationService } from '../../shared/services/authentication.service';
import { UserRequest, UserResponse } from '../../shared/dtos/user.dto';
import { UserSessionManagmentService } from '../../shared/services/user-session-managment.service';
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';
import { InputComponent } from '../../shared/components/input/input.component';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { TranslatePipe } from '@ngx-translate/core';
import { ButtonPrimaryComponent } from '../../shared/components/button-primary/button-primary.component';

@Component({
  selector: 'app-authentication',
  standalone: true,
  imports: [InputComponent, TranslatePipe, ButtonPrimaryComponent, ReactiveFormsModule],
  templateUrl: './authentication.component.html',
  styleUrl: './authentication.component.scss',
})
export class AuthenticationComponent {
  private readonly authenticationService = inject(AuthenticationService);
  private readonly userSessionManagmentService = inject(UserSessionManagmentService);
  private readonly destroyRef = inject(DestroyRef);
  protected usernameControl = signal<FormControl>(new FormControl(''));
  private authenticatedUser = signal<UserResponse | null>(null);

  authenticateUser() {
    this.authenticationService
      .authenticate(this.builderUserRequest(this.usernameControl().value))
      .pipe(takeUntilDestroyed(this.destroyRef))
      .subscribe({
        next: (response: UserResponse) => {
          this.authenticatedUser.set(response);
          this.userSessionManagmentService.setUserId(this.authenticatedUser()?.userId!);
        },
        error: (error) => {
          console.error('Error authenticating user:', error);
        },
      });
  }

  private builderUserRequest(username: string) {
    return { username: username } as UserRequest;
  }
}
