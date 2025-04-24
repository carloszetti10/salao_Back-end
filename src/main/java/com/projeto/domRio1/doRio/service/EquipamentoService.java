package com.projeto.domRio1.doRio.service;


import com.projeto.domRio1.doRio.exception.ErroException;
import com.projeto.domRio1.doRio.model.*;
import com.projeto.domRio1.doRio.repository.EquipamentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamentoService {
    @Autowired
    EquipamentoRepository equipamentoRepository;

    @Autowired
    EquipamentoEmprestimoService equiEmpestimo;

    @Autowired
    EquipamentoRetiradaService equiRetirada;

    @Transactional
    public void salvar(Equipamento e, int quantidade) {
        try {
            if (e.getTipo() == TipoEquipamento.EMPRESTIMO) {
                salvarEquipamentoEmprestimo(e, quantidade);
            } else {
                salvarEquipamentoRetirada(e, quantidade);
            }
        } catch (Exception ex) {
            throw new ErroException("Não foi possível cadastrar o Equipamento!");
        }
    }

    private void salvarEquipamentoEmprestimo(Equipamento e, int quantidade) {
        Equipamento existente = findByCodigoAndEquipamentoBase(e.getCodigo(), e.getEquipamentoBase(), TipoEquipamento.EMPRESTIMO);
        if (existente != null && existente.isApagado()) {
            existente.setApagado(false);
            equipamentoRepository.save(existente);
        } else {
            Equipamento novo = equipamentoRepository.save(e);
            cadastrarPorTipo(novo, quantidade);
        }
    }

    private void salvarEquipamentoRetirada(Equipamento e, int quantidade) {
        Equipamento existente = findByCodigoAndEquipamentoBase(e.getCodigo(), e.getEquipamentoBase(), TipoEquipamento.RETIRADA);
        if (existente != null && existente.isApagado()) {
            EquipamentoRetirada retirada = equiRetirada.buscarEquipamentoRetirada(existente.getId(), e.getCodigo());
            retirada.setQuantidade(quantidade);
            equiRetirada.salva(retirada);
            existente.setApagado(false);
            equipamentoRepository.save(existente);
        } else {
            Equipamento novo = equipamentoRepository.save(e);
            cadastrarPorTipo(novo, quantidade);
        }
    }

    @Transactional
    void cadastrarPorTipo(Equipamento e, int quant){
        if(e.getTipo().equals(TipoEquipamento.EMPRESTIMO)){
            EquipamentoEmprestimo emprestimo = new EquipamentoEmprestimo();
            emprestimo.setEquipamentoEmp(e);
            emprestimo.setDisponivel(true);
            equiEmpestimo.salvar(emprestimo);
        }else{
            EquipamentoRetirada retirada = new EquipamentoRetirada();
            retirada.setEquipamentoRet(e);
            retirada.setQuantidade(quant);
            equiRetirada.salva(retirada);
        }
    }


    public List<Equipamento> buscarTodos() {
        return equipamentoRepository.findAll();
    }


    public Equipamento findByCodigoAndEquipamentoBase(String patrimonioValue, EquiBase equipamentoValue, TipoEquipamento tipoEquipamento) {
        return equipamentoRepository.findByCodigoAndEquipamentoBaseAndTipo(patrimonioValue, equipamentoValue, tipoEquipamento);
    }


    @Transactional
    public List<Equipamento> listarPorEquiBase(EquiBase equiBase) {
        return equipamentoRepository.findAllByEquipamentoBase(equiBase);
    }

}
