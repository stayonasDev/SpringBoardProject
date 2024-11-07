package management.board.domain.member;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "members") //테이블 이름
@Getter
@Setter
//TODO
// ID PWD만 분리할지 하나의 테이블을 사용할지
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String memberId; //authId

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    private LocalDateTime birthday;

    @Column(nullable = false)
    private String username;


}
