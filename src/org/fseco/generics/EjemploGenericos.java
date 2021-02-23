package org.fseco.generics;

import org.fseco.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenericos {
    public static void main(String[] args) {

        List<Cliente> clientes= new ArrayList<>();
        clientes.add(new Cliente("Francisco", "Seco"));

        Cliente francisco = clientes.iterator().next();

        Cliente[] clientesArreglo = {new Cliente("Francisco", "Seco"),
                new Cliente("Andres", "Guzman")
        };

       Integer[] enterosArreglo = {1,2,3};

       List<Cliente> clientesLista = fromArrayToList(clientesArreglo);
       List <Integer> enterosLista = fromArrayToList(enterosArreglo);

       clientesLista.forEach(System.out::println);
       enterosLista.forEach(System.out::println);

       List<String> nombres = fromArrayToList(new String[]{"Pepe", "Lucy",
               "Fran", "Jonh"}, enterosArreglo);
       nombres.forEach(System.out::println);
    }




    public static <T> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }
    public static <T,G> List<T> fromArrayToList(T[] c, G[] g){
        for(G elemento: g){
            System.out.println(elemento);
        }
        return Arrays.asList(c);
    }




}
