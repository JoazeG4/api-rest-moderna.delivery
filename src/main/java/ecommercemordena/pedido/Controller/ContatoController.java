package ecommercemordena.pedido.Controller;

import ecommercemordena.pedido.Model.Contato;
import ecommercemordena.pedido.Service.ContatoService;
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
@RequestMapping("/contatos")
public class ContatoController {

    private final ContatoService contatoService;

    @PostMapping
    public ResponseEntity<Contato> salvarContato(@RequestBody Contato contato) throws Exception{
        try{
            log.info("Salvando contato!");
            return new ResponseEntity<>(contatoService.salvarContato(contato), HttpStatus.CREATED);

        }catch (Exception exception){
            exception.printStackTrace();
            log.info("Erro ao salvar contato!");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{numero}")
    public ResponseEntity<Contato> atualizarContatoNumero(@PathVariable String numero, @RequestBody Contato contato) throws Exception{
        try{
            log.info("Atualizando contato");
            return new ResponseEntity<>(contatoService.atualizarContatoPorNumero(numero, contato), HttpStatus.OK);

        }catch (Exception exception){
            exception.printStackTrace();
            log.info("Erro au atualizar contato");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Contato>> listarTodasContatos() throws Exception{
        try{
            log.info("Listando todos os contatos");
            return new ResponseEntity<>(contatoService.listarTodosContatos(), HttpStatus.OK);

        }catch (Exception exception){
            exception.printStackTrace();
            log.info("Erro ao listar todos os contatos");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{numero}")
    public ResponseEntity<Optional<Contato>> listarContatoNumero(@PathVariable String numero) throws Exception{
        try{
            log.info("Listando contato por numero: " + numero);
            return new ResponseEntity<>(contatoService.listarContatoPorNumero(numero), HttpStatus.OK);

        }catch (Exception exception){
            exception.printStackTrace();
            log.info("Erro ao listar contato");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> excluirTodosContatos() throws Exception{
        try{
            log.info("Excluindo todos os contatos");
            return new ResponseEntity<>(contatoService.excluirTodosContatos(), HttpStatus.OK);

        }catch (Exception exception){
            exception.printStackTrace();
            log.info("Erro ao escluir todos os contato");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{numero}")
    public ResponseEntity<Void> excluirContatoNumero(@PathVariable String numero) throws Exception{
        try {
            log.info("Excluindo contato");
            return new ResponseEntity<>(contatoService.excluirContatoPorNumero(numero), HttpStatus.OK);

        }catch (Exception exception){
            exception.printStackTrace();
            log.info("Erro ao excluir contato");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
