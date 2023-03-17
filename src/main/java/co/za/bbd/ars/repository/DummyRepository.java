package co.za.bbd.ars.repository;

import co.za.bbd.ars.model.DummyDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DummyRepository extends JpaRepository<DummyDomain, Integer> {

}
