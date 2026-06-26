import { effect, inject, Injectable, signal } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';

@Injectable({
  providedIn: 'root'
})
export class LanguageService {

  private translate = inject(TranslateService);
  private language = signal('en');

  constructor() {
    this.translate.use('en');
    effect(() => {
      this.translate.use(this.language());
    })
  }

  changeLanguage(language: string): void {
    this.language.set(language);
  }
}
