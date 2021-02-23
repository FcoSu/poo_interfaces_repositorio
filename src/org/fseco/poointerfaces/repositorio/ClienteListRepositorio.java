package org.fseco.poointerfaces.repositorio;

import com.sun.security.ntlm.Client;
import org.fseco.poointerfaces.modelo.Cliente;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClienteListRepositorio implements FullRepositorio{

    private List<Cliente> dataSource;

    public ClienteListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public int total() {
        return this.dataSource.size();
    }

    @Override
    public List<Cliente> listar() {
        return dataSource;
    }

    @Override
    public Cliente porId(Integer id) {
        Cliente resultado =null;
        for(Cliente cli: dataSource){
            if(cli.getId()!=null && cli.getId().equals(id)){
               resultado = cli;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void crear(Cliente cliente) {
        this.dataSource.add(cliente);
    }

    @Override
    public void editar(Cliente cliente) {
        Cliente c = this.porId(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
    }

    @Override
    public void eliminar(Integer id) {
        this.dataSource.remove(this.porId(id));
    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        List<Cliente> listaOrdenanda = new ArrayList<>(this.dataSource);
        listaOrdenanda.sort(( a,  b) -> {
                int resultado = 0;
                if(dir == Direccion.ASC){
                    resultado = ordenar(campo, a, b);
                }else if(dir == Direccion.DESC)
                {
                    resultado = ordenar(campo, b, a);
                }
                return resultado;




        });
        return listaOrdenanda;

    }

    @Override
    public List<Cliente> listar(int desde, int hasta) {
        return dataSource.subList(desde,hasta);
    }

    static int ordenar(String campo, Cliente a, Cliente b){
        int resultado = 0;
        switch (campo){
            case "id":
                resultado = a.getId().compareTo(b.getId());
            case "nombre":
                resultado = a.getNombre().compareTo(b.getNombre());
            case "apellido":
                resultado = a.getApellido().compareTo(b.getApellido());

        }
        return resultado;
    }

}
