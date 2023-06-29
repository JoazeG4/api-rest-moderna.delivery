package ecommercemordena.pedido.Controller;

import ecommercemordena.pedido.Model.Cliente;
import ecommercemordena.pedido.Service.ClienteService;
import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente) throws Exception{
        try{
            log.info("Salvando cliente");
            return new ResponseEntity<>(clienteService.salvarCliente(cliente), HttpStatus.CREATED);

        }catch (Exception exception){
            log.info("Erro ou salvar cliente!");
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("id/{id}")
    public ResponseEntity<Cliente> atualizarClienteId(@PathVariable Long id, @RequestBody Cliente cliente) throws Exception{
        try{
            log.info("Atualizando cliente por id: " + id);
            return new ResponseEntity<>(clienteService.atualizarClienteId(id, cliente), HttpStatus.OK);

        }catch (Exception exception){
            log.info("Erro ou atualizar cliente id: " + id);
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("cpf/{cpf}")
    public ResponseEntity<Cliente> atualizarClienteCpf(@PathVariable String cpf, @RequestBody Cliente cliente) throws Exception{
        try {
            log.info("Atualizando cliente por cpf: " + cpf);
            return new ResponseEntity<>(clienteService.atualizarClienteCpf(cpf, cliente), HttpStatus.OK);

        } catch (Exception exception) {
            log.info("Erro ou atualizar cliente cpf: " + cpf);
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodosClientes() throws Exception{
        try{
            log.info("Listanto todas os clientes!");
            return new ResponseEntity<>(clienteService.listarTodosClientes(), HttpStatus.OK);

        }catch (Exception exception){
            log.info("Erro ou listar clientes!");
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Optional<Cliente>> listarClientePorId(@PathVariable Long id) throws Exception{
        try{
            log.info("Listando cliente por id: " + id);
            return new ResponseEntity<>(clienteService.listarClientePorId(id), HttpStatus.OK);

        }catch (Exception exception){
            log.info("Erro ou listar cliente id: " + id);
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("cpf/{cpf}")
    public ResponseEntity<Optional<Cliente>> listarClientePorCpf(@PathVariable String cpf) throws Exception{
        try{
            log.info("Listando cliente por cpf: " + cpf);
            return new ResponseEntity<>(clienteService.listarClientePorCpf(cpf), HttpStatus.OK);

        }catch (Exception exception){
            log.info("Erro ou listar cliente cpf: " + cpf);
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> excluirTodosClientes() throws Exception{
        try{
            log.info("Excluindo todas os clientes!");
            return new ResponseEntity<>(clienteService.excluirTodosClientes(), HttpStatus.OK);

        }catch (Exception exception){
            log.info("Erro ou excluir clientes!");
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<Void> excluirClienteId(@PathVariable Long id) throws Exception{
        try{
            log.info("Excluindo cliente por id: " + id);
            return new ResponseEntity<>(clienteService.excluirClientePorId(id), HttpStatus.OK);

        }catch (Exception exception){
            log.info("Erro ou excluir cliente id: " + id);
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("cpf/{cpf}")
    public ResponseEntity<Void> excluirClienteCpf(@PathVariable String cpf) throws Exception{
        try{
            log.info("Excluindo cliente por cpf: " + cpf);
            return new ResponseEntity<>(clienteService.excluirClientePorCpf(cpf),HttpStatus.OK);

        }catch (Exception exception){
            log.info("Erro ou excluir cliente cpf: " + cpf);
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
