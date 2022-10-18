package oit.is.z1661.group.lec04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.ModelMap;
import oit.is.z1661.group.lec04.model.Chamber;
import oit.is.z1661.group.lec04.model.ChamberMapper;

@Controller
@RequestMapping("/sample4")
public class Sample41Controller {

  @Autowired
  ChamberMapper chamberMapper;

  @GetMapping("step1")
  public String sample41() {
    return "sample41.html";
  }

  /**
   * @param id
   * @param model
   * @return
   */
  @GetMapping("step2/{id}")
  public String sample42(@PathVariable Integer id, ModelMap model) {
    Chamber chamber2 = chamberMapper.selectById(id);
    model.addAttribute("chamber2", chamber2);

    return "sample41.html";
  }

}
