export interface ImageGenerateRequestDto {
  prompt: string;
  quantity: number;
  quality: string;
  height: number;
  width: number;
}

export interface ImageGenerateResponseDto {
  signedImageUri: string;
}
