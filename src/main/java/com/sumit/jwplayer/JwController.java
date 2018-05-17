package com.sumit.jwplayer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JwController {
    @RequestMapping(value="/jwplayer")
    public String jwplayer(){
        return "jwplayer";
    }
}
