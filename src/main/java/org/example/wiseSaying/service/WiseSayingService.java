package org.example.wiseSaying.service;

import org.example.wiseSaying.entity.WiseSaying;
import org.example.wiseSaying.repository.WiseSayingRepository;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {
    WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();
    public long write(String content, String author) {
        return this.wiseSayingRepository.write(content, author);
    }

    public List<WiseSaying> findByAll() {
        return wiseSayingRepository.findByAll();
    }
    public void remove (WiseSaying wiseSaying){
        this.wiseSayingRepository.remove(wiseSaying);
    }

    public void modify(WiseSaying wiseSaying, String author, String content) {
        this.wiseSayingRepository.modify(wiseSaying, author, content);
    }

    public WiseSaying findById(long id) {
        return this.wiseSayingRepository.findById(id);
    }
}
