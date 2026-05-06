package CashFlow.dtos.out;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public record BalanceResponse(
        BigDecimal saldoTotal,
        BigDecimal totalReceitas,
        BigDecimal totalDespesas,
        LocalDateTime dataConsulta
) {
}
