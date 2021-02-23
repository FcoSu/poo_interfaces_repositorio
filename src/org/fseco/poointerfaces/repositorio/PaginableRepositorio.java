package org.fseco.poointerfaces.repositorio;

import org.fseco.poointerfaces.modelo.Cliente;

import java.util.List;

public interface PaginableRepositorio {
    List<Cliente> listar(int desde, int hasta);
}
