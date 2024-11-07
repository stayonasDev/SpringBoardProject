package management.board.domain.board;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BoardAddDto {

    @NotBlank(message="제목을 입력하세요")
    private String title;

    @NotBlank(message="내용을 입력하세요")
    private String content;
}
