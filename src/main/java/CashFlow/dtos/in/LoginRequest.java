package CashFlow.dtos.in;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank(message = "O email é obrigatório")
        @Email(message = "Email invalido")
        String email,
        @NotBlank(message = "senha é obrigatória")
        String senha
) {
}
