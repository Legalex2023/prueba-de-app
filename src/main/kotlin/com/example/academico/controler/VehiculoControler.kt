
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/ Vehiculo´s")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH])
class VehiculoController {

    @Autowired
    lateinit var VehiculoService: VehiculoService

    @GetMapping
    fun list ():List <Vehiculo>{
        return VehiculoService.list()
    }

    @PostMapping
    fun save(@RequestBody vehiculo: Vehiculo):Vehiculo{
        return VehiculoService.save(vehiculo)
    }
}