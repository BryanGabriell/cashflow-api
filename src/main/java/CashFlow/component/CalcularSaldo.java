package CashFlow.component;


import CashFlow.domain.entidades.Transacao;
import CashFlow.dtos.out.BalanceResponse;
import CashFlow.enums.TipoTransacao;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class CalcularSaldo {
    public BalanceResponse calcular(List<Transacao> transacaoLista){
        BigDecimal totalReceita = transacaoLista.stream()
                .filter(transacao ->
                        transacao.getTipo() == TipoTransacao.RECEITA)
                .map(Transacao::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalDespesa = transacaoLista.stream()
                .filter(transacao ->
                transacao.getTipo() == TipoTransacao.DESPESA)
                .map(Transacao::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal saldoTotal = totalDespesa.subtract(totalDespesa);
        return new BalanceResponse(
                saldoTotal,
                totalReceita,
                totalDespesa,
                LocalDateTime.now());
    }
}
