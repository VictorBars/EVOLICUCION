package pe.edu.upn.demo.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upn.demo.model.entidades.Trabajador;

@Repository
public interface TrabajadorRepository extends JpaRepository<Trabajador, Integer>{

	Optional<Trabajador> findByDni(String dni) throws Exception;

}
