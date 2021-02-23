package org.fseco.poointerfaces.repositorio;

import org.fseco.poointerfaces.modelo.Cliente;

import java.util.List;

public interface OrdenableRepositorio {
    List<Cliente> listar(String campo, Direccion dir);


}
