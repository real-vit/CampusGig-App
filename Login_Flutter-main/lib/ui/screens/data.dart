class NavigationItem {
  String title;

  NavigationItem(this.title);
}

List<NavigationItem> getNavigationItemList() {
  return <NavigationItem>[
    NavigationItem("Projects"),
  ];
}

class Application {
  String position;
  String company;
  String status;
  String price;
  String logo;

  Application(this.position, this.company, this.status, this.price, this.logo);
}

/*List<Application> getApplications() {
  return <Application>[
    Application("Flutter UI / UX Designer", "Nike Inc.", "Delivered", "40",
        "assets/images/nike.png"),
    Application("Product Designer", "Google LLC", "Opened", "60",
        "assets/images/google.png"),
    Application("UI / UX Designer", "Uber Technologies Inc.", "Cancelled", "55",
        "assets/images/uber.png"),
    Application("Lead UI / UX Designer", "Apple Inc.", "Delivered", "80",
        "assets/images/apple.png"),
    Application("Flutter UI Designer", "Amazon Inc.", "Not selected", "60",
        "assets/images/amazon.jpg"),
  ];
}*/

enum Skill {
  java,
  python,
  javascript,
  uiUxDesign,
  docker,
  flutter,
  networkSecurity,
  machineLearning,
  sql,
  aws,
}

class Job {
  List<Skill> skill;
  String position;
  String count;
  String status;
  String price;
  String concept;
  String logo;

  Job(this.skill, this.position, this.count,this.status,this.price, this.concept,
      this.logo);
}

List<Job> getJobs() {
  return <Job>[
    Job([Skill.java, Skill.python], "", '10','true', "80,000",
        "Full-stack dev", "images/java.jpg"),
    Job(
        [Skill.javascript, Skill.uiUxDesign],
        "Front-end Developer",
        '20','false',
        "70,000",
        "UI/UX Design and Dev",
        "images/js.jpg"),
    Job(
        [Skill.docker, Skill.flutter],
        "Mobile App Developer",
        '8','true',
        "85,000",
        "Flutter App Dev",
        "images/docker.jpg"),
    Job(
        [Skill.networkSecurity, Skill.machineLearning],
        "Cybersecurity Analyst",
        '15','false',
        "90,000",
        "Network Security and Machine Learning",
        "images/ml.jpg"),
    Job([Skill.sql, Skill.java], "Database Developer", '9','true',
        "75,000", "SQL Database Development", "images/sql.jpg"),
    Job(
        [Skill.python, Skill.aws],
        "Cloud Solutions Architect",
        '32','true',
        "100,000",
        "AWS Cloud Solutions Architecture",
        "images/python.jpg"),
    Job(
        [Skill.javascript, Skill.uiUxDesign],
        "UI/UX Designer",
        '22','false',
        "80,000",
        "UI/UX Design and Front-end Development",
        "images/js.jpg"),
    Job(
        [Skill.flutter, Skill.machineLearning],
        "AI/ML Engineer",
        '19','false',
        "95,000",
        "Flutter App Development and Machine Learning",
        "images/flutter.jpg"),
    Job([Skill.sql, Skill.java], "Backend Developer", '34','true',
        "85,000", "Java Backend Development", "images/sql.jpg"),
    Job([Skill.docker, Skill.aws], "DevOps Engineer", '18','true',
        "90,000", "Docker and AWS DevOps", "images/docker.jpg")
  ];
}

List<String> getJobsRequirements() {
  return <String>[
    "Exceptional communication skills and team-working skills",
    "Know the principles of animation and you can create high fidelity prototypes",
    "Direct experience using Adobe Premiere, Adobe After Effects & other tools used to create videos, animations, etc.",
    "Good UI/UX knowledge",
  ];
}