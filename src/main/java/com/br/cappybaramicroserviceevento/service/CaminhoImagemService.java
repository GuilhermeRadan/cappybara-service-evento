package com.br.cappybaramicroserviceevento.service;


import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.br.cappybaramicroserviceevento.model.CaminhoImagem;
import com.br.cappybaramicroserviceevento.model.Evento;
import com.br.cappybaramicroserviceevento.repository.CaminhoImagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class CaminhoImagemService {

    private CaminhoImagemRepository caminhoImagemRepository;

    private BlobServiceClient blobServiceClient;

    private BlobContainerClient blobContainerClient;
    @Autowired
    public CaminhoImagemService(BlobServiceClient blobServiceClient, BlobContainerClient blobContainerClient, CaminhoImagemRepository caminhoImagemRepository){
        this.blobServiceClient = blobServiceClient;
        this.blobContainerClient = blobContainerClient;
        this.caminhoImagemRepository = caminhoImagemRepository;
    }


    public String upload(MultipartFile multipartFile) throws IOException {


        BlobClient blob = blobContainerClient.getBlobClient(multipartFile.getOriginalFilename());
        blob.upload(multipartFile.getInputStream(), multipartFile.getSize(), true);
        String uri = blob.getBlobUrl();



        return "Nome Arquivo " + multipartFile.getOriginalFilename() + " URI " + uri ;

    }

    public String popularBanco(Long id, List<MultipartFile> imagens) throws IOException {
        for (var arquivo: imagens){
            BlobClient blob = blobContainerClient.getBlobClient(arquivo.getOriginalFilename());
            blob.upload(arquivo.getInputStream(), arquivo.getSize(), true);
            String uri = blob.getBlobUrl();

            Evento evento = new Evento();
            evento.setId(id);
            CaminhoImagem caminhoImagem = new CaminhoImagem();
            caminhoImagem.setUrl(uri);
            caminhoImagem.setIdEvento(evento);
            caminhoImagemRepository.save(caminhoImagem);
        }
        return "";
    }

    public String uploadImagens(List<MultipartFile> imagens, Evento idEvento) throws IOException {
        for (var arquivo: imagens){
            BlobClient blob = blobContainerClient.getBlobClient(arquivo.getOriginalFilename());
            blob.upload(arquivo.getInputStream(), arquivo.getSize(), true);
            String uri = blob.getBlobUrl();

            CaminhoImagem caminhoImagem = new CaminhoImagem();
            caminhoImagem.setUrl(uri);
            caminhoImagem.setIdEvento(idEvento);
            caminhoImagemRepository.save(caminhoImagem);
        }
        return "acredito que funcionou kkkkk";
    }


}
