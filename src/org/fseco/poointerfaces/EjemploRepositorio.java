package org.fseco.poointerfaces;

import org.fseco.poointerfaces.modelo.Cliente;
import org.fseco.poointerfaces.repositorio.*;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {
       FullRepositorio repo  = new ClienteListRepositorio();

       repo.crear(new Cliente("Bea","Perez"));
       repo.crear(new Cliente("Andres","Seco"));
       repo.crear(new Cliente("Carlos","Gomez"));
        repo.crear(new Cliente("Francisco","Seco"));
        List<Cliente> clientes = repo.listar();

        clientes.forEach(System.out::println);
        System.out.println("==== paginable =====");
        List<Cliente> paginable =  repo.listar(1,2);
        paginable.forEach(System.out::println);

        System.out.println("==== ordenar Nombre ASC =====");
        List<Cliente> clientesOrdenAsc = repo
                .listar("nombre", Direccion.ASC);
        clientesOrdenAsc.forEach(System.out::println);

        System.out.println("==== ordenar Apellido DESC =====");
        List<Cliente> clientesOrdenDesc = repo
                .listar("apellido", Direccion.DESC);
        clientesOrdenDesc.forEach(System.out::println);


        System.out.println("===== editar =====");
        Cliente beaActualizar = new Cliente("Bea", "Munoz");
        beaActualizar.setId(1);
        repo.editar(beaActualizar);
        Cliente bea = repo.porId(1);
        System.out.println(bea);

        System.out.println("===== Elimimnar =====");
        repo.eliminar(1);
        repo.listar().forEach(System.out::println);

        System.out.println("===== Total =====");
        System.out.println("Total registros: "+ repo.total());




    }
}
