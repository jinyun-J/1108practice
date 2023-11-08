package org.example.wiseSaying.controller;

import org.example.Container;
import org.example.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingController {
    long lastWiseSayingId = 0;
    List<WiseSaying> wiseSayings = new ArrayList<>();

    public void write() {
        long id = lastWiseSayingId + 1; // id == 1

        System.out.print("명언 : ");
        String content = Container.getScanner().nextLine().trim();
        System.out.print("작가 : ");
        String author = Container.getScanner().nextLine().trim();
        lastWiseSayingId = id; //lW == 1
        WiseSaying wiseSaying = new WiseSaying(lastWiseSayingId, author, content);
        wiseSayings.add(wiseSaying);
        System.out.printf("%d번 명언이 등록되었습니다.", lastWiseSayingId);
    }

    public void list() {
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
        WiseSaying wiseSaying = this.getWiseSayingFindId(id);

        // 작성자만 작성할 수 있도록
        // 게시글 존재하지 않을 경우
        if (wiseSaying == null) {
            System.out.println("게시글이 존재하지 않습니다.");
            return;
        }

        wiseSayings.remove(wiseSaying);
        System.out.println(id + "번 명언이 삭제되었습니다");
    }
    public void modify() {
        System.out.printf("수정 번호) ");
        long id = Long.parseLong(Container.getScanner().nextLine());

        // aticleList 입력받은 id 값이랑 같은 id 를 가지고있는 wiseSaying 객체 찾기
        WiseSaying wiseSaying = this.getWiseSayingFindId(id);

        // 작성자만 작성할 수 있도록
        // 게시글 존재하지 않을 경우
        if (wiseSaying == null) {
            System.out.println("게시글이 존재하지 않습니다.");
            return;
        }
        System.out.printf("기존 작가) %s \n",wiseSaying.getAuthor());
        String author = Container.getScanner().nextLine();
        wiseSaying.setAuthor(author);

        System.out.printf("기존 명언) %s \n",wiseSaying.getContent());
        String content = Container.getScanner().nextLine();
        wiseSaying.setContent(content);
        System.out.println(id + "번 명언이 수정되었습니다");
    }

    private WiseSaying getWiseSayingFindId(long lastWiseSayingId) {
        for (int i = 0; i < wiseSayings.size(); i++) {
            WiseSaying wiseSaying = wiseSayings.get(i);
            if (wiseSaying.getId() == lastWiseSayingId) {
                return wiseSaying;
            }
        }
        return null;
    }
}


