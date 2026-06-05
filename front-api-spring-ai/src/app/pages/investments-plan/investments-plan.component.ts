import { Component, OnInit } from '@angular/core';
import { InputComponent } from '../../shared/components/input/input.component';
import { FormControl, ReactiveFormsModule, Validators } from '@angular/forms';
import { InvestmentsService } from '../../shared/services/investments.service';
import { Subject, takeUntil } from 'rxjs';
import { InvesmentsPlanRequestDto, InvesmentsPlanResponseDto } from '../../shared/dtos/investments-plan.dto';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-investments-plan',
  standalone: true,
  imports: [InputComponent, ReactiveFormsModule, CommonModule],
  templateUrl: './investments-plan.component.html',
  styleUrl: './investments-plan.component.scss'
})
export class InvestmentsPlanComponent implements OnInit {
  private readonly destroySubscribe$ = new Subject<void>();
  protected invesmentsPlanResponse!: InvesmentsPlanResponseDto;
  profileControl = new FormControl('', [Validators.required]);
  amountControl = new FormControl('', [Validators.required, Validators.min(0)]);
  durationControl = new FormControl('', [Validators.required, Validators.min(1), Validators.maxLength(10)]);

  constructor(private readonly investmentsService: InvestmentsService) {}
  
  ngOnInit(): void { }

  onGetInvestmentPlan(): void {

    const requestInvesmentsPlan: InvesmentsPlanRequestDto = {
      profile: String(this.profileControl.value),
      value : String(this.amountControl.value),
      period: String(this.durationControl.value)
    };

    this.investmentsService.getInvestmentPlan(requestInvesmentsPlan)
    .pipe(takeUntil(this.destroySubscribe$))
    .subscribe((response) => {
      this.invesmentsPlanResponse = response;
    });
  }


}
