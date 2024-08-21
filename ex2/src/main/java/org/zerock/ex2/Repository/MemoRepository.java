package org.zerock.ex2.Repository;


import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.zerock.ex2.Entity.Memo;

import java.util.List;

@Repository
public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findByMnoBetweenOrderByMnoDesc(Long from, Long to);

    Page<Memo> findByMnoBetween(Long from, Long to, Pageable page);

    void deleteMemoByMnoLessThan(Long num);

    @Query("SELECT m.memoText FROM Memo m WHERE m.mno = :mno")
    String getMemoText(@Param("mno") Long mno);

    @Query("SELECT m FROM Memo m WHERE m.mno = 11 order by m.mno desc")
    List<Memo> getListDesc();

//    @Transactional
//    @Modifying
//    @Query("UPDATE Memo m set m.memoText = :memoText WHERE m.mno = :mno")
//    int updateMemoText(@Param("mno") Long mno, @Param("memoText")String memoText);


    //@Query에서 파라미터가 많아지면 #으로 객체를 사용 가능
    @Transactional
    @Modifying
    @Query("UPDATE Memo m SET m.memoText = :#{#param.memoText} WHERE m.mno = :#{#param.mno}")
    int updateMemoText(@Param("param") Memo memo);
}
