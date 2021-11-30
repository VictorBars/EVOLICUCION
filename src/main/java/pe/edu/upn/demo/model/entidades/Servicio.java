package pe.edu.upn.demo.model.entidades;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Servicio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_servicio", length = 4, nullable = false)
	private Integer codigo;
	
	@Column(name = "nom_servicio", length = 30, nullable = false)
	private String nombre;
	
	@Column(name = "descripcion", length = 200, nullable = false)
	private String descripcion;
	
	@Column(name = "banner", length = 500, nullable = false)
	private String banner;
	
	@GeneratedValue(strategy =  GenerationType.AUTO)
	@Column(name = "pre_servicio", nullable = false)
	private double precio;

	@Column(name ="duracion_servicio", length = 30 , nullable = false)
	private String duracion;
	
	@Column(name = "aforo", length = 30, nullable = false)
	private int aforo = 5;
	
	@OneToMany(mappedBy = "Servicio", fetch = FetchType.LAZY)
	private List<Cita> listacita;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_hora")
	private Horario Horario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_pe")
	private Trabajador Trabajador;
	
	

	public Servicio(){
	 
		this.listacita = new ArrayList<Cita>();

	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public List<Cita> getListacita() {
		return listacita;
	}

	public void setListacita(List<Cita> listacita) {
		this.listacita = listacita;
	}

	public float getAforo() {
		return aforo;
	}

	public void setAforo(int aforo) {
		this.aforo = aforo;
	}

	public Horario getHorario() {
		return Horario;
	}

	public void setHorario(Horario horario) {
		Horario = horario;
	}

	public Trabajador getTrabajador() {
		return Trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		Trabajador = trabajador;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}
	
	
}
