package com.example.vet.repository;

import com.example.vet.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer> {

    @Query(value = "select * from clinica_veterinaria.mascota where nombre = ?1", nativeQuery = true)
    List<Mascota> buscarNombreMascota(String nombre);

    @Query(value = "select * from clinica_veterinaria.mascota where especie = ?1", nativeQuery = true)
    List<Mascota> buscarEspecieMascota(String especie);

    @Query(value = "select * from clinica_veterinaria.mascota where estado = ?1", nativeQuery = true)
    List<Mascota> buscarEstadoMascota(String estado);
}
