package ecommercemordena.pedido.Controller;

import ecommercemordena.pedido.Model.Contato;
import ecommercemordena.pedido.Model.Estabelecimento;
import ecommercemordena.pedido.Service.ContatoService;
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
            log.info("Salvando estabelecimento!");
            return new ResponseEntity<>(estabelecimentoService.salvarEstabelecimento(estabelecimento), HttpStatus.CREATED);

        }catch (Exception exception){
            exception.printStackTrace();
            log.info("Erro ao salvar estabelecimento!");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
