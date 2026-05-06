package CashFlow.dtos.out;


import java.time.LocalDateTime;

public record UserResponse(
Long id,
String nome,
String email,
LocalDateTime createdAt,
LocalDateTime updatedAt
) {
}
