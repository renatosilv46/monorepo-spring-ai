import { Component, inject } from '@angular/core';
import { LanguageService } from '../../services/language.service';

@Component({
  selector: 'app-language-toggle',
  standalone: true,
  imports: [],
  templateUrl: './language-toggle.component.html',
  styleUrl: './language-toggle.component.scss',
})
export class LanguageToggleComponent {
  protected readonly languageService = inject(LanguageService);

  toggleLanguage(): void {
    const current = this.languageService.currentLanguage;
    this.languageService.changeLanguage(current === 'en' ? 'pt' : 'en');
  }
}
