package ecommercemordena.pedido.Service;

import ecommercemordena.pedido.Model.Pedido;
import ecommercemordena.pedido.Repository.ClienteRepository;
import ecommercemordena.pedido.Repository.EstabelecimentoRepository;
import ecommercemordena.pedido.Repository.PedidoRepository;
import ecommercemordena.pedido.Repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PedidoService {

    private PedidoRepository pedidoRepository;
    private ClienteRepository clienteRepository;
    private EstabelecimentoRepository estabelecimentoRepository;
    private ProdutoRepository produtoRepository;

    public Pedido salvarPedido(Pedido pedido) throws Exception {
        var cliente = clienteRepository.findById(pedido.getCliente().getId());
        var estabelecimento = estabelecimentoRepository.findById(pedido.getEstabelecimento().getId());
        var produto = produtoRepository.findById(pedido.getProduto().getId());

        if (cliente.isPresent() && estabelecimento.isPresent() && produto.isPresent()) {
            return pedidoRepository.save(pedido);
        }
        throw new Exception("Cliente ou estabelecimento não existe");
    }

    public Pedido atualizarPedidoNome(Long id, Pedido pedido) throws Exception{
        var pedidoAtual = pedidoRepository.findById(id).orElseThrow(() -> new Exception("Pedido existe "));
        BeanUtils.copyProperties(pedido, pedidoAtual, "id");
        return pedidoRepository.save(pedidoAtual);
    }

    public List<Pedido> listarTodosPedidos() throws Exception{
        var pedidoAtual = pedidoRepository.findAll().isEmpty();

        if(pedidoAtual) {
            throw new Exception("Não existe pedidos");
        }
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> listarPedidoId(Long id) throws Exception{
        return Optional.ofNullable(pedidoRepository.findById(id)
                .orElseThrow(() -> new Exception("Produto não existe")));
    }

    public Void excluirTodosPedidos() throws Exception{
        var pedidoAtual = pedidoRepository.findAll().isEmpty();

        if(pedidoAtual) {
            throw new Exception("Não existe pedidos!");
        }
        pedidoRepository.deleteAll();
        return null;
    }

    public Void excluirPedidoId(Long id) throws Exception{
        pedidoRepository.findById(id).orElseThrow(() -> new Exception("Pedido não existe!"));
        pedidoRepository.deleteById(id);
        return null;
    }
}
