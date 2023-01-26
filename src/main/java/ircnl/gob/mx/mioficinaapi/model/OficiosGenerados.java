package ircnl.gob.mx.mioficinaapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OF_OficiosGenerados")
public class OficiosGenerados {

	@Id
	private String IdOficioGenerado;
	private String NumRegistro;
	private String CadenaRegistro;
	private String IdDepciaGenera;
	private String DepciaGenera;
	private String IdSriaDirigidoA;
	private String SriaDirigidoA;
	private String IdDepciaDirigidoA;
	private String DepciaDirigidoA;
	private String DirigidoA;
	private String UserDirigidoA;
	private String Folio;
	private String NOficioGenerado;
	private String IdDepciaCaptura;
	private String DepciaCaptura;
	private String IdTipoOficio;
	private String TipoOficio;
	private String IdEstatusOficio;
	private String EstatusOficioGenerado;
	private String Asunto;
	private String FechaRegistro;
	private String Remitente;
	private String CuentaUsuario;
	private String UserRemitente;
	private String FechaModificacion;
	private String HoraRegistro;
	private String UltimoUsuario;
	private String FechaRegistroOficio;
	private String FechaOficioGenerado;
	private String TurnadoA;
	private String UserTurnadoA;
	private String ReTurnadoA;
	private String UserReTurnadoA;
	private String IdEmpresa;
	private String IdContacto;
	private String Empresa;
	private String Contacto;
	private String IdGabinete;
	private String Gabinete;
	private String FechaVencOficio;
	private String SolicitadoPor;
	private String IdDepciaPadre;
	private String DepciaPadre;
	private String EstatusRegistro;
	private String UsuarioQueBorro;
	private String FechaEliminacion;
	private String Despedida;
	private String IdOficioRecibido;
	private String NombreOficio;

	public String getIdOficioGenerado() {
		return IdOficioGenerado;
	}

	public void setIdOficioGenerado(String idOficioGenerado) {
		IdOficioGenerado = idOficioGenerado;
	}

	public String getNumRegistro() {
		return NumRegistro;
	}

	public void setNumRegistro(String numRegistro) {
		NumRegistro = numRegistro;
	}

	public String getCadenaRegistro() {
		return CadenaRegistro;
	}

	public void setCadenaRegistro(String cadenaRegistro) {
		CadenaRegistro = cadenaRegistro;
	}

	public String getIdDepciaGenera() {
		return IdDepciaGenera;
	}

	public void setIdDepciaGenera(String idDepciaGenera) {
		IdDepciaGenera = idDepciaGenera;
	}

	public String getDepciaGenera() {
		return DepciaGenera;
	}

	public void setDepciaGenera(String depciaGenera) {
		DepciaGenera = depciaGenera;
	}

	public String getIdSriaDirigidoA() {
		return IdSriaDirigidoA;
	}

	public void setIdSriaDirigidoA(String idSriaDirigidoA) {
		IdSriaDirigidoA = idSriaDirigidoA;
	}

	public String getSriaDirigidoA() {
		return SriaDirigidoA;
	}

	public void setSriaDirigidoA(String sriaDirigidoA) {
		SriaDirigidoA = sriaDirigidoA;
	}

	public String getIdDepciaDirigidoA() {
		return IdDepciaDirigidoA;
	}

	public void setIdDepciaDirigidoA(String idDepciaDirigidoA) {
		IdDepciaDirigidoA = idDepciaDirigidoA;
	}

	public String getDepciaDirigidoA() {
		return DepciaDirigidoA;
	}

	public void setDepciaDirigidoA(String depciaDirigidoA) {
		DepciaDirigidoA = depciaDirigidoA;
	}

	public String getDirigidoA() {
		return DirigidoA;
	}

	public void setDirigidoA(String dirigidoA) {
		DirigidoA = dirigidoA;
	}

	public String getUserDirigidoA() {
		return UserDirigidoA;
	}

	public void setUserDirigidoA(String userDirigidoA) {
		UserDirigidoA = userDirigidoA;
	}

	public String getFolio() {
		return Folio;
	}

	public void setFolio(String folio) {
		Folio = folio;
	}

	public String getNOficioGenerado() {
		return NOficioGenerado;
	}

	public void setNOficioGenerado(String nOficioGenerado) {
		NOficioGenerado = nOficioGenerado;
	}

	public String getIdDepciaCaptura() {
		return IdDepciaCaptura;
	}

	public void setIdDepciaCaptura(String idDepciaCaptura) {
		IdDepciaCaptura = idDepciaCaptura;
	}

	public String getDepciaCaptura() {
		return DepciaCaptura;
	}

	public void setDepciaCaptura(String depciaCaptura) {
		DepciaCaptura = depciaCaptura;
	}

	public String getIdTipoOficio() {
		return IdTipoOficio;
	}

	public void setIdTipoOficio(String idTipoOficio) {
		IdTipoOficio = idTipoOficio;
	}

	public String getTipoOficio() {
		return TipoOficio;
	}

	public void setTipoOficio(String tipoOficio) {
		TipoOficio = tipoOficio;
	}

	public String getIdEstatusOficio() {
		return IdEstatusOficio;
	}

	public void setIdEstatusOficio(String idEstatusOficio) {
		IdEstatusOficio = idEstatusOficio;
	}

	public String getEstatusOficioGenerado() {
		return EstatusOficioGenerado;
	}

