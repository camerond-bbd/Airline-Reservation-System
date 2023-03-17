package co.za.bbd.ars.service;

import co.za.bbd.ars.model.DummyDomain;

import java.util.List;

public interface DummyService extends IService<DummyDomain, Integer> {
    void deleteById(Integer id);
    List<DummyDomain> findAll();
}
