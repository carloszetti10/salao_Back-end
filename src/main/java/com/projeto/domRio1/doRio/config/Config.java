package com.projeto.domRio1.doRio.config;


import com.projeto.domRio1.doRio.model.Usuario;
import com.projeto.domRio1.doRio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {


    @Autowired
    private UsuarioService service;
    @Bean
    public CommandLineRunner getCommadLine(){
        return args -> {
            Usuario u = new Usuario();
            u.setNome("Admin");
            u.setUsuarioLogar("adm");
            u.setSenha("adm");
            //service.salvarUsuario(u);
        };
    }
}
