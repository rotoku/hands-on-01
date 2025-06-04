package br.com.kumabe.handson01.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataApoliceRepository extends JpaRepository<ApoliceEntity, Integer> {
}
