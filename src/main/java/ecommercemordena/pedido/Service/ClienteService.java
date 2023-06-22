package ecommercemordena.pedido.Service;

import ecommercemordena.pedido.Repository.ClienteRepository;
import lombok.AllArgsConstructor;
import ecommercemordena.pedido.Model.Cliente;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteService {

    private ClienteRepository clienteRepository;

    public Cliente salvarCliente(Cliente cliente) throws Exception {

        var clienteSalvo = clienteRepository.findByCpf(cliente.getCpf());

        if(clienteSalvo.isEmpty()){
            return clienteRepository.save(cliente);
        }

        throw new Exception("Cliente existente!");
    }

    public Cliente atualizarClienteId(Long id, Cliente cliente)throws Exception{

        var idCliente = clienteRepository.findById(id);

        if (idCliente.isPresent()){

            var clienteAtual = clienteRepository.findById(id).get();

            BeanUtils.copyProperties(cliente, clienteAtual, "id");
            return clienteRepository.save(clienteAtual);
        }

        throw new Exception("Cliente não existe!");
    }

    public Cliente atualizarClienteCpf(String cpf, Cliente cliente)throws Exception{

        var idCliente = clienteRepository.findByCpf(cpf);

        if (idCliente.isPresent()){

            var clienteAtual = clienteRepository.findByCpf(cpf).get();

            BeanUtils.copyProperties(cliente, clienteAtual, "id");
            return clienteRepository.save(clienteAtual);
        }

        throw new Exception("Cliente inexistente!");
    }

    public Optional<Cliente> listarClientePorId(Long id) throws Exception {

        var clienteId = clienteRepository.findById(id);

        if(clienteId.isPresent()) {
            return clienteRepository.findById(id);
        }

        throw new Exception("Cliente inexistente!");
    }

    public Optional<Cliente> listarClientePorCpf(String cpf) throws Exception {

        var cpfCliente = clienteRepository.findByCpf(cpf);

        if(cpfCliente.isPresent()){
            return clienteRepository.findByCpf(cpf);
        }

        throw new Exception("Cliente inexistente!");
    }

    public void excluirClientePorId(Long id) throws Exception {

        var idCliente = clienteRepository.findById(id);

        if(idCliente.isPresent()){
            clienteRepository.deleteById(id);
        }else{
            throw new Exception("Cliente inexistente!");
        }
    }

    public void excluirClientePorCpf(String cpf) throws Exception {

        var cpfCliente = clienteRepository.findByCpf(cpf);

        if(cpfCliente.isPresent()){
            clienteRepository.deleteByCpf(cpf);
        }else{
            throw new Exception("Cliente inexistente!");
        }
    }
}
