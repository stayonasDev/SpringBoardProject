package management.board.domain.board;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "board")
@Getter
@Setter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false, name="auth_id")
    private String authId; //작성자 ID

    @Column(nullable = false)
    private String nickname;

    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public Board(){
        this.createDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
    }
    public Board(String title, String content, String authId, String nickname) {
        this.title = title;
        this.content = content;
        this.authId = authId;
        this.nickname = nickname;
        this.createDate = LocalDateTime.now();
        this.updateDate = LocalDateTime.now();
    }

    public void setCreateDate(LocalDateTime localDateTime) {
        throw new UnsupportedOperationException();
    }
}