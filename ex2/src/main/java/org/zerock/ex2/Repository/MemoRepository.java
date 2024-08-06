package org.zerock.ex2.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zerock.ex2.Entity.Memo;

@Repository
public interface MemoRepository extends JpaRepository<Memo, Long> {

}
