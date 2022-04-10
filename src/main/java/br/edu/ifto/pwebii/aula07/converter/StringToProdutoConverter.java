package br.edu.ifto.pwebii.aula07.converter;

import br.edu.ifto.pwebii.aula07.model.entity.Produto;
import br.edu.ifto.pwebii.aula07.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class StringToProdutoConverter implements Converter<String, Produto> {
    @Autowired
    private ProdutoRepository repository;

    public Produto convert(final String source) {
        return repository.produto(Long.valueOf(source));
    }
}
