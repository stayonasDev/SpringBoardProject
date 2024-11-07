package management.board.web.controller.board;


import lombok.RequiredArgsConstructor;
import management.board.domain.board.Board;
import management.board.web.service.board.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
/**
 * TODO LIST
 */
public class BoardControllerAPI {

    private final BoardService boardService;

    @GetMapping
    public ResponseEntity<List<Board>> getAllBoards() {
        List<Board> boards = boardService.findAll();
        return ResponseEntity.ok(boards);
    }

    @PostMapping
    public ResponseEntity<Board> createBoard(@RequestBody Board board) {
        Board saveBoard = boardService.save(board);
        return ResponseEntity.ok(saveBoard);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Board>> searchBoard(@RequestParam String title) {
        List<Board> boards = boardService.searchByTitle(title);
        return ResponseEntity.ok(boards);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Board> getBoard(@PathVariable Long id) {
        Board board = boardService.findById(id)
                .orElseThrow(() -> new RuntimeException("게시판을 찾을 수 없습니다."));
        return ResponseEntity.ok(board);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Board> updateBoard(@PathVariable Long id, @RequestBody Board board) {
        Board updateBoard = boardService.update(id, board);
        return ResponseEntity.ok(updateBoard);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long id) {
        boardService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
