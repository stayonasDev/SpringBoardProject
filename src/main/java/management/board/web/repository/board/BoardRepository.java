package management.board.web.repository.board;


import management.board.domain.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAll();

    List<Board> findByTitle(String title);

}
