package igor.projeto.tp1.resource;

import java.util.List;

import igor.projeto.tp1.dto.TenisPerformanceRequestDTO;
import igor.projeto.tp1.dto.TenisPerformanceResponseDTO;
import igor.projeto.tp1.mapper.TenisPerformanceMapper;
import igor.projeto.tp1.model.TenisPerformance;
import igor.projeto.tp1.service.TenisPerformanceService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/tenis-performance")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TenisPerformanceResource {
    
    @Inject
    TenisPerformanceService service;

    @GET
    public List<TenisPerformanceResponseDTO> buscarTodos() {
        return service.findAll()
                .stream()
                .map(e -> TenisPerformanceMapper.toResponseDTO(e))
                .toList();
    }

    @GET
    @Path("/{id}")
    public TenisPerformanceResponseDTO buscarPeloId(Long id) {
        return TenisPerformanceMapper.toResponseDTO(service.findById(id));
    }

    @DELETE
    @Path("/{id}")
    public void deletar(Long id) {
        service.delete(id);
    }

    @POST
    public TenisPerformanceResponseDTO incluir(TenisPerformanceRequestDTO dto) {
        TenisPerformance tenis = service.create(TenisPerformanceMapper.toEntity(dto));
        return TenisPerformanceMapper.toResponseDTO(tenis);
    }

    @PUT
    @Path("/{id}")
    public void alterar(Long id, TenisPerformanceRequestDTO dto) {
        service.update(id, TenisPerformanceMapper.toEntity(dto));
    }
}