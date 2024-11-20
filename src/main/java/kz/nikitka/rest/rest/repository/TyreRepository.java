package kz.nikitka.rest.rest.repository;

import kz.nikitka.rest.rest.model.Tyre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TyreRepository extends JpaRepository<Tyre, Long> {
}