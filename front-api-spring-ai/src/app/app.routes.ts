import { Routes } from '@angular/router';
import { InvestmentsPlanComponent } from './pages/investments-plan/investments-plan.component';
import { ImageGeneratorComponent } from './pages/image-generator/image-generator.component';

export const routes: Routes = [
    {
        path: 'investments-plan',
        component: InvestmentsPlanComponent
    },
    {
        path: 'image-generator',
        component: ImageGeneratorComponent
    }
];
