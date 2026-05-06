package CashFlow.dtos.out;



public record LoginResponse(
        String token,
        String tipo,
        UserResponse userResponse
) {
}
