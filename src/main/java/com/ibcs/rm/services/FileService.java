package com.ibcs.rm.services;

import com.ibcs.rm.domain.model.ImageDetails;
import com.ibcs.rm.domain.repository.ImageDetailsRepository;
import com.ibcs.rm.pojo.response.FileUploadResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
@AllArgsConstructor
public class FileService {
    private final FileStorageService fileStorageService;
    private final ImageDetailsRepository imageDetailsRepository;

    public ResponseEntity<FileUploadResponse> upload(MultipartFile file) {
        /*Start upload image*/
        String fileName = null;
        String fileDownloadUri = null;

        if (!file.isEmpty()) {
            fileName = fileStorageService.storeFile(file, file.getOriginalFilename());
            fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/file/download/")
                    .path(fileName)
                    .toUriString();
        } else {
            System.err.println("File Not found");
        }

        ImageDetails imageDetails = new ImageDetails();
        imageDetails.setName(fileName);
        imageDetails.setType(file.getContentType());
        imageDetails.setImageUrl(fileDownloadUri);
        /*End upload image*/
        imageDetailsRepository.save(imageDetails);
        return new ResponseEntity(new FileUploadResponse(fileName, file.getContentType(), fileDownloadUri), HttpStatus.OK);
    }

}
