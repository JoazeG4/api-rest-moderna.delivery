package ecommercemordena.pedido.Controller;

import ecommercemordena.pedido.Model.Estabelecimento;
import ecommercemordena.pedido.Service.EstabelecimentoService;
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
@RequestMapping("/estabelecimentos")
public class EstabelecimentoController {

    private final EstabelecimentoService estabelecimentoService;

    @PostMapping
    public ResponseEntity<Estabelecimento> salvarEstabelecimento(@RequestBody Estabelecimento estabelecimento) throws Exception{
        try{
            log.info("Salvando estabelecimento");
            return new ResponseEntity<>(estabelecimentoService.salvarEstabelecimento(estabelecimento), HttpStatus.CREATED);

        }catch (Exception exception){
            exception.printStackTrace();
            log.info("Erro ao salvar estabelecimento!");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{razaoSocial}")
    public ResponseEntity<Estabelecimento> atualizarEstabelecimentoRazaoSocial(@PathVariable String razaoSocial, @RequestBody Estabelecimento estabelecimento) throws Exception{
        try{
            log.info("Atualizando estabelecimento razao social: " + razaoSocial);
            return new ResponseEntity<>(estabelecimentoService.atualizarEstabelecimentoRazaoSocial(razaoSocial, estabelecimento), HttpStatus.OK);

        }catch (Exception exception){
            exception.printStackTrace();
            log.info("Erro ao estabelecimento razao social: " + razaoSocial);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{razaoSocial}")
    public ResponseEntity<Optional<Estabelecimento>> listarEstabelecimentoRazaoSocial(@PathVariable String razaoSocial) throws Exception{
        try{
            log.info("Listanto estabelecimento razao social: " + razaoSocial);
            return new ResponseEntity<>(estabelecimentoService.listarEstabelecimentoRazaoSocial(razaoSocial), HttpStatus.OK);

        }catch (Exception exception){
            exception.printStackTrace();
            log.info("Erro ao estabelecimento razao social: " + razaoSocial);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Estabelecimento>> listarTodosEstabelecimentos() throws Exception{
        try{
            log.info("Listando todos estabelecimentos!");
            return new ResponseEntity<>(estabelecimentoService.listarTodosEstabelecimentos(), HttpStatus.OK);

        }catch (Exception exception){
            exception.printStackTrace();
            log.info("Erro ao listar todos estabelecimentos!");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{razaoSocial}")
    public ResponseEntity<Void> excluirEstabelecimentoRazaoSocial(@PathVariable String razaoSocial) throws Exception{
        try{
            log.info("Excluindo estabelecimento razao social: " + razaoSocial);
            return new ResponseEntity<>(estabelecimentoService.excluirEstabelecimentoRazaoSocial(razaoSocial), HttpStatus.OK);

        }catch (Exception exception){
            exception.printStackTrace();
            log.info("Erro ao excluir estabelecimento razao social: " + razaoSocial);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> excluirTodosEstabelecimentos() throws Exception{
        try{
            log.info("Excluindo todos enderecos");

            return new ResponseEntity<>(estabelecimentoService.excluirTodosEstabelecimentos(), HttpStatus.OK);

        }catch (Exception exception){
            log.info("Erro ao excluir todos ederecos!");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}