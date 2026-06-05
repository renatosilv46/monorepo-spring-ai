import { Component, forwardRef, input } from '@angular/core';
import { ControlValueAccessor, NG_VALUE_ACCESSOR, ReactiveFormsModule } from '@angular/forms';

export type InputMask = 'currency' | 'date' | 'none';

@Component({
  selector: 'app-input',
  standalone: true,
  imports: [ReactiveFormsModule],
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => InputComponent),
      multi: true
    }
  ],
  templateUrl: './input.component.html',
  styleUrl: './input.component.scss'
})
export class InputComponent implements ControlValueAccessor {

  readonly labelInput = input<string>('');
  readonly placeHolderInput = input<string>('');
  readonly typeInput = input<string>('text');
  readonly maskInput = input<InputMask>('none');
  readonly maxLengthInput = input<number | null>(null);

  value: string = '';
  isDisabled: boolean = false;

  onChange: (value: string) => void = () => {};
  onTouched: () => void = () => {};
  
 
  writeValue(value: string): void {

    if(value === null || value === '') {
      this.value = '';
      return;
    }

    this.value = value ?? '';
  }

  registerOnChange(fn: (value: string) => void): void {
    this.onChange = fn;
  }

  registerOnTouched(fn: () => void): void {
    this.onTouched = fn;
  }

  setDisabledState?(isDisabled: boolean): void {
    this.isDisabled = isDisabled;
  }

  onInput(event: Event): void {
    const inputElement = event.target as HTMLInputElement;
    const inputValue = inputElement.value;

    const valueFormatted = this.delegateMask(inputValue);

    this.value = valueFormatted;
    this.onChange(valueFormatted);
  }

  delegateMask(value: string): string {

    switch (this.maskInput()) {
      case 'currency':
        return this.formatCurrency(value);
      case 'date':
        return this.formatDate(value);
      default:
        return value;
    }
  }

  private formatCurrency(value: string): string {

    const onlyDigits = value.replace(/\D/g, '');

    if(!onlyDigits) return '';

    const number = parseInt(onlyDigits, 10) / 100;

    return Intl.NumberFormat('en-US', {
      style: 'currency',
      currency: 'USD'
    }).format(number);
  }

  private formatDate(value: string): string {

    const onlyDigits = value.replace(/\D/g, '').slice(0, 8);

    const digits = onlyDigits.slice(0, 8);

    if(digits.length <= 2) return digits;
    if (digits.length <= 4) return `${digits.slice(0, 2)}/${digits.slice(2)}`;

    return `${digits.slice(0, 2)}/${digits.slice(2, 4)}/${digits.slice(4)}`;
  }

}
