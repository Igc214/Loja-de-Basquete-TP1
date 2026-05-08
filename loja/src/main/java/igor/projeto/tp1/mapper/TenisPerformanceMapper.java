package igor.projeto.tp1.mapper;

import igor.projeto.tp1.dto.TenisPerformanceRequestDTO;
import igor.projeto.tp1.dto.TenisPerformanceResponseDTO;
import igor.projeto.tp1.model.Fabricante;
import igor.projeto.tp1.model.Posicao;
import igor.projeto.tp1.model.TenisPerformance;
import igor.projeto.tp1.model.TipoSolado;
import java.util.List;
import java.util.stream.Collectors;

public class TenisPerformanceMapper {

    public static TenisPerformance toEntity(TenisPerformanceRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        TenisPerformance tenis = new TenisPerformance();
        tenis.setNome(dto.nome());
        tenis.setNumeroDoPe(dto.numeroDoPe());
        tenis.setCor(dto.cor());
        tenis.setDescricao(dto.descricao());
        tenis.setEdicaoLimitada(dto.edicaoLimitada());
        tenis.setAutografado(dto.autografado());
        tenis.setPosicao(Posicao.valueOf(dto.idPosicao()));
        tenis.setTipoSolado(TipoSolado.valuesOf(dto.idSolado()));

        if (dto.idFabricante() != null) {
            Fabricante fabricante = new Fabricante();
            fabricante.setId(dto.idFabricante());
            tenis.setFabricante(fabricante);
        }

        return tenis;
    }

    public static TenisPerformanceResponseDTO toResponseDTO(TenisPerformance tenisPerformance) {
        if (tenisPerformance == null) {
            return null;
        }

        List<String> urls = tenisPerformance.getReviews() != null
                ? tenisPerformance.getReviews().stream().map(r -> r.getUrl()).collect(Collectors.toList())
                : List.of();

        return new TenisPerformanceResponseDTO(
                tenisPerformance.getId(),
                tenisPerformance.getNome(),
                tenisPerformance.getNumeroDoPe(),
                tenisPerformance.getCor(),
                tenisPerformance.getPosicao(),
                tenisPerformance.getTipoSolado(),
                tenisPerformance.getDescricao(),
                urls,
                tenisPerformance.getEdicaoLimitada(),
                tenisPerformance.isAutografado(),
                tenisPerformance.getFabricante());
    }
}