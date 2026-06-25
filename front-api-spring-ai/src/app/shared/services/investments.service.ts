import { HttpClient, HttpParams } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { InvestmentsPlanRequestDto, InvestmentsPlanResponseDto } from '../dtos/investments-plan.dto';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class InvestmentsService {
  
  private readonly httpClient = inject(HttpClient);
  private readonly hostApi = environment.SPRING_AI_API_URL;

  getInvestmentPlan(request: InvestmentsPlanRequestDto): Observable<InvestmentsPlanResponseDto> {
    
    const params = new HttpParams()
    .set('profile', request.profile)
    .set('value', request.value)
    .set('period', request.period);

    return this.httpClient.get<InvestmentsPlanResponseDto>(`${this.hostApi}/investments`, { params });
  }
}
