import javax.persistence.*

@Entity
@Table(name="nombre_tabla")
class Vehiculo{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable=false)
    var id:Long? = null
    var fechas: Float? = null
    var dias: String? = null

}


