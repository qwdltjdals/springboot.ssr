package com.study.ssr.controller;

import com.study.ssr.model.Dvd;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DvdController {

    @GetMapping("/dvds")
    public String dvdListPage(Model model) {
        Dvd dvd = Dvd.builder()
                .title("테스트")
                .producer("테스트 제작자")
                .publisher("테스트 발행자")
                .build();
        Dvd dvd2 = Dvd.builder()
                .title("테스트")
                .producer("테스트 제작자2")
                .publisher("테스트 발행자2")
                .build();
        Dvd dvd3 = Dvd.builder()
                .title("테스트")
                .producer("테스트 제작자3")
                .publisher("테스트 발행자3")
                .build();
        model.addAttribute(dvd);
        model.addAttribute("names", List.of("김준일", "김준이", "김준삼")); // 리스트
        model.addAttribute("dvdList", List.of(dvd, dvd2, dvd3)); // 리스트
        model.addAttribute("title", "테스트 제목"); // 리터럴

        return "views/dvd_list"; // return이 String 이면
    }

//    @GetMapping("/dvds")
//    public ModelAndView dvdListPage() {
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("/views/dvd_list");
//        return mav; // return이 ModelAndView 객체
//    }

    @ResponseBody // view resolve로 가는게 아니라 바로 응답으로 감
    @GetMapping("/dvds/body")
    public String getViewName() {
        return "views/dvd_list";
    }

    @ResponseBody
    @GetMapping("/dvd")
    public Object getDvd() { // 리턴자료형 Dvd도 가능
        Dvd dvd = Dvd.builder().title("테스트").producer("테스트 제작자").publisher("테스트 발행사").build();
        Dvd dvd2 = Dvd.builder().title("테스트").producer("테스트 제작자2").publisher("테스트 발행사2").build();
        Dvd dvd3 = Dvd.builder().title("테스트").producer("테스트 제작자3").publisher("테스트 발행사3").build();

        return List.of(dvd, dvd2, dvd3);
    }

}
