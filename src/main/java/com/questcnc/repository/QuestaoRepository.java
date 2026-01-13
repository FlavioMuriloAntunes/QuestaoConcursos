package com.questcnc.repository;

import com.questcnc.model.Questao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestaoRepository extends JpaRepository<Questao, Long> {
    // No momento não precisa de métodos extras
}
