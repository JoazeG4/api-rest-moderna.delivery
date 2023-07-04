package ecommercemordena.pedido.Controller;

import ecommercemordena.pedido.Model.Categoria;
import ecommercemordena.pedido.Service.CategoriaService;
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
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> salvarCategoria(@RequestBody Categoria categoria) throws Exception{
        try {
            log.info("Salvando categoria: " + categoria.getNomeCategoria());
            return new ResponseEntity<>(categoriaService.salvarCategoria(categoria), HttpStatus.CREATED);

        }catch (Exception exception){
            exception.printStackTrace();
            log.info("Erro ao salvar categoria: " + categoria.getNomeCategoria());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{nome}")
    public ResponseEntity<Categoria> atualizarCategoria(@PathVariable String nome, @RequestBody Categoria categoria) throws Exception{
        try {
            log.info("Atualizado categoria: " + categoria.getNomeCategoria());
            return new ResponseEntity<>(categoriaService.atualizarCategoria(nome, categoria), HttpStatus.OK);

        }catch (Exception exception){
            exception.printStackTrace();
            log.info("Erro ao atualizar categoria: " + categoria.getNomeCategoria());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listarTodasCategoria() throws Exception{
        try {
            log.info("Listanto todas as categoria");
            return new ResponseEntity<>(categoriaService.listaTodosCategoria(), HttpStatus.OK);

        }catch (Exception exception){
            exception.printStackTrace();
            log.info("Erro ao listar todas as categoria");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{nome}")
    public ResponseEntity<Optional<Categoria>> listarCategoriaNome(@PathVariable String nome) throws Exception{
        try {
            log.info("Listanto categoria: " + nome);
            return new ResponseEntity<>(categoriaService.listarCategoriaNome(nome), HttpStatus.OK);

        }catch (Exception exception){
            exception.printStackTrace();
            log.info("Erro ao listar categoria: " + nome);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> excluirTodasCategoria() throws Exception{
        try {
            log.info("Excluindo todas as categorias");
            return new ResponseEntity<>(categoriaService.excluirTodasCategorias(), HttpStatus.OK);

        }catch (Exception exception){
            exception.printStackTrace();
            log.info("Erro ao excluir todas as categoriaa");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{nomeCategoria}")
    public ResponseEntity<Void> excluirCategoriaNome(@PathVariable String nomeCategoria) throws Exception{
        try {
            log.info("Excluindo categoria: " + nomeCategoria);
            return new ResponseEntity<>(categoriaService.excluirCategoriaNome(nomeCategoria), HttpStatus.OK);

        }catch (Exception exception){
            exception.printStackTrace();
            log.info("Erro ao excluir categoria: " + nomeCategoria);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
