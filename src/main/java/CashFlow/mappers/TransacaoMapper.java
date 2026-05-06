package CashFlow.mappers;


import CashFlow.domain.entidades.Transacao;
import CashFlow.dtos.in.TransacaoRequest;
import CashFlow.dtos.out.TransacaoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransacaoMapper {
    @Mapping(target = "usuario.id", source = "usuarioId")
    @Mapping(target = "categoria", source = "categoriaTransacao")
    Transacao toEntity(TransacaoRequest transacaoRequest);

    TransacaoResponse toResponse(Transacao transacao);
}
