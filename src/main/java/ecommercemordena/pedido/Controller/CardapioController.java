package ecommercemordena.pedido.Controller;

import ecommercemordena.pedido.Model.Cardapio;
import ecommercemordena.pedido.Service.CardapioService;
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
@RequestMapping("/cardapios")
public class CardapioController {

    private CardapioService cardapioService;

    @PostMapping
    public ResponseEntity<Cardapio> salvarCardapio(@RequestBody Cardapio cardapio) throws Exception{
        try{
            log.info("Salvando cardapio");
            return new ResponseEntity<>(cardapioService.salvarCardapio(cardapio), HttpStatus.CREATED);

        }catch (Exception exception){
            log.info("Erro ou salvar cardapio!");
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{nomeCardapio}")
    public ResponseEntity<Cardapio> atualizarCardapioNome(@PathVariable String nomeCardapio, @RequestBody Cardapio cardapio) throws Exception{
        try{
            log.info("Atualizando cardapio: " + nomeCardapio);
            return new ResponseEntity<>(cardapioService.atualizarCardapioNome(nomeCardapio, cardapio), HttpStatus.OK);

        }catch (Exception exception){
            log.info("Erro ou atualizar cardapio: " + nomeCardapio);
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Cardapio>> listarTodosCardapios() throws Exception{
        try{
            log.info("Listanto todas cardapios!");
            return new ResponseEntity<>(cardapioService.listarTodosCardapios(), HttpStatus.OK);

        }catch (Exception exception){
            log.info("Erro ou listar cardapios!");
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{nomeCardapio}")
    public ResponseEntity<Optional<Cardapio>> listarCardapioNome(@PathVariable String  nomeCardapio) throws Exception{
        try{
            log.info("Listando cardapio: " + nomeCardapio);
            return new ResponseEntity<>(cardapioService.listarCardapioNome(nomeCardapio), HttpStatus.OK);

        }catch (Exception exception){
            log.info("Erro ou listar cardapio: " + nomeCardapio);
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> excluirTodosCardapios() throws Exception{
        try{
            log.info("Excluindo todas cardapios!");
            return new ResponseEntity<>(cardapioService.excluirTodosCardapios(), HttpStatus.OK);

        }catch (Exception exception){
            log.info("Erro ou excluir cardapios!");
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{nomeProduto}")
    public ResponseEntity<Void> excluirCardapioNomeProduto(@PathVariable String  nomeCardapio) throws Exception{
        try{
            log.info("Excluindo cardapios: " + nomeCardapio);
            return new ResponseEntity<>(cardapioService.excluirCardapioNome(nomeCardapio), HttpStatus.OK);

        }catch (Exception exception){
            log.info("Erro ou excluir cardapios: " + nomeCardapio);
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}