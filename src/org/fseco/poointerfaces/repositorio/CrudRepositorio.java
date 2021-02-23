package org.fseco.poointerfaces.repositorio;

import org.fseco.poointerfaces.modelo.Cliente;
import java.util.List;
public interface CrudRepositorio {
    List<Cliente> listar();
    Cliente porId(Integer id);
    void crear(Cliente cliente);
    void editar(Cliente cliente);
    void eliminar(Integer id);
}