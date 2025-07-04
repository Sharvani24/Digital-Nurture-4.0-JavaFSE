@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SkillService skillService;

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Comment other test methods and run only this one
        testAddSkillToEmployee();
    }

    private void testGetEmployee() {
        Employee employee = employeeService.get(1);  // sample id
        LOGGER.debug("Employee:{}", employee);
        LOGGER.debug("Skills:{}", employee.getSkillList());  // This line will throw LazyInitializationException if fetch = LAZY
    }

    private void testAddSkillToEmployee() {
        int employeeId = 1; // Change to actual ID that exists
        int skillId = 2;    // Change to actual ID that exists

        Employee employee = employeeService.get(employeeId);
        Skill skill = skillService.get(skillId);

        Set<Skill> skillList = employee.getSkillList();
        skillList.add(skill); // Add new skill to employee

        employee.setSkillList(skillList);
        employeeService.save(employee);

        LOGGER.info("Skill added to employee successfully.");
    }
}
