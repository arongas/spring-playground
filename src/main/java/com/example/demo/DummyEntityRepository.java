package com.example.demo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;
import java.util.List;
import java.util.UUID;


public interface DummyEntityRepository extends JpaRepository<DummyEntity, Long> {

    Page<DummyEntity> findAllByItemsIn(Pageable pageable,List<String> items);
}
