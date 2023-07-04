package ecommercemordena.pedido.Controller;

import ecommercemordena.pedido.Model.Produto;
import ecommercemordena.pedido.Service.ProdutoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) throws Exception{
        try{
            log.info("Salvando produto");
            return new ResponseEntity<>(produtoService.salvarProduto(produto), HttpStatus.CREATED);

        }catch (Exception exception){
            log.info("Erro ou salvar produto!");
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{nomeProduto}")
    public ResponseEntity<Produto> atualizarProdutoNome(@PathVariable String nomeProduto, @RequestBody Produto produto) throws Exception{
        try{
            log.info("Atualizando produto: " + nomeProduto);
            return new ResponseEntity<>(produtoService.atualizarProdutoNome(nomeProduto, produto), HttpStatus.OK);

        }catch (Exception exception){
            log.info("Erro ou atualizar produto: " + nomeProduto);
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listarTodosProdutos() throws Exception{
        try{
            log.info("Listanto todas produtos!");
            return new ResponseEntity<>(produtoService.listarTodosProdutos(), HttpStatus.OK);

        }catch (Exception exception){
            log.info("Erro ou listar produtos!");
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{nomeProduto}")
    public ResponseEntity<Optional<Produto>> listarProdutoNome(@PathVariable String  nomeProduto) throws Exception{
        try{
            log.info("Listando produto: " + nomeProduto);
            return new ResponseEntity<>(produtoService.listarProdutoNome(nomeProduto), HttpStatus.OK);

        }catch (Exception exception){
            log.info("Erro ou listar produto: " + nomeProduto);
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> excluirTodosProdutos() throws Exception{
        try{
            log.info("Excluindo todas produtos!");
            return new ResponseEntity<>(produtoService.excluirTodosProdutos(), HttpStatus.OK);

        }catch (Exception exception){
            log.info("Erro ou excluir produtos!");
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{nomeProduto}")
    public ResponseEntity<Void> excluirProdutoNome(@PathVariable String  nomeProduto) throws Exception{
        try{
            log.info("Excluindo produto: " + nomeProduto);
            return new ResponseEntity<>(produtoService.excluirProdutoNome(nomeProduto), HttpStatus.OK);

        }catch (Exception exception){
            log.info("Erro ou excluir produto: " + nomeProduto);
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
