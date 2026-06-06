import { Component, OnDestroy } from '@angular/core';
import { InputComponent } from '../../shared/components/input/input.component';
import { FormControl, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Subject, takeUntil } from 'rxjs';
import { ImageService } from '../../shared/services/image.service';
import { ImageGenerateRequestDto, ImageGenerateResponseDto } from '../../shared/dtos/image-generate.dto';

@Component({
  selector: 'app-image-generator',
  standalone: true,
  imports: [InputComponent, ReactiveFormsModule, CommonModule],
  templateUrl: './image-generator.component.html',
  styleUrl: './image-generator.component.scss'
})
export class ImageGeneratorComponent implements OnDestroy{
  protected imageGenerateResponse!: ImageGenerateResponseDto;
  private readonly destroySubscribe$ = new Subject<void>();
  prompt = new FormControl('', [Validators.required]);
  quantity = new FormControl('');
  quality = new FormControl('');
  width = new FormControl('');
  height = new FormControl('');

  constructor(private readonly imageService: ImageService) {}

  ngOnDestroy(): void {
    this.destroySubscribe$.next();
    this.destroySubscribe$.complete();
  }

  onGenerateImage(): void {

    const requestImageGenerate: ImageGenerateRequestDto = {
      prompt: String(this.prompt.value),
      quantity: Number(this.quantity.value),
      quality: String(this.quality.value),
      width: Number(this.width.value),
      height: Number(this.height.value)
    };

    this.imageService.getGeneratedImage(requestImageGenerate)
    .pipe(takeUntil(this.destroySubscribe$))
    .subscribe((response) => {
      this.imageGenerateResponse = response;
    });
  }
}
