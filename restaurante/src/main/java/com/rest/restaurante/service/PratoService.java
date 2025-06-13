package com.rest.restaurante.service;

import com.rest.restaurante.exception.NomeJaCadastradoException;
import com.rest.restaurante.repository.PratoRepository;
import jakarta.validation.Valid;
import com.rest.restaurante.model.Prato;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class PratoService {
    private PratoRepository pratoRepository;

    public PratoService(PratoRepository pratoRepository) {
        this.pratoRepository = pratoRepository;
    }

    public List<Prato> listarTodos() {
        return pratoRepository.findAll();
    }

    public Prato salvar(@Valid Prato prato) {
        if (pratoRepository.findByNome(prato.getNome()).isPresent()) {
            throw new NomeJaCadastradoException("Prato já cadastrado.");
        }

        return pratoRepository.save(prato);
    }

    public Prato atualizar(@Valid Prato prato) {
        Prato pratoAtualizar = pratoRepository.findById(prato.getId())
                .orElseThrow(() -> new IllegalArgumentException("Prato não encontrado."));

        pratoAtualizar.setNome(prato.getNome());
        pratoAtualizar.setDescricao(prato.getDescricao());
        pratoAtualizar.setPreco(prato.getPreco());
        pratoAtualizar.setCategoria(prato.getCategoria());
        pratoAtualizar.setDisponibilidade(prato.getDisponibilidade());
        pratoAtualizar.setUrlImagem(prato.getUrlImagem());  // **ATUALIZADO**

        return pratoRepository.save(pratoAtualizar);
    }

    public void excluir(Long id) {
        Prato pratoExcluir = pratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prato não encontrado"));

        pratoRepository.deleteById(pratoExcluir.getId());
    }

}