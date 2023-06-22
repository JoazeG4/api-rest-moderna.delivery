package ecommercemordena.pedido.Controller;

import ecommercemordena.pedido.Model.Cliente;
import ecommercemordena.pedido.Repository.ClienteRepository;
import ecommercemordena.pedido.Service.ClienteService;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {


    private ClienteRepository clienteRepository;
    private ClienteService clienteService;

    @PostMapping("/salvar-cliente")
    public Cliente salvarCliente(@RequestBody Cliente cliente)throws Exception{
        return clienteService.salvarCliente(cliente);
    }

    @PutMapping("/atualizar-cliente-id/{id}")
    public Cliente atualizarClienteId(@PathVariable Long id, @RequestBody Cliente cliente) throws Exception{
        return clienteService.atualizarClienteId(id, cliente);
    }

    @PutMapping("/atuaizar-cliente-cpf/{cpf}")
    public Cliente atualizarClienteCpf(@PathVariable String cpf, @RequestBody Cliente cliente)throws Exception{
        return clienteService.atualizarClienteCpf(cpf, cliente);
    }

    @GetMapping("/listar-todos-clientes")
    public List<Cliente> listarTodosClientes(){
        return clienteRepository.findAll();
    }

    @GetMapping("/listar-cliente-id/{id}")
    public Optional<Cliente> listarClientePorId(@PathVariable Long id) throws Exception {
        return clienteService.listarClientePorId(id);
    }

    @GetMapping("/listar-cliente-cpf/{cpf}")
    public Optional<Cliente> listarClientePorCpf(@PathVariable String cpf) throws Exception {
        return clienteService.listarClientePorCpf(cpf);
    }

    @DeleteMapping("/excluir-todos-clientes")
    public void excluirTodosClientes(){
        clienteRepository.deleteAll();
    }

    @DeleteMapping("/excluir-cliente-id/{id}")
    public void excluirClienteId(@PathVariable Long id) throws Exception {
        clienteService.excluirClientePorId(id);
    }

    @DeleteMapping("/excluir-cliente-cpf/{cpf}")
    public void excluirClienteCpf(@PathVariable String cpf) throws Exception {
        clienteService.excluirClientePorCpf(cpf);
    }
}
