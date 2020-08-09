package ar.edu.davinci.adoptame.controller.mobile;

import ar.edu.davinci.adoptame.DTO.MascotaDTO;
import ar.edu.davinci.adoptame.domain.Mascota;
import ar.edu.davinci.adoptame.service.*;
import ar.edu.davinci.adoptame.utils.UploadFileResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping(path="/mobile") // This means URL's start with /demo (after Application path)
public class MascotaMobileController {

    private static final Logger logger = LoggerFactory.getLogger(MascotaMobileController.class);

    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private MascotaService mascotaService;

    @PostMapping(path="/uploadPet")
    @ResponseBody
    public  MascotaDTO uploadPet(@ModelAttribute  MascotaDTO params) {

        String fileName = fileStorageService.storeFile(params.getImage());

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/mobile/downloadPet/")
                .path(fileName)
                .toUriString();
      //  mascota.setFoto_url(fileDownloadUri);

     // Mascota mascotaRespuesta=  mascotaService.addMascotas(mascota);
      MascotaDTO mascotaRespuestaDTO= new MascotaDTO();
        return   mascotaRespuestaDTO;
    }



    @GetMapping("/downloadPet/{fileName:.+}")
    public ResponseEntity<Resource> downloadPet(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            logger.info("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

}