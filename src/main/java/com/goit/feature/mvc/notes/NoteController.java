package com.goit.feature.mvc.notes;

import com.goit.feature.mvc.notes.dto.NoteDto;
import com.goit.feature.mvc.security.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;
//    private final SecurityService securityService;

    @GetMapping("/example")
    public ModelAndView getExample() {
        return new ModelAndView("notes/example");
    }

    @GetMapping("/list")
    public ModelAndView getList() {
        ModelAndView result = new ModelAndView("notes/list");
        List<NoteDto> notes = noteService.getNoteList().stream()
                .map(NoteDto::fromNote)
                .collect(Collectors.toList());
        result.addObject("notes", notes);
        result.addObject("username", "Stas");
        return result;
    }

    @PostMapping("/delete")
    public RedirectView delete(@RequestParam(name = "noteId") long noteId) {
        noteService.deleteById(noteId);
        return new RedirectView("list");
    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam(name = "id") long id) {
        ModelAndView result = new ModelAndView("notes/edit");
        Note note = noteService.getById(id);
        result.addObject("note", NoteDto.fromNote(note));
//        result.addObject("username", securityService.getUsername());
        return result;
    }

    @PostMapping("/edit")
    public RedirectView saveUpdatedNote(NoteDto noteDto) {
        noteService.add(noteDto.toNote());
        return new RedirectView("list");
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView result = new ModelAndView("notes/create");
//        result.addObject("username", securityService.getUsername());
        return result;
    }


    @PostMapping("/create")
    public RedirectView saveCreatedNote(NoteDto noteDto) {
        noteService.add(noteDto.toNote());
        return new RedirectView("list");
    }
}
