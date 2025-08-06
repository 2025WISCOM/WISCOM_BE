package wiscom.backend.domain;

import jakarta.persistence.*;
import lombok.*;
import wiscom.backend.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Guestbook extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 작성자 이름
    @Column(name = "author", nullable = false)
    private String author;

    // 받는자 이름
    @Column(name = "recipient", nullable = false)
    private String recipient;

    // 내용 (최대 136자까지 가능)
    @Column(name = "content", length = 136)
    private String content;

}
