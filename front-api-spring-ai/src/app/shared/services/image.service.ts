import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ImageGenerateRequestDto, ImageGenerateResponseDto } from '../dtos/image-generate.dto';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ImageService {

  constructor(private readonly http: HttpClient) { }

  getGeneratedImage(imageGenerateRequest: ImageGenerateRequestDto): Observable<ImageGenerateResponseDto> {

    const httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json'
    });

    const quality = imageGenerateRequest.quality || 'medium';
    const quantity = imageGenerateRequest.quantity || 1;
    const height = imageGenerateRequest.height || '400';
    const width = imageGenerateRequest.width || '400';

    return this.http.get<ImageGenerateResponseDto>(
      `http://localhost:8080/api/v1/images/create?prompt=${imageGenerateRequest.prompt}&quantity=${quantity}&quality=${quality}&height=${height}&width=${width}`, { headers: httpHeaders });
  }
}
