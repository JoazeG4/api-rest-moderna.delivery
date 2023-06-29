package ecommercemordena.pedido.Service;

import ecommercemordena.pedido.Model.Categoria;
import ecommercemordena.pedido.Repository.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public Categoria salvarCategoria(Categoria categoria) throws Exception{
        var categoriaAtual = categoriaRepository.findByNomeCategoria(categoria.getNomeCategoria());

        if(categoriaAtual.isEmpty()){
            return categoriaRepository.save(categoria);
        }
        throw new Exception("Categoria não encontrada");
    }

    public Categoria atualizarCategoria(String nomeCategoria, Categoria categoria) throws Exception{
        var categoriaAtual = categoriaRepository.findByNomeCategoria(nomeCategoria).orElseThrow(() -> new Exception("Categoria não encontrada!"));
        var categoriaNova = categoriaRepository.findByNomeCategoria(categoria.getNomeCategoria());

        if(Objects.equals(categoriaAtual.getNomeCategoria(), categoria.getNomeCategoria()) || categoriaNova.isEmpty()) {
            BeanUtils.copyProperties(categoria, categoriaAtual, "id");
            return categoriaRepository.save(categoriaAtual);
        }
        throw new Exception("Categoria já existente!");
    }

    public List<Categoria> listaTodosCategoria() throws Exception{
        var categoriaAtual = categoriaRepository.findAll().isEmpty();

        if(categoriaAtual){
            throw new Exception("Categorias não existem");
        }
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> listarCategoriaNome(String nomeCategoria) throws Exception{
        return Optional.ofNullable(categoriaRepository.findByNomeCategoria(nomeCategoria)
                .orElseThrow(() -> new Exception("Categoria não encontrada")));
    }

    public Void excluirTodasCategorias() throws Exception{
        var categoriasAtuais = categoriaRepository.findAll().isEmpty();

        if(categoriasAtuais){
            throw new Exception("Categorias não existem");
        }
        categoriaRepository.deleteAll();
        return null;
    }

    public Void excluirCategoriaNome(String nomeCategoria) throws Exception{
        categoriaRepository.findByNomeCategoria(nomeCategoria).orElseThrow(() -> new Exception("Categoria não encontrada"));
        categoriaRepository.deleteByNomeCategoria(nomeCategoria);
        return null;
    }
}
