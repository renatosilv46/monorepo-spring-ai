import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { ImageGenerateRequestDto, ImageGenerateResponseDto } from '../dtos/image-generate.dto';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ImageService {

  private readonly httpClient = inject(HttpClient);
  private readonly apiHost = environment.SPRING_AI_API_URL;

  getGeneratedImage(imageGenerateRequest: ImageGenerateRequestDto): Observable<ImageGenerateResponseDto> {

    const params = new HttpParams()
    .set('quality', imageGenerateRequest.quality || 'medium')
    .set('quantity', imageGenerateRequest.quantity?.toString() || '1')
    .set('height', imageGenerateRequest.height || '400')
    .set('width', imageGenerateRequest.width || '400');

    return this.httpClient.get<ImageGenerateResponseDto>(`${this.apiHost}/images/create`, { params });
  }
}
