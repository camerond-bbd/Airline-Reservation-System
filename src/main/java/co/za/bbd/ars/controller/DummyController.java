package co.za.bbd.ars.controller;

import co.za.bbd.ars.model.DummyDomain;
import co.za.bbd.ars.factory.DummyFactory;
import co.za.bbd.ars.service.impl.DummyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/airline-system/dummy")
public class DummyController {
    private final DummyServiceImpl dummyService;

    @Autowired
    public DummyController(DummyServiceImpl service) {
        this.dummyService = service;
    }

    @PostMapping("save")
    public ResponseEntity<DummyDomain> save(@Valid @RequestBody DummyDomain dummyDomain) {
        DummyDomain saveDummyDomain =  DummyFactory.createDummyDomain(dummyDomain.getTableId(), dummyDomain.getTableColumn());
        return ResponseEntity.ok(dummyService.save(saveDummyDomain));
    }

    @GetMapping("read/{id}")
    public ResponseEntity<DummyDomain> read(@PathVariable Integer id) {
        var dummyDomain = this.dummyService.read(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Dummy Not Found"));
        return ResponseEntity.ok(dummyDomain);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(DummyDomain dummyDomain) {
        this.dummyService.delete(dummyDomain);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id) {
        this.dummyService.deleteById(id);
        return ResponseEntity.ok(true);
    }

    @GetMapping("all")
    public ResponseEntity<List<DummyDomain>> findAll() {
        List<DummyDomain> dummyDomainList = this.dummyService.findAll();
        return ResponseEntity.ok(dummyDomainList);
    }
}
