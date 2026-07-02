package com.spring.ai.adapters.out.azure_storage;

import com.azure.storage.blob.*;
import com.azure.storage.blob.sas.BlobSasPermission;
import com.azure.storage.blob.sas.BlobServiceSasSignatureValues;
import com.spring.ai.application.ports.out.AzureStorageServicePort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.time.OffsetDateTime;
import java.util.UUID;

@Service
public class AzureStorageServiceImpl implements AzureStorageServicePort {

    private final BlobContainerClient containerClient;

    public AzureStorageServiceImpl(
            @Value("${azure.storage.connection-string}")
            String connectionString,
            @Value("${azure.storage.container-name}")
            String containerName) {

        BlobServiceClient blobContainerClient =
                new BlobServiceClientBuilder()
                        .connectionString(connectionString)
                        .buildClient();

        this.containerClient = blobContainerClient
                .getBlobContainerClient(containerName);
    }

    @Override
    public String uploadImage(byte[] imageBytes) {

        String imageName = UUID.randomUUID() + ".png";

        BlobClient blobClient = containerClient.getBlobClient(imageName);

        blobClient.upload(
                new ByteArrayInputStream(imageBytes),
                imageBytes.length,
                true);

        return blobClient.getBlobName();
    }

    @Override
    public String getSignedUri(String imageName) {
        BlobClient blobClient = containerClient.getBlobClient(imageName);

        BlobSasPermission permission =
                new BlobSasPermission()
                        .setReadPermission(true);

        OffsetDateTime expiryTime = OffsetDateTime.now().plusMinutes(15);

        BlobServiceSasSignatureValues values =
                new BlobServiceSasSignatureValues(
                        expiryTime,
                        permission);

        String sasToken = blobClient.generateSas(values);

        return blobClient.getBlobUrl() + "?" + sasToken;
    }
}
