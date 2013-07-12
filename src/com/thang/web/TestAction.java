/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thang.web;

/**
 *
 * @author Administrator
 */
@Controller
public class TestAction {
    
    private TestService testService;
   
    @RequestMapping("/")
    public String index(){
        return "redirect:list";
    }
    
    public String list(Model model,Pages page){
        page=testService.query(new ActionValues(model.asMap()),page);
        model.addAttribute("result",page.getResult());
        return "/test/list";
    }
    
    @RequestMapping("form")
    public String form(Model model){
         return "/test/form";
    }
    
    public String insertOrUpdate(Model model){
        ActionValues values=new ActionValues(model.asMap());
        
        if(values.isNotEmpty("id")){
            testService.update(values);
        }else{
            testService.insert(values);
        }
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(@RequestParam("id")String id){
        testService.delete(id);
        return "redirect:list";
    }
    
    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }
    
    
    
    
}
