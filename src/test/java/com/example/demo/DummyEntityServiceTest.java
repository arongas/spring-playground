package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DummyEntityServiceTest {

    @Autowired
    private DummyEntityService dummyEntityService;

    @Test
    void fetchEntityByListContent() {
        Page<DummyEntity> first = dummyEntityService.findAllByItemsIn("first", "second");
        assertThat(first.getSize()).isEqualTo(1);
    }
}