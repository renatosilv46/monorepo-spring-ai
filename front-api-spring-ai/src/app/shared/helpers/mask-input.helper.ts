import { InputMask } from '../dtos/input-mask.dto';

export default class MaskInputHelper {
  static delegateMask(value: string, mask: InputMask): string {
    switch (mask) {
      case 'currency':
        return this.formatCurrency(value);
      case 'date':
        return this.formatDate(value);
      default:
        return value;
    }
  }

  private static formatCurrency(value: string): string {
    const onlyDigits = value.replace(/\D/g, '');

    if (!onlyDigits) return '';

    const number = parseInt(onlyDigits, 10) / 100;

    return Intl.NumberFormat('en-US', {
      style: 'currency',
      currency: 'USD',
    }).format(number);
  }

  private static formatDate(value: string): string {
    const onlyDigits = value.replace(/\D/g, '').slice(0, 8);

    const digits = onlyDigits.slice(0, 8);

    if (digits.length <= 2) return digits;
    if (digits.length <= 4) return `${digits.slice(0, 2)}/${digits.slice(2)}`;

    return `${digits.slice(0, 2)}/${digits.slice(2, 4)}/${digits.slice(4)}`;
  }
}
