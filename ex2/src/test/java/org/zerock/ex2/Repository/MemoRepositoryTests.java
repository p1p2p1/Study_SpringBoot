package org.zerock.ex2.Repository;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.ex2.Entity.Memo;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;


@SpringBootTest
public class MemoRepositoryTests {
    @Autowired
    MemoRepository memoRepository;

    //INSERT
//    @Test
//    public void testInsertDummies(){
//        IntStream.rangeClosed(1,100).forEach(i -> {
//            Memo memo = Memo.builder().memoText("Sample..." + i).build();
//            memoRepository.save(memo); //save() 메서드
//        });
//    }

    //SELECT
//    @Test
//    public void testSelect(){
//        Long mno = 100L;

//        //findById()
//        Optional<Memo> result = memoRepository.findById(mno);
//        System.out.println(result);

//        //findAll()
//        List<Memo> result = memoRepository.findAll();
//
//        for (Memo memo : result) {
//            System.out.println(memo);
//        }

//      //count()
//        System.out.println(memoRepository.count());
//    }

    //UPDATE
//    @Test
//    public void testUpdate(){
//        Memo memo = Memo.builder().mno(100L).memoText("Update Text").build();
//
//        System.out.println(memoRepository.save(memo));
//    }

    //DELETE
//    @Test
//    public void testDelete(){

//        Long mno = 100L;
//        //deleteById()
//        memoRepository.deleteById(mno);
//        System.out.println(memoRepository.findById(mno));

//
//        Memo memo = Memo.builder().mno(99L).build();
//
//        System.out.println(memo);
//
//        memoRepository.delete(memo);
//
//        System.out.println(memoRepository.findById(99L));
//    }

    //Paging
//    @Test
//    public void testPageDefault() {
//        Pageable pageable = PageRequest.of(0, 10);
//        Page<Memo> result1 = memoRepository.findAll(pageable);
//
//        System.out.println(result1);
//
//        System.out.println("----------------------------");
//
//        System.out.println(result1.getTotalPages()); //총 페이지 수
//
//        System.out.println(result1.getTotalElements()); //총 element 수
//
//        System.out.println(result1.getNumber()); //현재 페이지 번호
//
//        System.out.println(result1.getSize()); //페이지당 데이터 개수
//
//        System.out.println(result1.hasNext()); //다음 페이지 여부
//
//        System.out.println(result1.isFirst()); //시작 페이지 여부
//
//        System.out.println("--------------------------");
//
//        for(Memo memo : result1.getContent()){
//            System.out.println(memo);
//        }
//    }

    //sort
//    @Test
//    public void testSort(){
//        Sort sort1 = Sort.by("mno").ascending();
//
//        Pageable pageable = PageRequest.of(0, 10, sort1);
//
//        Page<Memo> result = memoRepository.findAll(pageable);
//
//        result.get().forEach(memo -> {
//            System.out.println(memo);
//        });
//    }
    @Test
    @Transactional
    @Commit
    public void testQueryMethods(){
        //findByMnoBetween
//        List<Memo> list1 = memoRepository.findByMnoBetweenOrderByMnoDesc(70L, 80L);
//
//        for(Memo memo : list1){
//            System.out.println(memo);
//        }

        //findByMno -> pageable 활용하여 정렬
//        Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").descending());
//
//        Page<Memo> list2 = memoRepository.findByMnoBetween(70L, 80L, pageable);
//
//        for(Memo memo : list2){
//            System.out.println(memo);
//        }
        //deleteMemoByMnoLessThan -> DELETE 문
//         memoRepository.deleteMemoByMnoLessThan(10L);

//        List<Memo> list3 = memoRepository.getListDesc();
//
//        for(Memo memo : list3){
//            System.out.println(memo);
//        }

        Optional<Memo> memoEx = memoRepository.findById(11L);
        System.out.println(memoEx.get().getMemoText());
        memoEx.get().setMemoText("바보, 멍청이");
//        System.out.println(memoText);
//
//        //Update 문 @Query 예시
        memoRepository.updateMemoText(memoEx.get());
//
        memoEx = memoRepository.findById(11L);
        System.out.println(memoEx.get().getMemoText());
    }
}