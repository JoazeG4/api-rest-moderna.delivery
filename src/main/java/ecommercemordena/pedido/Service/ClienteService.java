package ecommercemordena.pedido.Service;

import ecommercemordena.pedido.Repository.ClienteRepository;
import lombok.AllArgsConstructor;
import ecommercemordena.pedido.Model.Cliente;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteService {

    private ClienteRepository clienteRepository;

    public Cliente salvarCliente(Cliente cliente) throws Exception{
        var clienteSalvo = clienteRepository.findByCpf(cliente.getCpf());

        if(clienteSalvo.isEmpty()){
            return clienteRepository.save(cliente);
        }
        throw new Exception("Cliente existente!");
    }

    public Cliente atualizarClienteId(Long id, Cliente cliente) throws Exception {
        var clienteAtual = clienteRepository.findById(id).orElseThrow(() -> new Exception("Cliente não encontrado!"));
        var clienteNovo = clienteRepository.findByCpf(cliente.getCpf());

        if (Objects.equals(clienteAtual.getCpf(), cliente.getCpf()) || clienteNovo.isEmpty()) {
            BeanUtils.copyProperties(cliente, clienteAtual, "id");
            return clienteRepository.save(clienteAtual);
        }
        throw new Exception("Cliente já existente!");
    }

    public Cliente atualizarClienteCpf(String cpf, Cliente cliente) throws Exception{
        var clienteAtual = clienteRepository.findByCpf(cpf).orElseThrow(() -> new Exception("Cliente não encontrado!"));
        var clienteNovo = clienteRepository.findByCpf(cliente.getCpf());

        if (Objects.equals(clienteAtual.getCpf(), cliente.getCpf()) || clienteNovo.isEmpty()) {
            BeanUtils.copyProperties(cliente, clienteAtual, "id");
            return clienteRepository.save(clienteAtual);
        }
        throw new Exception("Cliente já existente!");
    }

    public List<Cliente> listarTodosClientes() throws Exception{
        var clientesAtuais = clienteRepository.findAll().isEmpty();

        if (clientesAtuais){
            throw new Exception("Não existe clientes");
        }
        return clienteRepository.findAll();
    }

    public Optional<Cliente> listarClientePorId(Long id) throws Exception{
        return Optional.ofNullable(clienteRepository.findById(id)
                .orElseThrow(() -> new Exception("Cliente inexistente!")));
    }

    public Optional<Cliente> listarClientePorCpf(String cpf) throws Exception{
        return  Optional.ofNullable(clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new Exception("Cliente inexistente!")));
    }

    public Void excluirTodosClientes() throws Exception{
        var clienteAtuais = clienteRepository.findAll().isEmpty();

        if(clienteAtuais){
            throw new Exception("Não existe clientes");
        }
        clienteRepository.deleteAll();
        return null;
    }

    public Void excluirClientePorId(Long id) throws Exception{
        clienteRepository.findById(id).orElseThrow(() -> new Exception("Cliente não encontrado!"));
        clienteRepository.deleteById(id);
        return null;
    }

    public Void excluirClientePorCpf(String cpf) throws Exception{
        clienteRepository.findByCpf(cpf).orElseThrow(() -> new Exception("Cliente não encontrado!"));
        clienteRepository.deleteByCpf(cpf);
        return null;
    }
}
