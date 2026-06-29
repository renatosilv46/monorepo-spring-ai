import { Component, forwardRef, input, signal } from '@angular/core';
import { ControlValueAccessor, NG_VALUE_ACCESSOR } from '@angular/forms';
import { InputMask } from '../../dtos/input-mask.dto';
import MaskInputHelper from '../../helpers/mask-input.helper';

@Component({
  selector: 'app-input',
  standalone: true,
  providers: [
    {
      provide: NG_VALUE_ACCESSOR,
      useExisting: forwardRef(() => InputComponent),
      multi: true,
    },
  ],
  templateUrl: './input.component.html',
  styleUrl: './input.component.scss',
})
export class InputComponent implements ControlValueAccessor {
  readonly labelInput = input<string>('');
  readonly placeHolderInput = input<string>('');
  readonly typeInput = input<string>('text');
  readonly maskInput = input<InputMask>('none');
  readonly maxLengthInput = input<number | null>(null);

  value = signal('');
  isDisabled = signal(false);

  onChange: (value: string) => void = () => {};
  onTouched: () => void = () => {};

  writeValue(value: string): void {
    if (value === null || value === '') {
      this.value.set('');
      return;
    }

    this.value.set(value ?? '');
  }

  registerOnChange(fn: (value: string) => void): void {
    this.onChange = fn;
  }

  registerOnTouched(fn: () => void): void {
    this.onTouched = fn;
  }

  setDisabledState?(isDisabled: boolean): void {
    this.isDisabled.set(isDisabled);
  }

  onInput(event: Event): void {
    const inputElement = event.target as HTMLInputElement;
    const inputValue = inputElement.value;

    const valueFormatted = MaskInputHelper.delegateMask(inputValue, this.maskInput());

    this.value.set(valueFormatted);
    this.onChange(valueFormatted);
  }
}
