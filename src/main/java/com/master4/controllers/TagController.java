package com.master4.controllers;


import com.master4.entities.Tag;
import com.master4.exceptions.ResourceNotFoundException;
import com.master4.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping(value = {"/","/page/{id}"})
    public String home(@PathVariable(name="id",required = false) Optional<Integer> id, ModelMap model)
    {
            Page<Tag> pages = tagService.getAllTags(id, 1, "id");
            model.addAttribute("pageable", pages);
        return "tags/home";
    }


    @GetMapping("/add")
    public String add(ModelMap model,Tag tag) {
            model.addAttribute("tag", tag);
       return "tags/add";
    }

    @GetMapping("/add/{id}")
    public String edit(@PathVariable("id") long id, ModelMap model) throws ResourceNotFoundException {
        model.addAttribute("tag", tagService.findById(id));
        return "tags/add";
    }

    @PostMapping("/save")
    public String saveTag(@Valid @ModelAttribute("tag") Tag tag, BindingResult result, ModelMap model) throws ResourceNotFoundException {
        if(result.hasErrors()){
            model.addAttribute("tag",tag);
            return "tags/add";
        }
        tagService.save(tag);
        return "redirect:/tag/";
    }

    @GetMapping("/delete/{page}/{id}")
    public String delete(@PathVariable("page") long page,@PathVariable("id") long id, ModelMap model) throws ResourceNotFoundException {
        tagService.deleteById(id);
        return "redirect:/tag/page/"+page;
    }






}
