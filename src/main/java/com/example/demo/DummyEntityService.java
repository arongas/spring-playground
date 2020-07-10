package com.example.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Slf4j
@Service
@RequiredArgsConstructor
public class DummyEntityService {
    public final DummyEntityRepository dummyEntityRepository;

    @PostConstruct
    public void init() {
        dummyEntityRepository.save(DummyEntity.builder().name("dummy1").item("first").build());
        dummyEntityRepository.save(DummyEntity.builder().name("dummy2").item("first").item("second").build());
        dummyEntityRepository.save(DummyEntity.builder().name("dummy2").item("first").item("third").build());
    }


    public Page<DummyEntity> findAllByItemsIn(String... items) {
        return dummyEntityRepository.findAllByItemsIn(Pageable.unpaged(), Arrays.asList(items));
    }
}
