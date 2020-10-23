package ar.edu.davinci.adoptame.controller.mobile;

import ar.edu.davinci.adoptame.DTO.MascotaDTO;
import ar.edu.davinci.adoptame.DTO.MascotaFilterDTO;
import ar.edu.davinci.adoptame.constantes.Constantes;
import ar.edu.davinci.adoptame.domain.Mascota;
import ar.edu.davinci.adoptame.domain.Usuario;
import ar.edu.davinci.adoptame.exception.NotFoundException;
import ar.edu.davinci.adoptame.exception.ImageUploadException;
import ar.edu.davinci.adoptame.service.*;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
    public  MascotaDTO uploadPet(@ModelAttribute  MascotaDTO params) throws ImageUploadException {


        Map config = new HashMap();
        config.put("cloud_name", "ddetocnzj");
        config.put("api_key", "462997364764234");
        config.put("api_secret", "qfNhbDEptEIZV1kSe70O8IZRIcE");
        Cloudinary  cloudinary = new Cloudinary(config);
        String fileName = fileStorageService.storeFile(params.getImage());
        String basePath=fileStorageService.getFileStorageLocation().toString();
        logger.info("path imagen en servidor "+basePath);
        Map resultado;
        try {
           resultado=  cloudinary.uploader().upload(basePath+"/"+fileName, ObjectUtils.emptyMap());
        } catch (IOException e) {
            e.printStackTrace();
            throw new ImageUploadException();
        }


/*
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/mobile/downloadPet/")
                .path(fileName)
                .toUriString();
 */
        params.setFoto_url(String.valueOf(resultado.get("secure_url")));

      Mascota mascotaRespuesta=  mascotaService.addMascotas(params);

       MascotaDTO masDto= new MascotaDTO(mascotaRespuesta);

        return  masDto  ;

    }


    /**
     * devuelve la imagen de la mascota
     * @param fileName
     * @param request
     * @return
     */

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
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline" )
                .body(resource);
    }


    /**
     * busca las mascotas disponibles para doptar segun los filtros pasados por parametro
     * @param params
     * @return
     */
    @GetMapping("/listaMascotasDisponible")
    public @ResponseBody Iterable<MascotaDTO> mascotasEnAdopcion(MascotaFilterDTO params ) {

        List<Mascota> mascotas=mascotaService.findAllByEstadoAndSexoInAndEdadLessThanEqualAndTamanioIn(Constantes.DISPONIBLE,params.getSexo(),params.getEdad(),params.getTamanio());
        List<MascotaDTO> mascotaDTOS= new ArrayList<>();
        for (Mascota mascota:mascotas) {
            if(calculateDistanceInkms(params.getLatitud(),params.getLongitud(),mascota.getCoordenadas().getLatitud(),mascota.getCoordenadas().getLongitud())<params.getDistancia()){
                MascotaDTO mascotaDTO= new MascotaDTO(mascota);
                mascotaDTOS.add(mascotaDTO);
            }

        }
        return mascotaDTOS;
    }


    /**
     * devuelve las mascotas que el usuario puso en adopcion
     * @param id
     * @return
     */
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

    @PostMapping(path="/estadoMascota")
    @ResponseBody
    public  MascotaDTO cambiarEstado(@RequestBody MascotaDTO params) {


        Mascota mascotaRespuesta=  mascotaService.findById(new Long(params.getId()));
        if(mascotaRespuesta==null){
            throw new NotFoundException();
        }

        mascotaRespuesta.setEstado(params.getEstado());
        mascotaRespuesta= mascotaService.save(mascotaRespuesta);
        MascotaDTO masDto = new MascotaDTO(mascotaRespuesta);
        return  masDto  ;
    }


    /**
     * Calcula la distancia en kilometros entre dos coordenadas
     * la libreria de lucene la calcula en metros asi que la dividimos por MIL para obtener los kms
     * @param lat1
     * @param lon1
     * @param lat2
     * @param lon2
     * @return
     */
    private Double calculateDistanceInkms(Double lat1, Double lon1,Double lat2,Double lon2) {
        double dist = org.apache.lucene.util.SloppyMath.haversinMeters(lat1, lon1, lat2, lon2);
        System.out.println(dist);
        return dist/Constantes.MIL_MTS;

    }

}