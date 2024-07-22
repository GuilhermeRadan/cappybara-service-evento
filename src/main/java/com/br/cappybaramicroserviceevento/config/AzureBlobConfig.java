package com.br.cappybaramicroserviceevento.config;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AzureBlobConfig {
    @Value("${azure.storage.container-name}")
    private String nomeConteiner;

    @Value("${azure.storage.connection-string}")
    private String cadeiaConexao;

    @Bean
    public BlobServiceClient getBlobServiceClient (){
        BlobServiceClient blobServiceClient  = new BlobServiceClientBuilder()
                .connectionString(cadeiaConexao).buildClient();
        return blobServiceClient;
    }

    @Bean
    public BlobContainerClient getBlobContainerClient(){
        BlobContainerClient containerClient = getBlobServiceClient().getBlobContainerClient(nomeConteiner);
        return containerClient;
    }
}
