import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { CookieService } from 'ngx-cookie';

export const languageInterceptor: HttpInterceptorFn = (req, next) => {

    const cookieService = inject(CookieService);

    const language = cookieService.get('language') ?? 'pt';

    const clonedReq = req.clone({
        setHeaders: {
            'Accept-Language': language,
        },
    });

    return next(clonedReq);
}