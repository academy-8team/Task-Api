/**
 * packageName :  com.nhnacademy.project.controller
 * fileName : ProjectController
 * author :  ichunghui
 * date : 2023/06/02 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023/06/02                ichunghui             최초 생성
 */

@RequiredArgsConstructor
@RestController
public class ProjectController {
    private final ProjectService projectService;

//    @GetMapping("/project")
//    public List<ProjectRespondDto> getProjectList(@RequestParam(name = "page") int page) {
//        return projectMemberService.getProjects(page);
//    }

    @PostMapping("/project/create/{memberNum}")
    public Optional<ProjectRespondDto> createProject(@RequestBody ProjectRequestDto projectRequestDto,
                                                     @PathVariable(name = "memberNum") Long memberNum) {
        return projectService.makeProject(projectRequestDto, memberNum);
    }

    @GetMapping("/project/{projectNum}")
    public Optional<ProjectRespondDto> getProject(@PathVariable(name = "projectNum") Long projectNum) {
        return projectService.getProjectByProjectNum(projectNum);
    }
}
