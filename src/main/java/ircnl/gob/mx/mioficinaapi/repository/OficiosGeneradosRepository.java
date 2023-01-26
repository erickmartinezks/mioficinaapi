package ircnl.gob.mx.mioficinaapi.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ircnl.gob.mx.mioficinaapi.model.OficiosGenerados;

@Repository
public interface OficiosGeneradosRepository extends JpaRepository<OficiosGenerados, Serializable>{

	// @Query(value ="CALL OFPA_OficiosGenerados(:campo1)", nativeQuery = true)
	@Query(value ="EXEC OFSPA_OficiosGenerados "
			+ ":cuentaUsuario, :asunto, :idSriaProc, :sriaProc, :idDepciaProc, :depciaProc, :idTipoOf, :tipoOf, "
			+ ":idEstatusOf, :estatusOf, :idDepciaAsig, :depciaAsig, :fechaOficio, :dirigidoA, :despedida, "
			+ ":idOficioRecibido, :nombreOficio, :telefonoOficioG, :ubicacionOficioG, :parrafo, :puestoDirigidoA, "
			+ ":puestoRemitente, :idSecretariaRemitente", nativeQuery = true)
	public String callOFSPA_OficiosGenerados(
			String cuentaUsuario,
			String asunto,
			String idSriaProc,
			String sriaProc,
			String idDepciaProc,
			String depciaProc,
			int idTipoOf,
			String tipoOf,
			int idEstatusOf,
			String estatusOf,
			String idDepciaAsig,
			String depciaAsig,
			String fechaOficio,
			String dirigidoA,
			String despedida,
			int idOficioRecibido,
			String nombreOficio,
			String telefonoOficioG,
			String ubicacionOficioG,
			String parrafo,
			String puestoDirigidoA,
			String puestoRemitente,
			String idSecretariaRemitente
			);
	// OFPA_OficiosGenerados
	
	
	
}
