package com._coder.bourse.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

public class ImageUtil {

    public static String saveImage(MultipartFile imageFile,String imageFolder) throws IOException {

        Path filePath;
        String thePath;

        // get a base path for a image storage
        Path basePath = Paths.get(imageFolder);

        // generate a unique file name
        String uniqueFileName = UUID.randomUUID().toString() + "." + getFileExtension(imageFile);

        try(InputStream inputStream = imageFile.getInputStream()){
            // Create the file path
            filePath = basePath.resolve(uniqueFileName);

            // Save the image file
            Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);

        }catch (IOException exception){
            throw new IOException("error saving upload file : "+uniqueFileName,exception);
        }

        // get a file path
        Path path = Paths.get(basePath.toString(),uniqueFileName);
        thePath = path.toString();

        return thePath;
    }

    private static String getFileExtension(MultipartFile imageFile) {
        String contentType = imageFile.getContentType();
        String extension = "";
        if (contentType != null) {
            extension = contentType.split("/")[1];
        }
        return extension;
    }

    public static void deleteFile(String imagePath) throws IOException {
        Path path = Paths.get(imagePath);
        if(Files.exists(path)){
            Files.delete(path);
        }else {
            throw new IOException(" Image not found for deleting");
        }

    }


    public static void deleteImageFile(String imagePath) throws IOException {

        Path path = Paths.get(imagePath);
        if(Files.exists(path)){
            Files.delete(path);
        }else {
            throw new IOException(" Image not found");
        }

    }
}
