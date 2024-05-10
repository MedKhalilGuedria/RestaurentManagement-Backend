package app.spring.Restaurent.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import app.spring.Restaurent.models.Table;

public interface TableRepository extends JpaRepository<Table, Long> {
}
