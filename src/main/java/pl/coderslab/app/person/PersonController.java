package pl.coderslab.app.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonDao personDao;

    @RequestMapping("/save")
    @ResponseBody
    public String create(@RequestParam(name="login") String login,
                         @RequestParam(name="password") String password,
                         @RequestParam(name="email") String email){
        Person person = new Person();
        person.setLogin(login);
        person.setPassword(password);
        person.setEmail(email);

        personDao.save(person);
        return "Dodano użytkownika: ID: " + person.getId() + ", login: " + person.getLogin() + ", email: " + person.getEmail();
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public String readById(@PathVariable(name="id") long id){
        personDao.findById(id);
        return "ID: " + personDao.findById(id).getId() + ", login: " + personDao.findById(id).getLogin() + ", email: " + personDao.findById(id).getEmail();
    }

    @RequestMapping("/edit/{id}")
    @ResponseBody
    public String update(@PathVariable(name="id") long id,
                         @RequestParam(name="login") String login,
                         @RequestParam(name="password") String password,
                         @RequestParam(name="email") String email){
        Person person = personDao.findById(id);
        person.setLogin(login);
        person.setPassword(password);
        person.setEmail(email);

        personDao.edit(person);
        return "Zmodyfikowano użytkownika: " + person.getLogin();
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete(@PathVariable(name="id") long id){
        Person person = personDao.findById(id);
        personDao.delete(person);
        return "Id usuniętego użytkownika to:" + person.getId();
    }
}
