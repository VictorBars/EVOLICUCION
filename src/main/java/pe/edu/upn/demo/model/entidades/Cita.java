package pe.edu.upn.demo.model.entidades;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;


@Entity
public class Cita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_cita", length = 4, nullable = false)
	private Integer codigo;
	
	@Column(name = "fecha_cita", length = 30, nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	@Future(message = "Separa con un dia de anticipación.")
	private LocalDate fecha;
	
	@Column(name = "est_cita", length = 30, nullable = false)
	private String est_cita = "no";
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_servicio")
	private Servicio Servicio;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_u")
	private  Usuario Usuario;
	
	
	public Cita() {	
		
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getEst_cita() {
		return est_cita;
	}

	public void setEst_cita(String est_cita) {
		this.est_cita = est_cita;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Servicio getServicio() {
		return Servicio;
	}

	public void setServicio(Servicio servicio) {
		Servicio = servicio;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}

	



	
	


	

	
	


	






	
	
	
}
