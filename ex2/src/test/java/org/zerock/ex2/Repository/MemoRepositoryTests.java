package org.zerock.ex2.Repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
    @Test
    public void testSelect(){
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
    }

    @Test
    public void testUpdate(){
//        Memo memo = Memo.builder().mno(100L).memoText("Update Text").build();
//
//        System.out.println(memoRepository.save(memo));
    }
    @Test
    public void testDelete(){

//        Long mno = 100L;
//        //deleteById()
//        memoRepository.deleteById(mno);
//        System.out.println(memoRepository.findById(mno));

        //delete()
        Memo memo = Memo.builder().mno(99L).build();

        System.out.println(memo);

        memoRepository.delete(memo);

        System.out.println(memoRepository.findById(99L));
    }
}
