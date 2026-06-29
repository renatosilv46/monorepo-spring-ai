import { Component, input, output } from '@angular/core';
import { TranslatePipe } from '@ngx-translate/core';

@Component({
  selector: 'app-button-primary',
  standalone: true,
  imports: [TranslatePipe],
  templateUrl: './button-primary.component.html',
  styleUrl: './button-primary.component.scss'
})
export class ButtonPrimaryComponent {

  onClick = output<void>();
  titleButton = input<string>();

  emitEventClick() {
   this.onClick.emit();
  }
}
