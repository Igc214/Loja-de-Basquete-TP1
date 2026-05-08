package igor.projeto.tp1.dto;

import igor.projeto.tp1.model.Fabricante;
import igor.projeto.tp1.model.Posicao;
import igor.projeto.tp1.model.TipoSolado;
import java.util.List;

public record TenisPerformanceResponseDTO(
    Long id,
    String nome,
    Integer numeroDoPe,
    String cor,
    Posicao posicao,
    TipoSolado tipoSolado,
    String descricao,
    List<String> urls,
    int edicaoLimitada,
    boolean autografado,
    Fabricante fabricante) 
{
}