package ecommercemordena.pedido.Controller;

import ecommercemordena.pedido.Model.Endereco;
import ecommercemordena.pedido.Service.EnderecoService;
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
@RequestMapping("/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Endereco> salvarEndereco(@RequestBody Endereco endereco) throws Exception{
        try{
            log.info("Salvando endereco");
            return new ResponseEntity<>(enderecoService.salvarEndereco(endereco), HttpStatus.CREATED);

        }catch (Exception exception){
            exception.printStackTrace();
            log.info("Erro ao salvar endereco");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{cep}")
    public ResponseEntity<Endereco> atualizarEnderecoCep(@PathVariable String cep, @RequestBody Endereco endereco) throws Exception{
        try{
            log.info("Atualizando cep: " + cep);
            return new ResponseEntity<>(enderecoService.atualizarEnderecoCep(cep, endereco), HttpStatus.OK);

        }catch (Exception exception){
            exception.printStackTrace();
            log.info("Erro ao atualizar cep: " + cep);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{cep}")
    public ResponseEntity<Optional<Endereco>> listarEnderecoCep(@PathVariable String cep) throws Exception{
        try{
            log.info("Listanto cep: " + cep);
            return new ResponseEntity<>(enderecoService.listarEnderecoCep(cep), HttpStatus.OK);

        }catch (Exception exception){
            exception.printStackTrace();
            log.info("Erro ao listar cep: " + cep);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> listarTodosEndereco() throws Exception{
        try{
            log.info("Listando todos enderecos!");
            return new ResponseEntity<>(enderecoService.listarTodosEnderecos(), HttpStatus.OK);

        }catch (Exception exception){
            exception.printStackTrace();
            log.info("Erro ao listar todos os enderecos!");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{cep}")
    public ResponseEntity<Void> excluirEnderecoCep(@PathVariable String cep) throws Exception{
        try{
            log.info("Excluindo endereco cep: " + cep);
            return new ResponseEntity<>(enderecoService.excluirEnderecoCep(cep), HttpStatus.OK);

        }catch (Exception exception){
            exception.printStackTrace();
            log.info("Erro ao excluir endereco.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> excluirTodosEndereco() throws Exception{
        try{
            log.info("Excluindo todos enderecos");
            return new ResponseEntity<>(enderecoService.excluirTodosEnderecos(), HttpStatus.OK);

        }catch (Exception exception){
            log.info("Erro ao excluir todos ederecos!");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}