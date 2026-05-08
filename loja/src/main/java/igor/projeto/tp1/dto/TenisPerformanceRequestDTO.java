package igor.projeto.tp1.dto;

public record TenisPerformanceRequestDTO(
        String nome,
        Integer numeroDoPe,
        String cor,
        String descricao,
        String url,
        int edicaoLimitada,
        boolean autografado,
        Long idPosicao,
        Long idSolado,
        Long idFabricante) {

}