package org.zerock.ex2.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_memo")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "SEQ_MEMO_ID", allocationSize = 1)
    private Long mno;

    @Column(length = 200, nullable = false)
    private String memoText;

    private String id;

    private String name;
}
