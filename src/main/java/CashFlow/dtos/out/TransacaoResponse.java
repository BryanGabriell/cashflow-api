package CashFlow.dtos.out;


import CashFlow.domain.entidades.User;
import CashFlow.enums.CategoriaTransacao;
import CashFlow.enums.TipoTransacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransacaoResponse(
        Long id,
        String descricao,
        BigDecimal valor,
        TipoTransacao tipo,
        CategoriaTransacao categoria,
        Long usuarioId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
