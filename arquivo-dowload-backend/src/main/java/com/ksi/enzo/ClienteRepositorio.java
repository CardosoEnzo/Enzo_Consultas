package com.ksi.enzo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Classe responsável por fazer a intermediação entre o banco de dados e o sistema.
@Repository
public interface ClienteRepositorio extends JpaRepository<ClienteModelo, Long> {

}
