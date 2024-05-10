package app.spring.Restaurent.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import app.spring.Restaurent.models.TableEntity;

public interface TableRepository extends JpaRepository<TableEntity, Long> {
}
