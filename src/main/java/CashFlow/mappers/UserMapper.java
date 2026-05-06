package CashFlow.mappers;


import CashFlow.domain.entidades.User;
import CashFlow.dtos.in.UserRequest;
import CashFlow.dtos.out.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserRequest userRequest);

    UserResponse toResonse(User user);
}
