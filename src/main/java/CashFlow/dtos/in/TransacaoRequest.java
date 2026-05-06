package CashFlow.dtos.in;


import CashFlow.enums.CategoriaTransacao;
import CashFlow.enums.TipoTransacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record TransacaoRequest(
        @NotBlank(message = "A descrição não pode estar vazia")
        @Size(min = 5, max = 300, message = "O mínimo de caracteres da descrição e 5 com o máximo de 300")
        String descricao,
        @NotNull(message = "O valor da transação é obrigatório")
        @Positive(message = "O valor tem que ser maior que zero pra fazer uma transação")
        BigDecimal valor,
        @NotNull(message = "Esse campo não pode estar nulo")
        TipoTransacao tipo,
        @NotNull(message = "Esse campo não pode ser nulo")
        CategoriaTransacao categoriaTransacao,
        @NotNull(message = "O id do usuário não pode estar nulo")
        Long usuarioId
) {
}
