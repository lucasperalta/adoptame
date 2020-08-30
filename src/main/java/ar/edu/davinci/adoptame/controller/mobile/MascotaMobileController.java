package ar.edu.davinci.adoptame.controller.mobile;

import ar.edu.davinci.adoptame.DTO.MascotaDTO;
import ar.edu.davinci.adoptame.DTO.UsuarioDTO;
import ar.edu.davinci.adoptame.domain.Mascota;
import ar.edu.davinci.adoptame.domain.Usuario;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="/mobile")
public class MascotaMobileController {

    private static final Logger logger = LoggerFactory.getLogger(MascotaMobileController.class);

    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private UsuarioService usuarioService;

    /**
     * servicio para hacer upload de mascotas
     * recibe los datos de la mascota y una imagen  MultipartFile image;
     * con la foto de la mascota
     * la guarda en bbdd y devuelve los datos de la mascota
     * @param params
     * @return
     */
    @PostMapping(path="/uploadPet")
    @ResponseBody
    public  MascotaDTO uploadPet(@ModelAttribute  MascotaDTO params) {

        String fileName = fileStorageService.storeFile(params.getImage());

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/mobile/downloadPet/")
                .path(fileName)
                .toUriString();
        params.setFoto_url(fileDownloadUri);

      Mascota mascotaRespuesta=  mascotaService.addMascotas(params);

       MascotaDTO masDto= new MascotaDTO(mascotaRespuesta);

        return  masDto  ;
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
            logger.info("No se puede determinar el tipo de archivo.");
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


    @GetMapping("/listaMascotasDisponible")
    public @ResponseBody Iterable<MascotaDTO> mascotasEnAdopcion(MascotaDTO params ) {

        Mascota mascotaParam = new Mascota();
        mascotaParam.setEstado("DISPONIBLE");
        mascotaParam.setSexo(params.getSexo());
        mascotaParam.setTamanio(params.getTamanio());
        mascotaParam.setEdad(params.getEdad());


        List<Mascota> mascotas=mascotaService.findAllByEstadoAndSexoAndTamanioAndEdad(mascotaParam);
        List<MascotaDTO> mascotaDTOS= new ArrayList<>();
        for (Mascota mascota:mascotas) {
            MascotaDTO mascotaDTO= new MascotaDTO(mascota);
            mascotaDTOS.add(mascotaDTO);
        }
        return mascotaDTOS;
    }

    @GetMapping("/mascotasUsuario/{id}")
    public @ResponseBody Iterable<MascotaDTO> mascotasPropiasEnAdopcion(@PathVariable Integer id ) {

      Usuario usuario=  usuarioService.buscarUsuarioByID(id);

        List<Mascota> mascotas=mascotaService.findAllByRescatista(usuario);
        List<MascotaDTO> mascotaDTOS= new ArrayList<>();
        for (Mascota mascota:mascotas) {
            MascotaDTO mascotaDTO= new MascotaDTO(mascota);
            mascotaDTOS.add(mascotaDTO);
        }
        return mascotaDTOS;
    }

}