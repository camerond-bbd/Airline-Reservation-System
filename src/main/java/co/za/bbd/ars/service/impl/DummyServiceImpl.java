package co.za.bbd.ars.service.impl;

import co.za.bbd.ars.model.DummyDomain;
import co.za.bbd.ars.repository.DummyRepository;
import co.za.bbd.ars.service.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DummyServiceImpl implements DummyService {
    private DummyRepository repository;

    @Autowired
    public DummyServiceImpl(DummyRepository repository) {
        this.repository = repository;
    }

    @Override
    public DummyDomain save(DummyDomain dummyDomain) {
        return this.repository.save(dummyDomain);
    }

    @Override
    public Optional<DummyDomain> read(Integer ID) {
        return this.repository.findById(ID);
    }

    @Override
    public void delete(DummyDomain dummyDomain) {
        this.repository.delete(dummyDomain);
    }

    @Override
    public void deleteById(Integer ID) {
        this.repository.deleteById(ID);
    }

    @Override
    public List<DummyDomain> findAll() {
        return this.repository.findAll();
    }

}