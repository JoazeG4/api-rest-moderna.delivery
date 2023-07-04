package ecommercemordena.pedido.Controller;

import ecommercemordena.pedido.Model.Pedido;
import ecommercemordena.pedido.Service.PedidoService;
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
@RequestMapping("/pedidos")
public class PedidoController {

    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Pedido> salvarPedido(@RequestBody Pedido pedido) throws Exception{
        try{
            log.info("Salvando pedido");
            return new ResponseEntity<>(pedidoService.salvarPedido(pedido), HttpStatus.CREATED);

        }catch (Exception exception){
            log.info("Erro ou salvar pedido!");
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizarPedidoNome(@PathVariable Long id, @RequestBody Pedido pedido) throws Exception{
        try{
            log.info("Atualizando pedido id: " + id);
            return new ResponseEntity<>(pedidoService.atualizarPedidoNome(id, pedido), HttpStatus.OK);

        }catch (Exception exception){
            log.info("Erro ou atualizar pedido id: " + id);
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listarTodosPedidos() throws Exception{
        try{
            log.info("Listanto todas pedidos!");
            return new ResponseEntity<>(pedidoService.listarTodosPedidos(), HttpStatus.OK);

        }catch (Exception exception){
            log.info("Erro ou listar pedidos!");
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pedido>> listarPedidoId(@PathVariable Long  id) throws Exception{
        try{
            log.info("Listando pedido: " + id);
            return new ResponseEntity<>(pedidoService.listarPedidoId(id), HttpStatus.OK);

        }catch (Exception exception){
            log.info("Erro ou listar pedido: " + id);
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> excluirTodosPedidos() throws Exception{
        try{
            log.info("Excluindo todas pedidos!");
            return new ResponseEntity<>(pedidoService.excluirTodosPedidos(), HttpStatus.OK);

        }catch (Exception exception){
            log.info("Erro ou excluir pedidos!");
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPedidoId(@PathVariable Long  id) throws Exception{
        try{
            log.info("Excluindo pedido: " + id);
            return new ResponseEntity<>(pedidoService.excluirPedidoId(id), HttpStatus.OK);

        }catch (Exception exception){
            log.info("Erro ou excluir pedido: " + id);
            exception.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
