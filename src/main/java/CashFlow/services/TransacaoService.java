package CashFlow.services;


import CashFlow.component.CalcularSaldo;
import CashFlow.domain.entidades.Transacao;
import CashFlow.domain.entidades.User;
import CashFlow.dtos.in.TransacaoRequest;
import CashFlow.dtos.out.BalanceResponse;
import CashFlow.dtos.out.TransacaoResponse;
import CashFlow.exceptions.AcessoNegado;
import CashFlow.exceptions.TipoTransacaoInvalida;
import CashFlow.exceptions.TransacaoNaoEncontrada;
import CashFlow.exceptions.UsuarioNaoEncontrado;
import CashFlow.mappers.TransacaoMapper;
import CashFlow.repositorios.TransacaoRepository;
import CashFlow.repositorios.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransacaoService {
    private final TransacaoRepository transacaoRepository;
    private final TransacaoMapper transacaoMapper;
    private final UserRepository userRepository;
    private final CalcularSaldo calcularSaldo;

    public TransacaoService(TransacaoRepository transacaoRepository, TransacaoMapper transacaoMapper, UserRepository userRepository, CalcularSaldo calcularSaldo) {
        this.transacaoRepository = transacaoRepository;
        this.transacaoMapper = transacaoMapper;
        this.userRepository = userRepository;
        this.calcularSaldo = calcularSaldo;
    }
    @Transactional
    public TransacaoResponse criar(TransacaoRequest request){
        if (request.tipo() == null){
            throw new TipoTransacaoInvalida("Tipo De Transação invalida");
        }
        User usuario = userRepository.findById(request.usuarioId()).orElseThrow(() ->
                new UsuarioNaoEncontrado("Usuário com o" + request.usuarioId() + "Não encontrado"));

        Transacao transacao = transacaoMapper.toEntity(request);
        transacao.setUsuario(usuario);

        Transacao salva = transacaoRepository.save(transacao);

        return transacaoMapper.toResponse(salva);
    }
    @Transactional(readOnly = true)
    public List<TransacaoResponse> buscarTodas(Long usuarioId){
        List<Transacao> transacoes = transacaoRepository.findByUsuarioId(usuarioId);

      return  transacoes.stream().
              map(transacaoMapper::toResponse).
              toList();
    }

    public void deletarTransacao(Long transacaoId,Long usuarioId){
        Transacao transacao = transacaoRepository.findById(transacaoId).orElseThrow(() ->
                new TransacaoNaoEncontrada("Transação com o " + transacaoId + "Não encontrada"));

        if(!transacao.getUsuario().getId().equals(usuarioId)){
            throw new AcessoNegado("Você não tem permissão pra excluir essa transação");
        }

        transacaoRepository.delete(transacao);
    }

    public BalanceResponse obterRelatorioSaldo(Long usuarioId){
        List<Transacao>  lista = transacaoRepository.findByUsuarioId(usuarioId);

        return calcularSaldo.calcular(lista);
    }

}
