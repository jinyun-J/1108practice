package org.example.wiseSaying.controller;

import org.example.Container;
import org.example.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import org.example.wiseSaying.service.WiseSayingService;

public class WiseSayingController {
    private final WiseSayingService wiseSayingService;
    public WiseSayingController() {
        wiseSayingService = new WiseSayingService();
    }
    public void write() {
        System.out.print("명언 : ");
        String content = Container.getScanner().nextLine().trim();
        System.out.print("작가 : ");
        String author = Container.getScanner().nextLine().trim();

        long id = wiseSayingService.write(content, author);

        System.out.printf("%d번 명언이 등록되었습니다.", id);
    }

    public void list() {
        List<WiseSaying> wiseSayings = wiseSayingService.findByAll();

        System.out.println("번호 / 작가 / 명언");
        System.out.println("목록갯수는 " + wiseSayings.size() + "입니다");
        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayings.get(i);
            System.out.printf("%d, %s, %s\n", wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent());
        }

    }

    public void remove() {
        System.out.printf("삭제 번호) ");
        long id = Long.parseLong(Container.getScanner().nextLine());

        // aticleList 입력받은 id 값이랑 같은 id 를 가지고있는 wiseSaying 객체 찾기
        WiseSaying wiseSaying = wiseSayingService.findById(id);

        // 작성자만 작성할 수 있도록
        // 게시글 존재하지 않을 경우
        if (wiseSaying == null) {
            System.out.println("게시글이 존재하지 않습니다.");
            return;
        }

        wiseSayingService.remove(wiseSaying);
        System.out.println(id + "번 명언이 삭제되었습니다");
    }
    public void modify() {
        System.out.printf("수정 번호) ");
        long id = Long.parseLong(Container.getScanner().nextLine());

        // aticleList 입력받은 id 값이랑 같은 id 를 가지고있는 wiseSaying 객체 찾기
        WiseSaying wiseSaying = wiseSayingService.findById(id);

        // 작성자만 작성할 수 있도록
        // 게시글 존재하지 않을 경우
        if (wiseSaying == null) {
            System.out.println("게시글이 존재하지 않습니다.");
            return; // 어떻게 명령으로 돌아기는지 디버깅해봤는데 모르겠음
        }
        System.out.printf("기존 작가) %s \n",wiseSaying.getAuthor());
        String author = Container.getScanner().nextLine();
        wiseSaying.setAuthor(author);

        System.out.printf("기존 명언) %s \n",wiseSaying.getContent());
        String content = Container.getScanner().nextLine();
        wiseSaying.setContent(content);

        wiseSayingService.modify(wiseSaying, author, content);

        System.out.println(id + "번 명언이 수정되었습니다");
    }

}


