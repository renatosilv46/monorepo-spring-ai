import { effect, inject, Injectable, signal } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { CookieService } from 'ngx-cookie';

@Injectable({
  providedIn: 'root',
})
export class LanguageService {
  private translate = inject(TranslateService);
  private cookie = inject(CookieService);
  private language = signal('en');

  constructor() {
    this.translate.addLangs(['en', 'pt']);
    this.changeLanguage(this.language());
  }

  changeLanguage(language: string): void {
    this.language.set(language);
    this.cookie.put('language', language);
    this.translate.use(language);
  }

  get currentLanguage(): string {
    return this.language();
  }
}
