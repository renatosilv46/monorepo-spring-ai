import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {InvesmentsPlanRequestDto, InvesmentsPlanResponseDto } from '../dtos/investments-plan.dto';

@Injectable({
  providedIn: 'root'
})
export class InvestmentsService {

  constructor(private readonly http: HttpClient) { 

  }

  getInvestmentPlan(request: InvesmentsPlanRequestDto): Observable<InvesmentsPlanResponseDto> {

    const httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json'
    });

    return this.http.get<InvesmentsPlanResponseDto>(
      `http://localhost:8080/api/v1/investments?profile=${request.profile}&value=${request.value}&period=${request.period}`, { headers: httpHeaders });
  }
}
