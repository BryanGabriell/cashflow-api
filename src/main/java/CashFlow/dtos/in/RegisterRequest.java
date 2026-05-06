package CashFlow.dtos.in;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record RegisterRequest(
        @NotBlank(message = "O nome é obrigatório")
        @Size(min = 3, max = 150, message = "Nome deve conter pelo menos 3 caracteres e máximo de 150 caracteres")
        String nome,

        @Email(message = "Email invalido")
        @NotBlank(message = "Email é obrigatório")
        String email,

        @NotBlank(message = "A senha é obrigatória")
        @Size(min = 8, message = "A senha deve conter o mínimo de 8 caracteres")
        @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$",
                message = "A senha deve conter pelo menos uma letra maiúscula, uma minúscula e um número"
        )
        String senha
) {
}
