import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("teams", Team.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/team-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/teams", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      Team newTeam = new Team(name);
      model.put("template", "templates/team-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("teams", Team.all());
      model.put("template", "templates/teams.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  get("/teams/:id/members/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Team team = Team.find(Integer.parseInt(request.params(":id")));
      model.put("team", team);
      model.put("template", "templates/team-members-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

      get("/teams/:id", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        Team team = Team.find(Integer.parseInt(request.params(":id")));
        model.put("team", team);
        model.put("template", "templates/team.vtl");
        return new ModelAndView(model, layout);
    },  new VelocityTemplateEngine());

    get("/teams/:id/members/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Team team = Team.find(Integer.parseInt(request.params(":id")));
      model.put("team", team);
      model.put("template", "templates/team-members-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/members", (request,response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Team team = Team.find(Integer.parseInt(request.queryParams("teamId")));
      String name = request.queryParams("name");
      Member newMember = new Member(name);
      team.addMember(newMember);
      model.put("team", team);
      model.put("template", "templates/team-members-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  //   get("tasks/new", (request, response) -> {
  //     Map<String, Object> model = new HashMap<String, Object>();
  //     model.put("template", "templates/task.vtl");
  //     return new ModelAndView(model, layout);
  //   }, new VelocityTemplateEngine());
  //
  //   get("teams/:id/tasks", (request, response) -> {
  //     Map<String, Object> model = new HashMap<String, Object>();
  //     Category category = Category.find(Integer.parseInt(request.params(":id")));
  //     model.put("category", category);
  //
  //     //here
  //     model.put("tasksInCategory", category.getTasks()); //category that we just found, will return list of tasks
  //     model.put("template", "templates/tasks.vtl");
  //     return new ModelAndView(model, layout);
  //   }, new VelocityTemplateEngine());
  //
  //   post("/tasks", (request,response) -> {
  //     Map<String, Object> model = new HashMap<String, Object>();
  //
  //     Category category = Category.find(Integer.parseInt(request.queryParams("categoryId")));
  //
  //     String description = request.queryParams("description");
  //     Task newTask = new Task(description);
  //
  //     category.addTask(newTask);
  //
  //     model.put("category", category);
  //     model.put("template", "templates/category-tasks-success.vtl");
  //     return new ModelAndView(model, layout);
  //   }, new VelocityTemplateEngine());
  //
  //   get("/teams/:id/tasks/:tid", (request, response) -> {
  //     HashMap<String, Object> model = new HashMap<String, Object>();
  //     Task task = Task.find(Integer.parseInt(request.params(":tid")));
  //     Category category = Category.find(Integer.parseInt(request.params(":id")));
  //     model.put("task", task);
  //     model.put("category", category);
  //     model.put("template", "templates/task.vtl");
  //     return new ModelAndView(model, layout);
  //   }, new VelocityTemplateEngine());
  //
  //   get("/teams/new", (request, response) -> {
  //     Map<String, Object> model = new HashMap<String, Object>();
  //     model.put("template", "templates/category-form.vtl");
  //     return new ModelAndView(model, layout);
  //   }, new VelocityTemplateEngine());
  //
  //   post("/teams", (request, response) -> {
  //     Map<String, Object> model = new HashMap<String, Object>();
  //     String name = request.queryParams("name");
  //     Category newCategory = new Category(name);
  //     model.put("template", "templates/category-success.vtl");
  //     return new ModelAndView(model, layout);
  //   }, new VelocityTemplateEngine());
  //
  //   get("/teams", (request, response) -> {
  //     Map<String, Object> model = new HashMap<String, Object>();
  //     model.put("teams", Category.all());
  //     model.put("template", "templates/teams.vtl");
  //     return new ModelAndView(model, layout);
  //   }, new VelocityTemplateEngine());
  //


  }
}
