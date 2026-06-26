import { Component, DestroyRef, inject, signal } from '@angular/core';
import { InputComponent } from '../../shared/components/input/input.component';
import { FormControl, ReactiveFormsModule, Validators } from '@angular/forms';
import { InvestmentsService } from '../../shared/services/investments.service';
import { InvestmentsPlanRequestDto, InvestmentsPlanResponseDto } from '../../shared/dtos/investments-plan.dto';
import { CommonModule } from '@angular/common';
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';
import { TranslatePipe } from '@ngx-translate/core';
import { LanguageToggleComponent } from '../../shared/components/language-toggle/language-toggle.component';

@Component({
  selector: 'app-investments-plan',
  standalone: true,
  imports: [InputComponent, ReactiveFormsModule, CommonModule, TranslatePipe, LanguageToggleComponent],
  templateUrl: './investments-plan.component.html',
  styleUrl: './investments-plan.component.scss'
})
export class InvestmentsPlanComponent {
  private readonly investmentsService = inject(InvestmentsService);

  private readonly destroyRef = inject(DestroyRef);
  protected invesmentsPlanResponse = signal<InvestmentsPlanResponseDto | null>(null);

  profileControl = new FormControl<string>('', {
    nonNullable: true,
    validators: [Validators.required]
  });

  amountControl = new FormControl<string>('', {
    nonNullable: true,
    validators: [Validators.required, Validators.min(0)]
  });

  durationControl = new FormControl<string>('', {
    nonNullable: true,
    validators: [Validators.required, Validators.min(1), Validators.maxLength(10)]
  });
  
  onGetInvestmentPlan(): void {

    const requestInvesmentsPlan: InvestmentsPlanRequestDto = {
      profile: this.profileControl.value,
      value : this.amountControl.value,
      period: this.durationControl.value
    };

    this.investmentsService.getInvestmentPlan(requestInvesmentsPlan)
    .pipe(takeUntilDestroyed(this.destroyRef))
    .subscribe({
    
      next: (response: InvestmentsPlanResponseDto) => {
        this.invesmentsPlanResponse.set(response);
      }, 

      error: (error: any) => {
        console.error('Error fetching investment plan:', error);
      }
    });
  }
}
