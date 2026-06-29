import { Component, DestroyRef, inject, signal } from '@angular/core';
import { InputComponent } from '../../shared/components/input/input.component';
import { FormControl, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ImageService } from '../../shared/services/image.service';
import { ImageGenerateRequestDto, ImageGenerateResponseDto } from '../../shared/dtos/image-generate.dto';
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';
import { TranslatePipe } from '@ngx-translate/core';
import { ButtonPrimaryComponent } from '../../shared/components/button-primary/button-primary.component';
import { LanguageToggleComponent } from '../../shared/components/language-toggle/language-toggle.component';

@Component({
  selector: 'app-image-generator',
  standalone: true,
  imports: [
    InputComponent,
    ReactiveFormsModule,
    CommonModule,
    TranslatePipe,
    ButtonPrimaryComponent,
    LanguageToggleComponent,
  ],
  templateUrl: './image-generator.component.html',
  styleUrl: './image-generator.component.scss'
})
export class ImageGeneratorComponent {

  private readonly destroyRef = inject(DestroyRef);
  private readonly imageService = inject(ImageService);
  protected imageGenerateResponse = signal<ImageGenerateResponseDto | null>(null);

  prompt = new FormControl<string>('', {
    nonNullable: true,
    validators: [Validators.required]
  });

  quantity = new FormControl<string>('');
  quality = new FormControl<string>('');
  width = new FormControl<string>('');
  height = new FormControl<string>('');

  protected clickGenerateImage() {
    this.onGenerateImage();
  }

  private onGenerateImage(): void {

    const requestImageGenerate: ImageGenerateRequestDto = {
      prompt: this.prompt.value,
      quantity: Number(this.quantity.value),
      quality: String(this.quality.value),
      width: Number(this.width.value),
      height: Number(this.height.value)
    };

    this.imageService.getGeneratedImage(requestImageGenerate)
    .pipe(takeUntilDestroyed(this.destroyRef))
    .subscribe((response) => {
      this.imageGenerateResponse.set(response);
    });
  }
}
