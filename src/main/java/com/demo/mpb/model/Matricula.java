package com.demo.mpb.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "matriculas")
public class Matricula implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "matricula_id")
	private Integer matriculaId;
	
	@Column(length = 70)
	private String comentario;
	
	@Column
	private Byte estadoPago;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaMatricula;
	
	@Column
	private Byte estado;
	
	@ManyToOne
	@JoinColumn(name = "alumno_id", nullable = false,
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (alumno_id)"
															+ " references alumnos(alumno_id)"))
	private Alumno alumno;
	
	@ManyToOne
	@JoinColumn(name = "seccion_id", nullable = false,
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (seccion_id)"
															+ " references secciones(seccion_id)"))
	private Seccion seccion;
	
	@OneToMany(mappedBy = "matricula", cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Calificacion> itemsCalificacion = new ArrayList<>();
	
	public Matricula() {
		super();
	}

	public Matricula(Integer matriculaId, String comentario, Byte estadoPago, Date fechaMatricula, Byte estado) {
		super();
		this.matriculaId = matriculaId;
		this.comentario = comentario;
		this.estadoPago = estadoPago;
		this.fechaMatricula = fechaMatricula;
		this.estado = estado;
	}

	public Integer getMatriculaId() {
		return matriculaId;
	}

	public void setMatriculaId(Integer matriculaId) {
		this.matriculaId = matriculaId;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Byte getEstadoPago() {
		return estadoPago;
	}

	public void setEstadoPago(Byte estadoPago) {
		this.estadoPago = estadoPago;
	}

	public Date getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(Date fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}

	public Byte getEstado() {
		return estado;
	}

	public void setEstado(Byte estado) {
		this.estado = estado;
	}
}
