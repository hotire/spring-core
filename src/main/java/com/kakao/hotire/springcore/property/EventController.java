package com.kakao.hotire.springcore.property;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/event")
@RestController
public class EventController {

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
       webDataBinder.registerCustomEditor(Event.class, new EventEditor());
    }

    @GetMapping("/{event}")
    public ResponseEntity getEvent(@PathVariable Event event) {
        return ResponseEntity.ok().body(event);
    }
}
