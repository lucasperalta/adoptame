package ar.edu.davinci.adoptame.service;

import ar.edu.davinci.adoptame.utils.FileStorageException;
import ar.edu.davinci.adoptame.utils.FileStorageProperties;
import ar.edu.davinci.adoptame.utils.MyFileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * clase que se encargar de manejar el almacenamiento de archivos
 */
@Service
public class FileStorageService {


    private final Path fileStorageLocation;

    /**
     * crea el directorio donde se van a almacenar las imagenes
     * @param fileStorageProperties
     */
    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("No se puede crear el directorio donde se subira el archivo.", ex);
        }
    }

    /**
     * guarda el archivo
     * @param file
     * @return
     */
    public String storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Path invalido " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("No se puede guardar el archivo " + fileName + ". Pruebe nuevamente!", ex);
        }
    }

    /**
     * lee el archivo almacenado y lo carga como un resource
     * @param fileName
     * @return
     */
    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("Archivo no encontrado " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("Archivo no encontrado " + fileName, ex);
        }
    }

    public Path getFileStorageLocation() {
        return fileStorageLocation;
    }
}
