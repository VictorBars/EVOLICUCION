package pe.edu.upn.demo.init;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upn.demo.model.entidades.Horario;
/*import pe.edu.upn.demo.model.entidades.Servicio;*/
import pe.edu.upn.demo.model.entidades.Trabajador;
import pe.edu.upn.demo.model.entidades.Usuario;
import pe.edu.upn.demo.model.repository.AuthorityRepository;
import pe.edu.upn.demo.model.repository.CitaRepository;
import pe.edu.upn.demo.model.repository.HorarioRepository;
import pe.edu.upn.demo.model.repository.ServicioRepository;
import pe.edu.upn.demo.model.repository.TrabajadorRepository;
import pe.edu.upn.demo.model.repository.UsuarioRepository;

@Service
public class InitDB implements CommandLineRunner{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	private CitaRepository citaRepository;
	
	@Autowired
	private ServicioRepository servicioRepository;
	
	@Autowired
	private HorarioRepository horarioRepository;
	
	@Autowired
	private TrabajadorRepository trabajadorRepository;
	

	@Override
	public void run(String... args) throws Exception {
		
	
		this.citaRepository.deleteAll();
				
		this.servicioRepository.deleteAll();
		this.horarioRepository.deleteAll();
		this.trabajadorRepository.deleteAll();
		
		this.usuarioRepository.deleteAll();
		this.authorityRepository.deleteAll();
		
		Usuario juan = new Usuario();
		juan.setUsername("juan");
		juan.setPassword(passwordEncoder.encode("juan"));
		juan.setApellidos("Flores");
		juan.setCorreo("correo1");
		juan.setDni("12222222");
		juan.setNombres("Juan");
		
		juan.setEnable(true);
		
		Usuario admin = new Usuario();
		admin.setUsername("admin");
		admin.setPassword(passwordEncoder.encode("admin3214"));
		admin.setApellidos("Gomez Lopez");
		admin.setCorreo("labelladurmiente1968@hotmail.com");
		admin.setDni("56722222");
		admin.setNombres("Sara Emilia");
		
		admin.setEnable(true);
		
        Usuario manager = new Usuario();
        manager.setUsername("manager");
        manager.setPassword(passwordEncoder.encode("manager"));
        manager.setApellidos("Flores");
        manager.setCorreo("correo3");
        manager.setDni("89054444");
		manager.setNombres("Juan");
		
        manager.setEnable(true);
        
        juan.addAuthority("ROLE_USER");
        juan.addAuthority("ACCESS_MEDICO_READ");
        
        admin.addAuthority("ROLE_ADMIN");
        admin.addAuthority("ACCESS_REST1");
        admin.addAuthority("ACCESS_REST2");
        manager.addAuthority("ROLE_MANAGER");
        manager.addAuthority("ACCESS_REST1");
        
        
        /*Servicio ser = new Servicio();
		ser.setNombre("Zumba");
		ser.setPrecio(45.00);
		ser.setDuracion("45 min");
		ser.setDescripcion("La clase combina ritmos como salsa, merengue, cumbia, reggaetón entre otros. Atrévete, quema calorías, aumenta tu coordinación y diviértete al máximo.");
		ser.setBanner("https://bodytechperu.com/uploads/course/6589261d10ec4c2b96805b81b4cd0546/CLASES_CLASE27_Zumba-min-1.jpg");
		ser.setHorario(null)
		ser = servicioRepository.save(ser);*/
        
		
		//Horario 1
	    Horario hora = new Horario();
	    hora.setDescripcion("09:00 am");
	    hora = horarioRepository.save(hora);
	    
	    //Horario 2
	    Horario hora1 = new Horario();
	    hora1.setDescripcion("10:00 am");
	    hora1 = horarioRepository.save(hora1);
	    
	    //Horario 3
	    Horario hora2 = new Horario();
	    hora2.setDescripcion("08:00 pm");
	    hora2 = horarioRepository.save(hora2);
	    
	    //Horario 4
	    Horario hora3 = new Horario();
	    hora3.setDescripcion("09:00 pm");
	    hora3 = horarioRepository.save(hora3);
		
		
	    //Trabajador 1
	    Trabajador t1 = new Trabajador();
	    
	    t1.setNombre("Sara Aliga");
	    t1.setSexo("F");
	    t1.setDireccion("Jr.Ica 3290");
	    t1.setDni("12345678");
	    t1.setTelefono("123456789");
	    t1 = trabajadorRepository.save(t1);
		
	    //Trabajador 2
	    Trabajador t2 = new Trabajador();
	    
	    t2.setNombre("Maria Alban");
	    t2.setSexo("F");
	    t2.setDireccion("Jr.Huanuco 5678");
	    t2.setDni("12345768");
	    t2.setTelefono("123456799");
	    t2 = trabajadorRepository.save(t2);
	    
	    //Trabajador 2
	    Trabajador t3 = new Trabajador();
	    
	    t3.setNombre("Bruno Almonte");
	    t3.setSexo("M");
	    t3.setDireccion("Jr.Ica 3291");
	    t3.setDni("11145768");
	    t3.setTelefono("123457799");
	    t3 = trabajadorRepository.save(t3);
	    
	    //Trabajador 2
	    Trabajador t4 = new Trabajador();
	    
	    t4.setNombre("Nayely Fernandez");
	    t4.setSexo("F");
	    t4.setDireccion("Jr. Cusco 176");
	    t4.setDni("11145778");
	    t4.setTelefono("123477799");
	    t4 = trabajadorRepository.save(t4);
	    
		
		
        List<Usuario> usuarios = Arrays.asList(juan, admin, manager);        
        this.usuarioRepository.saveAll(usuarios);
        /*this.servicioRepository.save(ser);*/
        //Grabar Horario
	    this.horarioRepository.save(hora);
	    this.horarioRepository.save(hora1);
	    this.horarioRepository.save(hora2);
	    this.horarioRepository.save(hora3);
	    //Grabar Trabajador
	    this.trabajadorRepository.save(t1);
	    this.trabajadorRepository.save(t2);
	    this.trabajadorRepository.save(t3);

	}
}
