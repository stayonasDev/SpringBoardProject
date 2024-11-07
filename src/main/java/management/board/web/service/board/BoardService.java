package management.board.web.service.board;

import lombok.RequiredArgsConstructor;
import management.board.domain.board.Board;
import management.board.web.repository.board.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {

    private final BoardRepository boardRepository;

    public Board save(Board board) {
        return boardRepository.save(board);
    }

    public List<Board> findAll(){
        return boardRepository.findAll();
    }

    //제목으로 검색
    public List<Board> searchByTitle(String title) {
        return boardRepository.findByTitle(title);
    }

    //TODO
    public Optional<Board> findById(Long id) {
        return boardRepository.findById(id);
    }

    public Board update(Long id, Board updateBoard) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시판을 찾울 수 없습니다."));
        board.setTitle(updateBoard.getTitle());
        board.setContent(updateBoard.getContent());
        board.setNickname(updateBoard.getNickname());
        board.setUpdateDate(LocalDateTime.now());
        return boardRepository.save(board);
    }

    public void delete(Long id) {
        boardRepository.deleteById(id);
    }

    public void deleteAll(){
        boardRepository.deleteAll();
    }
}
