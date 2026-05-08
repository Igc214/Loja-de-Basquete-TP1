package igor.projeto.tp1.service;

import java.util.List;

import igor.projeto.tp1.model.TenisPerformance;

public interface TenisPerformanceService {
    List<TenisPerformance> findAll();
    TenisPerformance findById(Long id);
    TenisPerformance create(TenisPerformance tenisPerformance);
    void update(Long id, TenisPerformance tenisPerformance);
    void delete(Long id);
}