package com.spring.ai.adapters.out.images;

import com.spring.ai.application.ports.out.ImageServicePort;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageServicePort {

    private final OpenAiImageModel imageModel;

    public ImageServiceImpl(OpenAiImageModel openAiImageModel) {
        this.imageModel = openAiImageModel;
    }

    @Override
    public ImageResponse createImage(
            String prompt, String quality,
            Integer quantity, Integer height,
            Integer width) {

       ImagePrompt imagePrompt = new ImagePrompt(prompt,
           OpenAiImageOptions.builder()
               .responseFormat("url")
               .quality(quality)
               .N(quantity)
               .height(height)
               .width(width)
               .build());

       return imageModel.call(imagePrompt);
    }
}