	public void setEstatusOficioGenerado(String estatusOficioGenerado) {
		EstatusOficioGenerado = estatusOficioGenerado;
	}

	public String getAsunto() {
		return Asunto;
	}

	public void setAsunto(String asunto) {
		Asunto = asunto;
	}

	public String getFechaRegistro() {
		return FechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}

	public String getRemitente() {
		return Remitente;
	}

	public void setRemitente(String remitente) {
		Remitente = remitente;
	}

	public String getCuentaUsuario() {
		return CuentaUsuario;
	}

	public void setCuentaUsuario(String cuentaUsuario) {
		CuentaUsuario = cuentaUsuario;
	}

	public String getUserRemitente() {
		return UserRemitente;
	}

	public void setUserRemitente(String userRemitente) {
		UserRemitente = userRemitente;
	}

	public String getFechaModificacion() {
		return FechaModificacion;
	}

	public void setFechaModificacion(String fechaModificacion) {
		FechaModificacion = fechaModificacion;
	}

	public String getHoraRegistro() {
		return HoraRegistro;
	}

	public void setHoraRegistro(String horaRegistro) {
		HoraRegistro = horaRegistro;
	}

	public String getUltimoUsuario() {
		return UltimoUsuario;
	}

	public void setUltimoUsuario(String ultimoUsuario) {
		UltimoUsuario = ultimoUsuario;
	}

	public String getFechaRegistroOficio() {
		return FechaRegistroOficio;
	}

	public void setFechaRegistroOficio(String fechaRegistroOficio) {
		FechaRegistroOficio = fechaRegistroOficio;
	}

	public String getFechaOficioGenerado() {
		return FechaOficioGenerado;
	}

	public void setFechaOficioGenerado(String fechaOficioGenerado) {
		FechaOficioGenerado = fechaOficioGenerado;
	}

	public String getTurnadoA() {
		return TurnadoA;
	}

	public void setTurnadoA(String turnadoA) {
		TurnadoA = turnadoA;
	}

	public String getUserTurnadoA() {
		return UserTurnadoA;
	}

	public void setUserTurnadoA(String userTurnadoA) {
		UserTurnadoA = userTurnadoA;
	}

	public String getReTurnadoA() {
		return ReTurnadoA;
	}

	public void setReTurnadoA(String reTurnadoA) {
		ReTurnadoA = reTurnadoA;
	}

	public String getUserReTurnadoA() {
		return UserReTurnadoA;
	}

	public void setUserReTurnadoA(String userReTurnadoA) {
		UserReTurnadoA = userReTurnadoA;
	}

	public String getIdEmpresa() {
		return IdEmpresa;
	}

	public void setIdEmpresa(String idEmpresa) {
		IdEmpresa = idEmpresa;
	}

	public String getIdContacto() {
		return IdContacto;
	}

	public void setIdContacto(String idContacto) {
		IdContacto = idContacto;
	}

	public String getEmpresa() {
		return Empresa;
	}

	public void setEmpresa(String empresa) {
		Empresa = empresa;
	}

	public String getContacto() {
		return Contacto;
	}

	public void setContacto(String contacto) {
		Contacto = contacto;
	}

	public String getIdGabinete() {
		return IdGabinete;
	}

	public void setIdGabinete(String idGabinete) {
		IdGabinete = idGabinete;
	}

	public String getGabinete() {
		return Gabinete;
	}

	public void setGabinete(String gabinete) {
		Gabinete = gabinete;
	}

	public String getFechaVencOficio() {
		return FechaVencOficio;
	}

	public void setFechaVencOficio(String fechaVencOficio) {
		FechaVencOficio = fechaVencOficio;
	}

	public String getSolicitadoPor() {
		return SolicitadoPor;
	}

	public void setSolicitadoPor(String solicitadoPor) {
		SolicitadoPor = solicitadoPor;
	}

	public String getIdDepciaPadre() {
		return IdDepciaPadre;
	}

	public void setIdDepciaPadre(String idDepciaPadre) {
		IdDepciaPadre = idDepciaPadre;
	}

	public String getDepciaPadre() {
		return DepciaPadre;
	}

	public void setDepciaPadre(String depciaPadre) {
		DepciaPadre = depciaPadre;
	}

	public String getEstatusRegistro() {
		return EstatusRegistro;
	}

	public void setEstatusRegistro(String estatusRegistro) {
		EstatusRegistro = estatusRegistro;
	}

	public String getUsuarioQueBorro() {
		return UsuarioQueBorro;
	}

	public void setUsuarioQueBorro(String usuarioQueBorro) {
		UsuarioQueBorro = usuarioQueBorro;
	}

	public String getFechaEliminacion() {
		return FechaEliminacion;
	}

	public void setFechaEliminacion(String fechaEliminacion) {
		FechaEliminacion = fechaEliminacion;
	}

	public String getDespedida() {
		return Despedida;
	}

	public void setDespedida(String despedida) {
		Despedida = despedida;
	}

	public String getIdOficioRecibido() {
		return IdOficioRecibido;
	}

	public void setIdOficioRecibido(String idOficioRecibido) {
		IdOficioRecibido = idOficioRecibido;
	}

	public String getNombreOficio() {
		return NombreOficio;
	}

	public void setNombreOficio(String nombreOficio) {
		NombreOficio = nombreOficio;
	}

}
