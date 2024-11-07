package management.board.web.controller.board;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import management.board.domain.board.Board;
import management.board.domain.board.BoardAddDto;
import management.board.web.service.board.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping()
    public String home(Model model){
        List<Board> boardList =  boardService.findAll();
        model.addAttribute("boardList", boardList);
        return "board/boardHome";
    }

    @GetMapping("/boardForm")
    public String board(Model model) {
        model.addAttribute("board", new Board());
        return "board/boardForm";
    }

    @PostMapping("/boardForm")
    public String boardSave(@Validated @ModelAttribute("boardAddDto") BoardAddDto boardDto
            , BindingResult bindingResult
            , RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            log.info("boardSave Error = {}", bindingResult);
            return "board/boardForm";
        }

        Board board = new Board();
        board.setTitle(boardDto.getTitle());
        board.setContent(boardDto.getContent());
        //TODO
//        board.setNickname();
//        board.setAuthId();
//        board.setCreateDate(new);

        redirectAttributes.addAttribute("게시판 등록 완료");
        boardService.save(board);
        return "redirect:/boarder";
    }

    @GetMapping("/{boardId}")


    @PostConstruct
    public void init() {
        boardService.deleteAll();
        Board board1 = new Board("첫 게시글", "내용 1", "author1", "작성자1");
        Board board2 = new Board("첫 게시글", "내용 2", "author2", "작성자2");
        boardService.save(board1);
        boardService.save(board2);
    }

}
