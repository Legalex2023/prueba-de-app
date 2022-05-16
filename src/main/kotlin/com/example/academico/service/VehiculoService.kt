import com.example.academico.repository.VehiculoRepository
import jdk.internal.org.jline.terminal.impl.ExecPty
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus

import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class VehiculoService {
    @Autowired
    lateinit var vehiculoRepository: VehiculoRepository
    fun list() : List<Vehiculo> {
        return vehiculoRepository.findAll()
    }

    //GUARDAR VALIDADO REFERENCIA DE TABLA
    fun save (vehiculo: Vehiculo):Vehiculo{
        try {
            vehiculoRepository.findById(vehiculo.id) ?: throw Exception("El dia no existe")
            return vehiculoRepository.save(vehiculo)

        }
        catch(ex : Exception){
            //VALIDAR TEXTO
            vehiculo.dias?.takeIf{
                it.trim().isNotEmpty()
            }
                ?:throw Exception("Dias no debe ser vasio")
            throw ResponseStatusException(HttpStatus.NOT_FOUND, ex.message, ex)
        }

    }



    fun update ( vehiculo: Vehiculo):Vehiculo{
        try {
            vehiculoRepository.findById(vehiculo.id)
                ?:throw Exception ("El id ${vehiculo.id} la tabla Vehiculo no existe")
            return vehiculoRepository.save(vehiculo)
        }

        catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

}