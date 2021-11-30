package pe.edu.upn.demo.service;

import java.util.Optional;

import pe.edu.upn.demo.model.entidades.Trabajador;

public interface TrabajadorService extends CrudService<Trabajador, Integer> {

	Optional<Trabajador> findByDni(String dni) throws Exception;
	Optional<Trabajador> findById(Integer id) throws Exception;
}
